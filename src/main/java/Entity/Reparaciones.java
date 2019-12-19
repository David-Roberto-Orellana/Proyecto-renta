/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cesar.murciausam
 */
@Entity
@Table(name = "reparaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reparaciones.findAll", query = "SELECT r FROM Reparaciones r")
    , @NamedQuery(name = "Reparaciones.findByIdReparacion", query = "SELECT r FROM Reparaciones r WHERE r.idReparacion = :idReparacion")
    , @NamedQuery(name = "Reparaciones.findByFechaIngreso", query = "SELECT r FROM Reparaciones r WHERE r.fechaIngreso = :fechaIngreso")
    , @NamedQuery(name = "Reparaciones.findByDescripcion", query = "SELECT r FROM Reparaciones r WHERE r.descripcion = :descripcion")})
public class Reparaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_reparacion")
    private Integer idReparacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "fecha_ingreso")
    private String fechaIngreso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "id_vehiculo", referencedColumnName = "id_vehiculo")
    @ManyToOne(optional = false)
    private Vehiculos idVehiculo;
    @JoinColumn(name = "id_parte", referencedColumnName = "id_parte")
    @ManyToOne(optional = false)
    private Partes idParte;

    public Reparaciones() {
    }

    public Reparaciones(Integer idReparacion) {
        this.idReparacion = idReparacion;
    }

    public Reparaciones(Integer idReparacion, String fechaIngreso, String descripcion) {
        this.idReparacion = idReparacion;
        this.fechaIngreso = fechaIngreso;
        this.descripcion = descripcion;
    }

    public Integer getIdReparacion() {
        return idReparacion;
    }

    public void setIdReparacion(Integer idReparacion) {
        this.idReparacion = idReparacion;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Vehiculos getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Vehiculos idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Partes getIdParte() {
        return idParte;
    }

    public void setIdParte(Partes idParte) {
        this.idParte = idParte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReparacion != null ? idReparacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reparaciones)) {
            return false;
        }
        Reparaciones other = (Reparaciones) object;
        if ((this.idReparacion == null && other.idReparacion != null) || (this.idReparacion != null && !this.idReparacion.equals(other.idReparacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJB.Reparaciones[ idReparacion=" + idReparacion + " ]";
    }
    
}
