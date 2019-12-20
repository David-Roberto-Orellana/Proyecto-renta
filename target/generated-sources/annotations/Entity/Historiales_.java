package Entity;

import Entity.Extranjeros;
import Entity.Moras;
import Entity.Vehiculos;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-20T09:05:44")
@StaticMetamodel(Historiales.class)
public class Historiales_ { 

    public static volatile SingularAttribute<Historiales, Double> precio;
    public static volatile SingularAttribute<Historiales, Vehiculos> idVehiculo;
    public static volatile SingularAttribute<Historiales, String> fechaInicio;
    public static volatile SingularAttribute<Historiales, Extranjeros> idExtranjero;
    public static volatile ListAttribute<Historiales, Moras> morasList;
    public static volatile SingularAttribute<Historiales, Integer> idHistorial;
    public static volatile SingularAttribute<Historiales, String> fechaFin;

}