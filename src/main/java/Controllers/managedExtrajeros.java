package Controllers;

import EJB.ClientesFacadeLocal;
import EJB.ExtranjerosFacadeLocal;
import Entity.Clientes;
import Entity.Extranjeros;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "managedExtrajeros")
@SessionScoped
public class managedExtrajeros implements Serializable {

    String mensaje;

    @EJB
    private ExtranjerosFacadeLocal ExtranjerosEJBFacadeLocal;
    private List<Extranjeros> listaextranjero;
    private Extranjeros extranjeros;

    @EJB
    private ClientesFacadeLocal clientesEJBFacadeLocal;
    private List<Clientes> listaClientes;
    private Clientes clietnes;

    public List<Clientes> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Clientes> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public Clientes getClietnes() {
        return clietnes;
    }

    public void setClietnes(Clientes clietnes) {
        this.clietnes = clietnes;
    }

    public List<Extranjeros> getListaextranjero() {
        this.listaextranjero = this.ExtranjerosEJBFacadeLocal.findAll();
        return listaextranjero;
    }

    public void setListaextranjero(List<Extranjeros> listaextranjero) {
        this.listaextranjero = listaextranjero;
    }

    public Extranjeros getExtranjeros() {
        return extranjeros;
    }

    public void setExtranjeros(Extranjeros extranjeros) {
        this.extranjeros = extranjeros;
    }

    @PostConstruct
    private void init() {
        extranjeros = new Extranjeros();
        listaextranjero = ExtranjerosEJBFacadeLocal.findAll();
    }

    public void consultar_extranjeros() {
        try {
            listaextranjero = ExtranjerosEJBFacadeLocal.findAll();
        } catch (Exception e) {
        }

    }

    public void insertar_extranjeros() {
        try {
            ExtranjerosEJBFacadeLocal.create(extranjeros);
            this.mensaje = "Insertado Correctamente";
        } catch (Exception e) {
            this.mensaje = "Error al Insertar";
        }
        FacesMessage msg = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msg);

    }

    public void consultarId_extranjeros(Extranjeros extran) {
        try {
            this.extranjeros = extran;
        } catch (Exception e) {
        }
    }

    public void actualizar_extranjeros() {
        try {
            ExtranjerosEJBFacadeLocal.edit(extranjeros);
            this.mensaje = "Actualizado Correctamente";
        } catch (Exception e) {
            this.mensaje = "Error al Actualizado";
        }
        FacesMessage msg = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msg);

    }

    public void eliminar_extranjeros(Extranjeros extran) {
        this.extranjeros = extran;
        try {
            ExtranjerosEJBFacadeLocal.remove(extranjeros);
            listaextranjero = ExtranjerosEJBFacadeLocal.findAll();
            this.mensaje = "Eliminado Correctamente";
        } catch (Exception e) {
            this.mensaje = "Error al Eliminar";
        }
    }

    public void limpiar() {
        extranjeros = new Extranjeros();
        listaextranjero = ExtranjerosEJBFacadeLocal.findAll();
    }

}
