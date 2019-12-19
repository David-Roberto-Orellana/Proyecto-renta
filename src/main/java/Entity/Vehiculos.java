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
@Table(name = "vehiculos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculos.findAll", query = "SELECT v FROM Vehiculos v")
    , @NamedQuery(name = "Vehiculos.findByIdVehiculo", query = "SELECT v FROM Vehiculos v WHERE v.idVehiculo = :idVehiculo")
    , @NamedQuery(name = "Vehiculos.findByFechaIngreso", query = "SELECT v FROM Vehiculos v WHERE v.fechaIngreso = :fechaIngreso")
    , @NamedQuery(name = "Vehiculos.findByColor", query = "SELECT v FROM Vehiculos v WHERE v.color = :color")
    , @NamedQuery(name = "Vehiculos.findByPlaca", query = "SELECT v FROM Vehiculos v WHERE v.placa = :placa")
    , @NamedQuery(name = "Vehiculos.findByDescripcion", query = "SELECT v FROM Vehiculos v WHERE v.descripcion = :descripcion")
    , @NamedQuery(name = "Vehiculos.findByPrecio", query = "SELECT v FROM Vehiculos v WHERE v.precio = :precio")
    , @NamedQuery(name = "Vehiculos.findByEstado", query = "SELECT v FROM Vehiculos v WHERE v.estado = :estado")
    , @NamedQuery(name = "Vehiculos.findByImg", query = "SELECT v FROM Vehiculos v WHERE v.img = :img")})
public class Vehiculos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vehiculo")
    private Integer idVehiculo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "fecha_ingreso")
    private String fechaIngreso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "color")
    private String color;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "placa")
    private String placa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private double precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "img")
    private String img;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVehiculo")
    private List<Historiales> historialesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVehiculo")
    private List<Reparaciones> reparacionesList;
    @JoinColumn(name = "id_modelo", referencedColumnName = "id_modelo")
    @ManyToOne(optional = false)
    private Modelos idModelo;

    public Vehiculos() {
    }

    public Vehiculos(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Vehiculos(Integer idVehiculo, String fechaIngreso, String color, String placa, String descripcion, double precio, int estado, String img) {
        this.idVehiculo = idVehiculo;
        this.fechaIngreso = fechaIngreso;
        this.color = color;
        this.placa = placa;
        this.descripcion = descripcion;
        this.precio = precio;
        this.estado = estado;
        this.img = img;
    }

    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @XmlTransient
    public List<Historiales> getHistorialesList() {
        return historialesList;
    }

    public void setHistorialesList(List<Historiales> historialesList) {
        this.historialesList = historialesList;
    }

    @XmlTransient
    public List<Reparaciones> getReparacionesList() {
        return reparacionesList;
    }

    public void setReparacionesList(List<Reparaciones> reparacionesList) {
        this.reparacionesList = reparacionesList;
    }

    public Modelos getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Modelos idModelo) {
        this.idModelo = idModelo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVehiculo != null ? idVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculos)) {
            return false;
        }
        Vehiculos other = (Vehiculos) object;
        if ((this.idVehiculo == null && other.idVehiculo != null) || (this.idVehiculo != null && !this.idVehiculo.equals(other.idVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJB.Vehiculos[ idVehiculo=" + idVehiculo + " ]";
    }
    
}
