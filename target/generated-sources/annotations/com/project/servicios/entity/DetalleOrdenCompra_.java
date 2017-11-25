package com.project.servicios.entity;

import com.project.servicios.entity.OrdenCompra;
import com.project.servicios.entity.Productos;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-25T10:19:06")
@StaticMetamodel(DetalleOrdenCompra.class)
public class DetalleOrdenCompra_ { 

    public static volatile SingularAttribute<DetalleOrdenCompra, Integer> id;
    public static volatile SingularAttribute<DetalleOrdenCompra, String> estado;
    public static volatile SingularAttribute<DetalleOrdenCompra, Integer> cantidad;
    public static volatile SingularAttribute<DetalleOrdenCompra, Productos> productoId;
    public static volatile SingularAttribute<DetalleOrdenCompra, OrdenCompra> ordenCompraId;

}