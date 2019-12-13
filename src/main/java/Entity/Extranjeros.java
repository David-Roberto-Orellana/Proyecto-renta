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
@Table(name = "extranjeros")
public class Extranjeros implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_extranjero;

    @Column(name = "extranjero")
    private int extranjero;

    @Column(name = "fecha_expiracion")
    private String fecha_expiracion;

    public int getId_extranjero() {
        return id_extranjero;
    }

    public void setId_extranjero(int id_extranjero) {
        this.id_extranjero = id_extranjero;
    }

    public int getExtranjero() {
        return extranjero;
    }

    public void setExtranjero(int extranjero) {
        this.extranjero = extranjero;
    }

    public String getFecha_expiracion() {
        return fecha_expiracion;
    }

    public void setFecha_expiracion(String fecha_expiracion) {
        this.fecha_expiracion = fecha_expiracion;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id_extranjero;
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
        final Extranjeros other = (Extranjeros) obj;
        if (this.id_extranjero != other.id_extranjero) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Extranjeros{" + "id_extranjero=" + id_extranjero + '}';
    }

}
