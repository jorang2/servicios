package com.project.servicios.entity;

import com.project.servicios.entity.Productos;
import com.project.servicios.entity.Solicitudes;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-25T10:19:06")
@StaticMetamodel(DetalleSolicitud.class)
public class DetalleSolicitud_ { 

    public static volatile SingularAttribute<DetalleSolicitud, Integer> id;
    public static volatile SingularAttribute<DetalleSolicitud, Solicitudes> solicitudId;
    public static volatile SingularAttribute<DetalleSolicitud, Integer> cantidad;
    public static volatile SingularAttribute<DetalleSolicitud, Productos> productoId;

}