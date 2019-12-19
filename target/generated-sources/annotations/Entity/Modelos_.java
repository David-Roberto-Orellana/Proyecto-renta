package Entity;

import Entity.Marcas;
import Entity.Vehiculos;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-19T15:55:12")
@StaticMetamodel(Modelos.class)
public class Modelos_ { 

    public static volatile SingularAttribute<Modelos, Integer> idModelo;
    public static volatile ListAttribute<Modelos, Vehiculos> vehiculosList;
    public static volatile SingularAttribute<Modelos, Marcas> idMarca;
    public static volatile SingularAttribute<Modelos, String> nombre;
    public static volatile SingularAttribute<Modelos, Integer> anio;

}