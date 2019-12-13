/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author azucena.rivasusam
 */
@Entity
@Table(name = "licencias")
public class Licencias implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_licencia;
    
    @Column(name = "nombre")
    private String nombre;

    public int getId_licencia() {
        return id_licencia;
    }

    public void setId_licencia(int id_licencia) {
        this.id_licencia = id_licencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.id_licencia;
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
        final Licencias other = (Licencias) obj;
        if (this.id_licencia != other.id_licencia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Licencias{" + "id_licencia=" + id_licencia + '}';
    }
    
    

}
