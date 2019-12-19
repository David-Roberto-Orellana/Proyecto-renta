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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cesar.murciausam
 */
@Entity
@Table(name = "licencias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Licencias.findAll", query = "SELECT l FROM Licencias l")
    , @NamedQuery(name = "Licencias.findByIdLicencia", query = "SELECT l FROM Licencias l WHERE l.idLicencia = :idLicencia")
    , @NamedQuery(name = "Licencias.findByNombre", query = "SELECT l FROM Licencias l WHERE l.nombre = :nombre")})
public class Licencias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_licencia")
    private Integer idLicencia;
    @Size(max = 25)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLicencia")
    private List<Clientes> clientesList;

    public Licencias() {
    }

    public Licencias(Integer idLicencia) {
        this.idLicencia = idLicencia;
    }

    public Integer getIdLicencia() {
        return idLicencia;
    }

    public void setIdLicencia(Integer idLicencia) {
        this.idLicencia = idLicencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Clientes> getClientesList() {
        return clientesList;
    }

    public void setClientesList(List<Clientes> clientesList) {
        this.clientesList = clientesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLicencia != null ? idLicencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Licencias)) {
            return false;
        }
        Licencias other = (Licencias) object;
        if ((this.idLicencia == null && other.idLicencia != null) || (this.idLicencia != null && !this.idLicencia.equals(other.idLicencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJB.Licencias[ idLicencia=" + idLicencia + " ]";
    }
    
}
