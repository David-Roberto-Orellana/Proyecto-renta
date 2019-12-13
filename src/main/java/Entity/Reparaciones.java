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
@Table(name = "reparaciones")
public class Reparaciones implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_reparacion;

    @Column(name = "fecha_ingreso")
    private String fecha_ingreso;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_vehiculo", referencedColumnName = "id_vehiculo")
    private Vehiculos vehiculos;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_parte", referencedColumnName = "id_parte")
    private Partes partes;

    public int getId_reparacion() {
        return id_reparacion;
    }

    public void setId_reparacion(int id_reparacion) {
        this.id_reparacion = id_reparacion;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Vehiculos getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Vehiculos vehiculos) {
        this.vehiculos = vehiculos;
    }

    public Partes getPartes() {
        return partes;
    }

    public void setPartes(Partes partes) {
        this.partes = partes;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.id_reparacion;
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
        final Reparaciones other = (Reparaciones) obj;
        if (this.id_reparacion != other.id_reparacion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Reparaciones{" + "id_reparacion=" + id_reparacion + '}';
    }

}
