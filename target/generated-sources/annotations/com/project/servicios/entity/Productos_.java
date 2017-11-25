package com.project.servicios.entity;

import com.project.servicios.entity.DetalleOrdenCompra;
import com.project.servicios.entity.DetalleSolicitud;
import com.project.servicios.entity.Inventario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-25T10:19:06")
@StaticMetamodel(Productos.class)
public class Productos_ { 

    public static volatile SingularAttribute<Productos, Integer> id;
    public static volatile SingularAttribute<Productos, Integer> codigo;
    public static volatile SingularAttribute<Productos, String> nombre;
    public static volatile ListAttribute<Productos, DetalleSolicitud> detalleSolicitudList;
    public static volatile ListAttribute<Productos, Inventario> inventarioList;
    public static volatile SingularAttribute<Productos, String> descripcion;
    public static volatile ListAttribute<Productos, DetalleOrdenCompra> detalleOrdenCompraList;

}