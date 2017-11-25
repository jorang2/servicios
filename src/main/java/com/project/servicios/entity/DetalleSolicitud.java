/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.servicios.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jaime
 */
@Entity
@Table(name = "detalle_solicitud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleSolicitud.findAll", query = "SELECT d FROM DetalleSolicitud d"),
    @NamedQuery(name = "DetalleSolicitud.findBySolicitud", query = "SELECT d FROM DetalleSolicitud d WHERE d.solicitudId.id = :id"),
    @NamedQuery(name = "DetalleSolicitud.findById", query = "SELECT d FROM DetalleSolicitud d WHERE d.id = :id"),
    @NamedQuery(name = "DetalleSolicitud.findByCantidad", query = "SELECT d FROM DetalleSolicitud d WHERE d.cantidad = :cantidad")})
public class DetalleSolicitud implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @JoinColumn(name = "solicitud_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Solicitudes solicitudId;
    @JoinColumn(name = "producto_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Productos productoId;

    public DetalleSolicitud() {
    }

    public DetalleSolicitud(Integer id) {
        this.id = id;
    }

    public DetalleSolicitud(Integer id, int cantidad) {
        this.id = id;
        this.cantidad = cantidad;
    }

    public DetalleSolicitud(int cantidad, Productos productoId) {
        this.cantidad = cantidad;
        this.productoId = productoId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Solicitudes getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(Solicitudes solicitudId) {
        this.solicitudId = solicitudId;
    }

    public Productos getProductoId() {
        return productoId;
    }

    public void setProductoId(Productos productoId) {
        this.productoId = productoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleSolicitud)) {
            return false;
        }
        DetalleSolicitud other = (DetalleSolicitud) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DetalleSolicitud{" + "id=" + id + ", cantidad=" + cantidad + ", solicitudId=" + solicitudId + ", productoId=" + productoId + '}';
    }
    
}
