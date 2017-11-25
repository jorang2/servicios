package com.project.servicios.entity;

import com.project.servicios.entity.Solicitudes;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-25T10:19:06")
@StaticMetamodel(Proveedores.class)
public class Proveedores_ { 

    public static volatile SingularAttribute<Proveedores, Integer> id;
    public static volatile SingularAttribute<Proveedores, String> representante;
    public static volatile SingularAttribute<Proveedores, Integer> nit;
    public static volatile ListAttribute<Proveedores, Solicitudes> solicitudesList;
    public static volatile SingularAttribute<Proveedores, String> correo;

}