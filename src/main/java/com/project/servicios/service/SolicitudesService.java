/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.servicios.service;

import com.project.servicios.beans.DetalleSolicitudFacadeLocal;
import com.project.servicios.beans.InventarioFacadeLocal;
import com.project.servicios.beans.ProveedoresFacadeLocal;
import com.project.servicios.beans.SolicitudesFacadeLocal;
import com.project.servicios.entity.DetalleSolicitud;
import com.project.servicios.entity.Inventario;
import com.project.servicios.entity.Proveedores;
import com.project.servicios.entity.Solicitudes;
import com.project.servicios.utility.Constantes;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Jaime
 */
@WebService(serviceName = "SolicitudesService")
@Stateless
public class SolicitudesService {
    @EJB
    private ProveedoresFacadeLocal proveedoresFacade;

    @EJB
    private InventarioFacadeLocal inventarioFacade;

    @EJB
    private DetalleSolicitudFacadeLocal detalleSolicitudFacade;

    @EJB
    private SolicitudesFacadeLocal solicitudesFacade;

    /**
     * Web service operation
     *
     * @param solicitud
     * @param detalle
     * @return message
     */
    @WebMethod(operationName = "create")
    public String registrarSolicitud(@WebParam(name = "solicitud") Solicitudes solicitud, @WebParam(name = "detalle") List<DetalleSolicitud> detalle) {
        solicitud.setEstado(Constantes.ESTADO_REGISTRADO);
        solicitud.setFechaSolicitud(new Date());
        solicitudesFacade.create(solicitud);
        int count = 0;
        for (DetalleSolicitud detalle1 : detalle) {
            System.out.println(detalle);
            detalle1.setSolicitudId(solicitud);
            detalleSolicitudFacade.create(detalle1);
        }
        return  "Solicitud registrada";
    }

    @WebMethod(operationName = "tramitar")
    public String tramitarSolicitud(@WebParam(name = "solicitud") int solicitudId) {
        List<DetalleSolicitud> detalle = detalleSolicitudFacade.findBySolicitud(solicitudId);
        Solicitudes solicitud = solicitudesFacade.find(solicitudId);
        if (solicitud.getEstado().equals(Constantes.ESTADO_TRAMITADO)) {
            return "La solicitud ya fue tramitada anteriormente";
        } else {
            int count = 0;
            for (DetalleSolicitud detalle1 : detalle) {
                if (inventarioFacade.updateProduct(detalle1.getProductoId(), detalle1.getCantidad(), Constantes.ADICIONAR)) {
                    count++;
                }else{
                    Inventario nuevo = new Inventario();
                    nuevo.setCantidad(detalle1.getCantidad());
                    nuevo.setProductoId(detalle1.getProductoId());
                    nuevo.setTipo("terminado");
                    inventarioFacade.create(nuevo);
                }
            }
            if (count > 0) {
                solicitud.setEstado(Constantes.ESTADO_TRAMITADO);
                solicitudesFacade.edit(solicitud);
            }
            return count > 0 ? "solicitud tramitada" : "no fue posible tramitar su solicitud";
        }
    }

    @WebMethod(operationName = "obtenerProveedores")
    public List<Proveedores> obtenerProveedores() {
        return proveedoresFacade.findAll();
    }
    
}
