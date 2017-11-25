package com.project.servicios.entity;

import com.project.servicios.entity.DetalleSolicitud;
import com.project.servicios.entity.Proveedores;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-25T10:19:06")
@StaticMetamodel(Solicitudes.class)
public class Solicitudes_ { 

    public static volatile SingularAttribute<Solicitudes, Integer> id;
    public static volatile ListAttribute<Solicitudes, DetalleSolicitud> detalleSolicitudList;
    public static volatile SingularAttribute<Solicitudes, String> estado;
    public static volatile SingularAttribute<Solicitudes, Proveedores> proveedoId;
    public static volatile SingularAttribute<Solicitudes, Date> fechaSolicitud;

}