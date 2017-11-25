/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.servicios.beans;

import com.project.servicios.entity.DetalleSolicitud;
import com.project.servicios.entity.Solicitudes;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jaime
 */
@Stateless
public class DetalleSolicitudFacade extends AbstractFacade<DetalleSolicitud> implements DetalleSolicitudFacadeLocal {
    @PersistenceContext(unitName = "com.project_Servicios_war_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleSolicitudFacade() {
        super(DetalleSolicitud.class);
    }

    @Override
    public List<DetalleSolicitud> findBySolicitud(int solicitudId) {
        return getEntityManager().createNamedQuery("DetalleSolicitud.findBySolicitud", DetalleSolicitud.class)
                          .setParameter("id", solicitudId)
                          .getResultList();
    }
    
}
