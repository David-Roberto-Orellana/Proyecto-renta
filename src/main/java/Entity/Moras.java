/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author azucena.rivasusam
 */

@Entity
@Table(name = "moras")
public class Moras implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_mora;
    
    @Column(name = "dias")
    private int dias;
    
    @Column(name = "total")
    private double total;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_historial",referencedColumnName = "id_historial")
    private Historiales historiales;

    public int getId_mora() {
        return id_mora;
    }

    public void setId_mora(int id_mora) {
        this.id_mora = id_mora;
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

    public Historiales getHistoriales() {
        return historiales;
    }

    public void setHistoriales(Historiales historiales) {
        this.historiales = historiales;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.id_mora;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Moras other = (Moras) obj;
        if (this.id_mora != other.id_mora) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Moras{" + "id_mora=" + id_mora + '}';
    }
    
    

}
