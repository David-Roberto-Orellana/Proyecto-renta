package Entity;

import Entity.Clientes;
import Entity.Historiales;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-20T09:05:44")
@StaticMetamodel(Extranjeros.class)
public class Extranjeros_ { 

    public static volatile ListAttribute<Extranjeros, Historiales> historialesList;
    public static volatile SingularAttribute<Extranjeros, Integer> extranjero;
    public static volatile SingularAttribute<Extranjeros, Integer> idExtranjero;
    public static volatile SingularAttribute<Extranjeros, String> fechaExpiracion;
    public static volatile SingularAttribute<Extranjeros, Clientes> clientes;

}