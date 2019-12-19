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
@Table(name = "modelos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modelos.findAll", query = "SELECT m FROM Modelos m")
    , @NamedQuery(name = "Modelos.findByIdModelo", query = "SELECT m FROM Modelos m WHERE m.idModelo = :idModelo")
    , @NamedQuery(name = "Modelos.findByNombre", query = "SELECT m FROM Modelos m WHERE m.nombre = :nombre")
    , @NamedQuery(name = "Modelos.findByAnio", query = "SELECT m FROM Modelos m WHERE m.anio = :anio")})
public class Modelos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_modelo")
    private Integer idModelo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anio")
    private int anio;
    @JoinColumn(name = "id_marca", referencedColumnName = "id_marca")
    @ManyToOne(optional = false)
    private Marcas idMarca;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idModelo")
    private List<Vehiculos> vehiculosList;

    public Modelos() {
    }

    public Modelos(Integer idModelo) {
        this.idModelo = idModelo;
    }

    public Modelos(Integer idModelo, String nombre, int anio) {
        this.idModelo = idModelo;
        this.nombre = nombre;
        this.anio = anio;
    }

    public Integer getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Integer idModelo) {
        this.idModelo = idModelo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Marcas getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Marcas idMarca) {
        this.idMarca = idMarca;
    }

    @XmlTransient
    public List<Vehiculos> getVehiculosList() {
        return vehiculosList;
    }

    public void setVehiculosList(List<Vehiculos> vehiculosList) {
        this.vehiculosList = vehiculosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idModelo != null ? idModelo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modelos)) {
            return false;
        }
        Modelos other = (Modelos) object;
        if ((this.idModelo == null && other.idModelo != null) || (this.idModelo != null && !this.idModelo.equals(other.idModelo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJB.Modelos[ idModelo=" + idModelo + " ]";
    }
    
}
