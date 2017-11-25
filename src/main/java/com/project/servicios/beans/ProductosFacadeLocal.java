/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.servicios.beans;

import com.project.servicios.entity.Productos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jaime
 */
@Local
public interface ProductosFacadeLocal {

    void create(Productos productos);

    void edit(Productos productos);

    void remove(Productos productos);

    Productos find(Object id);

    List<Productos> findAll();

    List<Productos> findRange(int[] range);

    int count();
    
}
