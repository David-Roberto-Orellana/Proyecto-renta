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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cesar.murciausam
 */
@Entity
@Table(name = "moras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Moras.findAll", query = "SELECT m FROM Moras m")
    , @NamedQuery(name = "Moras.findByIdMora", query = "SELECT m FROM Moras m WHERE m.idMora = :idMora")
    , @NamedQuery(name = "Moras.findByDias", query = "SELECT m FROM Moras m WHERE m.dias = :dias")
    , @NamedQuery(name = "Moras.findByTotal", query = "SELECT m FROM Moras m WHERE m.total = :total")})
public class Moras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mora")
    private Integer idMora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dias")
    private int dias;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private double total;
    @JoinColumn(name = "id_historial", referencedColumnName = "id_historial")
    @ManyToOne(optional = false)
    private Historiales idHistorial;

    public Moras() {
    }

    public Moras(Integer idMora) {
        this.idMora = idMora;
    }

    public Moras(Integer idMora, int dias, double total) {
        this.idMora = idMora;
        this.dias = dias;
        this.total = total;
    }

    public Integer getIdMora() {
        return idMora;
    }

    public void setIdMora(Integer idMora) {
        this.idMora = idMora;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Historiales getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(Historiales idHistorial) {
        this.idHistorial = idHistorial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMora != null ? idMora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Moras)) {
            return false;
        }
        Moras other = (Moras) object;
        if ((this.idMora == null && other.idMora != null) || (this.idMora != null && !this.idMora.equals(other.idMora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJB.Moras[ idMora=" + idMora + " ]";
    }
    
}
