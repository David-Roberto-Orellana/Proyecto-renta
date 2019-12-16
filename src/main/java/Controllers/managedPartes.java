package Controllers;

import EJB.PartesFacade;
import Entity.Partes;
import java.io.Serializable;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "managetPartes")
@ManagedBean
@SessionScoped
public class managedPartes implements Serializable {

    String mensaje;

    @EJB
    private PartesFacade partesFacade;
    private Partes partes;
    private List<Partes> listaPartes;

    public List<Partes> getListaPartes() {
        listaPartes = partesFacade.findAll();
        return listaPartes;
    }

    public void setListaPartes(List<Partes> listaPartes) {
        this.listaPartes = listaPartes;
    }

    @PostConstruct
    private void init() {
        partes = new Partes();
    }

    public void insertar_parte() {
        try {
            partesFacade.create(partes);
            mensaje = "Datos Insertados con Exito";
        } catch (Exception e) {
            mensaje = "Error al Insertar Datos";
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }

    public void actualizar_parte() {
        try {
            partesFacade.edit(partes);
            mensaje = "Datos Actualizados con Exito";
        } catch (Exception e) {
            mensaje = "Error al Actualizar Datos";
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }

    public void consultar_parte() {
        try {
            partesFacade.findAll();
            mensaje = "Datos Consultados con Exito";
        } catch (Exception e) {
            mensaje = "Error al Consultar Datos";
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }

    public void eliminar_parte() {
        try {
            partesFacade.remove(partes);
            mensaje = "Datos Eliminados con Exito";
        } catch (Exception e) {
            mensaje = "Error al Eliminar Datos";
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }
}
