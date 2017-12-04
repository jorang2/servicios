/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.servicios.beans;

import com.project.servicios.entity.Solicitudes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jaime
 */
@Local
public interface SolicitudesFacadeLocal {

    void create(Solicitudes solicitudes);

    void edit(Solicitudes solicitudes);

    void remove(Solicitudes solicitudes);

    Solicitudes find(Object id);

    List<Solicitudes> findAll();

    List<Solicitudes> findRange(int[] range);

    int count();
    
}


//Final
