
package Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name = "marcas")
public class Marcas implements Serializable{
    @Id
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private int id_marca;
    
    @Column(name = "nombre")
    private String nombre;

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id_marca;
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
        final Marcas other = (Marcas) obj;
        if (this.id_marca != other.id_marca) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Marcas{" + "id_marca=" + id_marca + '}';
    }
    
    
    
}
