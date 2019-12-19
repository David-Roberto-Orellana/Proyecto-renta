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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "extranjeros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Extranjeros.findAll", query = "SELECT e FROM Extranjeros e")
    , @NamedQuery(name = "Extranjeros.findByIdExtranjero", query = "SELECT e FROM Extranjeros e WHERE e.idExtranjero = :idExtranjero")
    , @NamedQuery(name = "Extranjeros.findByExtranjero", query = "SELECT e FROM Extranjeros e WHERE e.extranjero = :extranjero")
    , @NamedQuery(name = "Extranjeros.findByFechaExpiracion", query = "SELECT e FROM Extranjeros e WHERE e.fechaExpiracion = :fechaExpiracion")})
public class Extranjeros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_extranjero")
    private Integer idExtranjero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "extranjero")
    private int extranjero;
    @Size(max = 10)
    @Column(name = "fecha_expiracion")
    private String fechaExpiracion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idExtranjero")
    private List<Historiales> historialesList;
    @JoinColumn(name = "id_extranjero", referencedColumnName = "id_clientes", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Clientes clientes;

    public Extranjeros() {
    }

    public Extranjeros(Integer idExtranjero) {
        this.idExtranjero = idExtranjero;
    }

    public Extranjeros(Integer idExtranjero, int extranjero) {
        this.idExtranjero = idExtranjero;
        this.extranjero = extranjero;
    }

    public Integer getIdExtranjero() {
        return idExtranjero;
    }

    public void setIdExtranjero(Integer idExtranjero) {
        this.idExtranjero = idExtranjero;
    }

    public int getExtranjero() {
        return extranjero;
    }

    public void setExtranjero(int extranjero) {
        this.extranjero = extranjero;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    @XmlTransient
    public List<Historiales> getHistorialesList() {
        return historialesList;
    }

    public void setHistorialesList(List<Historiales> historialesList) {
        this.historialesList = historialesList;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExtranjero != null ? idExtranjero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Extranjeros)) {
            return false;
        }
        Extranjeros other = (Extranjeros) object;
        if ((this.idExtranjero == null && other.idExtranjero != null) || (this.idExtranjero != null && !this.idExtranjero.equals(other.idExtranjero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJB.Extranjeros[ idExtranjero=" + idExtranjero + " ]";
    }
    
}
