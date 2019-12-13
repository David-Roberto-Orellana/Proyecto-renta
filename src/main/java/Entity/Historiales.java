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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author azucena.rivasusam
 */
@Entity
@Table(name = "historiales")
public class Historiales implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_historial;
    
    @Column(name = "fecha_inicio")
    private String fecha_inicio;
    
    @Column(name = "fecha_fin")
    private String fecha_fin;
    
    @Column(name = "precio")
    private double precio;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_extranjero",referencedColumnName ="id_extranjero")
    private Extranjeros extrajeros;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_vehiculo",referencedColumnName = "id_vehiculo")
    private Vehiculos vehiculos;

    public int getId_historial() {
        return id_historial;
    }

    public void setId_historial(int id_historial) {
        this.id_historial = id_historial;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Extranjeros getExtrajeros() {
        return extrajeros;
    }

    public void setExtrajeros(Extranjeros extrajeros) {
        this.extrajeros = extrajeros;
    }

    public Vehiculos getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Vehiculos vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + this.id_historial;
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
        final Historiales other = (Historiales) obj;
        if (this.id_historial != other.id_historial) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Historiales{" + "id_historial=" + id_historial + '}';
    }
    
    

}
