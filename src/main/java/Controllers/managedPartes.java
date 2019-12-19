package Controllers;

import EJB.PartesFacadeLocal;
import Entity.Partes;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "managedPartes")
@SessionScoped
public class managedPartes implements Serializable {

    String mensaje;

    @EJB
    private PartesFacadeLocal partesFacadeLocal; 
    private List<Partes> listaPartes = null;
    private Partes partes;

    public List<Partes> getListaPartes() {
        this.listaPartes = this.partesFacadeLocal.findAll();
        return listaPartes;
    }

    public void setListaPartes(List<Partes> listaPartes) {
        this.listaPartes = listaPartes;
    }

    public Partes getPartes() {
        return partes;
    }

    public void setPartes(Partes partes) {
        this.partes = partes;
    }

    @PostConstruct
    private void init() {
        partes = new Partes();
        
        
    }

    public void insertar_parte() {
        try {
            partesFacadeLocal.create(partes);
           this. mensaje = "Datos Insertados con Exito";
        } catch (Exception e) {
            this. mensaje = "Error al Insertar Datos";
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }

    public void consultarId_partes(Partes p) {
        try {
            this.partes = p;
        } catch (Exception e) {
        }
    }
    
    public void actualizar_parte() {
        try {
            partesFacadeLocal.edit(partes);
            this. mensaje = "Datos Actualizados con Exito";
        } catch (Exception e) {
            this. mensaje = "Error al Actualizar Datos";
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }

    public void consultar_parte() {
           try {
            listaPartes = partesFacadeLocal.findAll();
        } catch (Exception e) {
        }
    }

    public void eliminar_parte(Partes p) {
        this.partes= p;
        try {
            partesFacadeLocal.remove(partes);
            this.listaPartes = partesFacadeLocal.findAll();
            this.mensaje = "Datos Eliminados con Exito";
        } catch (Exception e) {
            this.mensaje = "Error al Eliminar Datos";
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }
    
    public void limpiar(){
        this.partes=new Partes();
        this.partes.setIdParte(0);
    }
    
}
