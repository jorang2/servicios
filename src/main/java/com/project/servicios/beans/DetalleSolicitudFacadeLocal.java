/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.servicios.beans;

import com.project.servicios.entity.DetalleSolicitud;
import com.project.servicios.entity.Solicitudes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jaime
 */
@Local
public interface DetalleSolicitudFacadeLocal {

    void create(DetalleSolicitud detalleSolicitud);

    void edit(DetalleSolicitud detalleSolicitud);

    void remove(DetalleSolicitud detalleSolicitud);

    DetalleSolicitud find(Object id);

    List<DetalleSolicitud> findAll();
    
    List<DetalleSolicitud> findBySolicitud(int solicitudId);

    List<DetalleSolicitud> findRange(int[] range);

    int count();
    
}
