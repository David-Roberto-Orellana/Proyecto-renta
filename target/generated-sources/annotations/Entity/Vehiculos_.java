package Entity;

import Entity.Historiales;
import Entity.Modelos;
import Entity.Reparaciones;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-19T13:33:47")
@StaticMetamodel(Vehiculos.class)
public class Vehiculos_ { 

    public static volatile SingularAttribute<Vehiculos, String> descripcion;
    public static volatile SingularAttribute<Vehiculos, String> fechaIngreso;
    public static volatile ListAttribute<Vehiculos, Historiales> historialesList;
    public static volatile SingularAttribute<Vehiculos, Double> precio;
    public static volatile SingularAttribute<Vehiculos, Integer> estado;
    public static volatile SingularAttribute<Vehiculos, String> img;
    public static volatile SingularAttribute<Vehiculos, Integer> idVehiculo;
    public static volatile SingularAttribute<Vehiculos, String> color;
    public static volatile ListAttribute<Vehiculos, Reparaciones> reparacionesList;
    public static volatile SingularAttribute<Vehiculos, Modelos> idModelo;
    public static volatile SingularAttribute<Vehiculos, String> placa;

}