package Entity;

import Entity.Extranjeros;
import Entity.Licencias;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-19T13:33:47")
@StaticMetamodel(Clientes.class)
public class Clientes_ { 

    public static volatile SingularAttribute<Clientes, Integer> icono;
    public static volatile SingularAttribute<Clientes, Licencias> idLicencia;
    public static volatile SingularAttribute<Clientes, String> fechaNacimiento;
    public static volatile SingularAttribute<Clientes, String> seguridad;
    public static volatile SingularAttribute<Clientes, String> apellido;
    public static volatile SingularAttribute<Clientes, String> nit;
    public static volatile SingularAttribute<Clientes, String> dui;
    public static volatile SingularAttribute<Clientes, Extranjeros> extranjeros;
    public static volatile SingularAttribute<Clientes, String> telefono;
    public static volatile SingularAttribute<Clientes, String> nombre;
    public static volatile SingularAttribute<Clientes, Integer> idClientes;
    public static volatile SingularAttribute<Clientes, String> email;

}