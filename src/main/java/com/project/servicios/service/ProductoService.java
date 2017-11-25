/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.servicios.service;

import com.project.servicios.beans.ProductosFacadeLocal;
import com.project.servicios.entity.Productos;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Jaime
 */
@WebService(serviceName = "ProductoService")
public class ProductoService {
    
    @EJB
    private ProductosFacadeLocal productosFacade;

    /**
     * Web service operation
     * @param producto
     * @return message
     */
    @WebMethod(operationName = "insert")
    public String insert(@WebParam(name = "producto") Productos producto) {
        productosFacade.create(producto);
        return producto.getId() != null ? "Producto registrado" : "Producto no registrado";
    }

    @WebMethod(operationName = "update")
    public String update(@WebParam(name = "producto") Productos producto) {
        productosFacade.edit(producto);
        return "Producto actualizado con exito";
    }
    
    @WebMethod(operationName = "delete")
    public String remove(@WebParam(name = "producto") Productos producto) {
        productosFacade.remove(producto);
        return producto.getId() == null ? "Producto eliminado" : "No fue posible eliminar el producto";
    }

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "find")
    public List<Productos> find() {
        return productosFacade.findAll();
    }
    
}
