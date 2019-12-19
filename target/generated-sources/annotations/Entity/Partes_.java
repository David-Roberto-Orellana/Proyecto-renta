package Entity;

import Entity.Reparaciones;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-19T13:33:47")
@StaticMetamodel(Partes.class)
public class Partes_ { 

    public static volatile SingularAttribute<Partes, Integer> tipo;
    public static volatile ListAttribute<Partes, Reparaciones> reparacionesList;
    public static volatile SingularAttribute<Partes, String> funcionamiento;
    public static volatile SingularAttribute<Partes, String> nombre;
    public static volatile SingularAttribute<Partes, Integer> idParte;

}