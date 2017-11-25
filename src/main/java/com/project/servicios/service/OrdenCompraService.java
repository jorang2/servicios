/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.servicios.service;

import com.project.servicios.beans.DetalleOrdenCompraFacadeLocal;
import com.project.servicios.beans.DetalleSolicitudFacadeLocal;
import com.project.servicios.beans.InventarioFacadeLocal;
import com.project.servicios.beans.OrdenCompraFacadeLocal;
import com.project.servicios.beans.SolicitudesFacadeLocal;
import com.project.servicios.entity.DetalleOrdenCompra;
import com.project.servicios.entity.DetalleSolicitud;
import com.project.servicios.entity.Inventario;
import com.project.servicios.entity.OrdenCompra;
import com.project.servicios.entity.Proveedores;
import com.project.servicios.entity.Solicitudes;
import com.project.servicios.utility.Constantes;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Jaime
 */
@WebService(serviceName = "OrdenCompraService")
public class OrdenCompraService {
    @EJB
    private DetalleSolicitudFacadeLocal detalleSolicitudFacade;
    @EJB
    private SolicitudesFacadeLocal solicitudesFacade;

    @EJB
    private DetalleOrdenCompraFacadeLocal detalleOrdenCompraFacade;

    @EJB
    private OrdenCompraFacadeLocal ordenCompraFacade;

    @EJB
    private InventarioFacadeLocal inventarioFacade;

    /**
     * This is a sample web service operation
     *
     * @param orden
     * @param detalle
     * @return
     */
    @WebMethod(operationName = "registrarOrdenCompra")
    public String registrarOrdenCompra(@WebParam(name = "orden") OrdenCompra orden, List<DetalleOrdenCompra> detalle) {
        int cantidadDisponible = 0;
        int diferencia = 0;
        Proveedores proveedor = new Proveedores(1);

        orden.setFecha(new Date());
        orden.setEstado(Constantes.ESTADO_SOLICITADO);
        ordenCompraFacade.create(orden);

        List<DetalleSolicitud> detalleSolicitud = new ArrayList<>();
        for (DetalleOrdenCompra detalle1 : detalle) {
            detalle1.setOrdenCompraId(orden);
            Inventario inventario = inventarioFacade.findByProduct(detalle1.getProductoId().getId());
            cantidadDisponible = inventario.getCantidad();
            //se verifica si hay disponibilidad de este producto en el stock 
            if (cantidadDisponible >= detalle1.getCantidad()) {
                inventarioFacade.updateProduct(detalle1.getProductoId(), detalle1.getCantidad(), Constantes.DESCONTAR);
                detalle1.setEstado(Constantes.ESTADO_TRAMITADO);
            } else {
                System.out.println("Llego aca!!!");
                detalle1.setEstado(Constantes.ESTADO_SOLICITADO);
                //se verifica si en el stock de ese producto es 0 para solicitar la totalidad de los productos al proveedor
                if (inventario.getCantidad() == 0) {
                    detalleSolicitud.add(new DetalleSolicitud(detalle1.getCantidad(), detalle1.getProductoId().getId()));
                } else {
                    //si hay algunos se descuentan del stock y el resto se solicitan al proveedor 
                    diferencia = detalle1.getCantidad() - cantidadDisponible;
                    inventarioFacade.updateProduct(detalle1.getProductoId(), cantidadDisponible, Constantes.DESCONTAR);
                    detalleSolicitud.add(new DetalleSolicitud(diferencia, detalle1.getProductoId()));
                }
            }
            detalleOrdenCompraFacade.create(detalle1);
        }

        if (detalleSolicitud.size() > 0) {
            Solicitudes solicitud = new Solicitudes();
            solicitud.setProveedoId(proveedor);
            solicitud.setEstado(Constantes.ESTADO_REGISTRADO);
            solicitud.setFechaSolicitud(new Date());
            System.out.println(solicitud);
            solicitudesFacade.create(solicitud);
            for (DetalleSolicitud detalle1 : detalleSolicitud) {
                System.out.println(detalle);
                detalle1.setSolicitudId(solicitud);
                detalleSolicitudFacade.create(detalle1);
            }
        }

        return detalleSolicitud.size() > 0 ? "Compra registrada. Los productos falantes fueron solicitados al proveedor" : "Compra registrada";
    }
}
