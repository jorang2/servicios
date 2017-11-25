/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.servicios.beans;

import com.project.servicios.entity.Inventario;
import com.project.servicios.entity.Productos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jaime
 */
@Stateless
public class InventarioFacade extends AbstractFacade<Inventario> implements InventarioFacadeLocal {
    @PersistenceContext(unitName = "com.project_Servicios_war_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InventarioFacade() {
        super(Inventario.class);
    }

    @Override
    public boolean updateProduct(Productos producto, int cantidad, String operacion) {
        String sql = "UPDATE inventario SET cantidad = cantidad "+operacion+" ? WHERE producto_id = ?";
        return getEntityManager().createNativeQuery(sql)
                            .setParameter(1, cantidad)
                            .setParameter(2, producto.getId())
                            .executeUpdate() > 0;
    }

    @Override
    public Inventario findByProduct(int producto) {
        return getEntityManager().createNamedQuery("Inventario.findByProducto", Inventario.class)
                            .setParameter("producto", producto)
                            .getSingleResult();
    }
    
}
