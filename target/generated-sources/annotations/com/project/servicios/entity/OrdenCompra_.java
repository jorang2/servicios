package com.project.servicios.entity;

import com.project.servicios.entity.DetalleOrdenCompra;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-25T10:19:06")
@StaticMetamodel(OrdenCompra.class)
public class OrdenCompra_ { 

    public static volatile SingularAttribute<OrdenCompra, Integer> id;
    public static volatile SingularAttribute<OrdenCompra, String> estado;
    public static volatile SingularAttribute<OrdenCompra, Date> fecha;
    public static volatile SingularAttribute<OrdenCompra, String> cliente;
    public static volatile ListAttribute<OrdenCompra, DetalleOrdenCompra> detalleOrdenCompraList;

}