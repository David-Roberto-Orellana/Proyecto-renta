/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cesar.murciausam
 */
@Entity
@Table(name = "historiales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historiales.findAll", query = "SELECT h FROM Historiales h")
    , @NamedQuery(name = "Historiales.findByIdHistorial", query = "SELECT h FROM Historiales h WHERE h.idHistorial = :idHistorial")
    , @NamedQuery(name = "Historiales.findByFechaInicio", query = "SELECT h FROM Historiales h WHERE h.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Historiales.findByFechaFin", query = "SELECT h FROM Historiales h WHERE h.fechaFin = :fechaFin")
    , @NamedQuery(name = "Historiales.findByPrecio", query = "SELECT h FROM Historiales h WHERE h.precio = :precio")})
public class Historiales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_historial")
    private Integer idHistorial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "fecha_inicio")
    private String fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "fecha_fin")
    private String fechaFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private double precio;
    @JoinColumn(name = "id_extranjero", referencedColumnName = "id_extranjero")
    @ManyToOne(optional = false)
    private Extranjeros idExtranjero;
    @JoinColumn(name = "id_vehiculo", referencedColumnName = "id_vehiculo")
    @ManyToOne(optional = false)
    private Vehiculos idVehiculo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idHistorial")
    private List<Moras> morasList;

    public Historiales() {
    }

    public Historiales(Integer idHistorial) {
        this.idHistorial = idHistorial;
    }

    public Historiales(Integer idHistorial, String fechaInicio, String fechaFin, double precio) {
        this.idHistorial = idHistorial;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precio = precio;
    }

    public Integer getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(Integer idHistorial) {
        this.idHistorial = idHistorial;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Extranjeros getIdExtranjero() {
        return idExtranjero;
    }

    public void setIdExtranjero(Extranjeros idExtranjero) {
        this.idExtranjero = idExtranjero;
    }

    public Vehiculos getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Vehiculos idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    @XmlTransient
    public List<Moras> getMorasList() {
        return morasList;
    }

    public void setMorasList(List<Moras> morasList) {
        this.morasList = morasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHistorial != null ? idHistorial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historiales)) {
            return false;
        }
        Historiales other = (Historiales) object;
        if ((this.idHistorial == null && other.idHistorial != null) || (this.idHistorial != null && !this.idHistorial.equals(other.idHistorial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJB.Historiales[ idHistorial=" + idHistorial + " ]";
    }
    
}
