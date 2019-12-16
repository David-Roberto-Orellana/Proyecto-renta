package Controllers;

import EJB.ModelosFacadeLocal;
import Entity.Marcas;
import Entity.Modelos;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class managedModelos implements Serializable{
    String mensaje;
    @EJB
    private ModelosFacadeLocal modelosFacade;
    private List<Modelos> listaModelos;
    private Modelos modelos;
    private Marcas marcas;

    public List<Modelos> getListaModelos() {
        this.listaModelos = this.modelosFacade.findAll();
        return listaModelos;
    }

    public void setListaModelos(List<Modelos> listaModelos) {
        this.listaModelos = listaModelos;
    }

    public Modelos getModelos() {
        return modelos;
    }

    public void setModelos(Modelos modelos) {
        this.modelos = modelos;
    }

    public Marcas getMarcas() {
        return marcas;
    }

    public void setMarcas(Marcas marcas) {
        this.marcas = marcas;
    }
    @PostConstruct
    public void init(){
        this.modelos = new Modelos();
        this.marcas = new Marcas();
    }
    
    
    public void consultar_modelos(){
        try {
            modelosFacade.findAll();
        } catch (Exception e) {
            this.mensaje = "Error al Consulta";
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }

    
    public void insertar_vehiculos() {
        try {
            modelosFacade.create(modelos);
            this.mensaje = "Insertado Correctamente";
        } catch (Exception e) {
            this.mensaje = "Error al Insertar";
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }

    public void actualizar_vehiculos() {
        try {
            modelosFacade.edit(modelos);
            this.mensaje = "Actualizado Correctamente";
        } catch (Exception e) {
            this.mensaje = "Error al Actualizar";
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }

    public void eliminar_vehiculos() {
        try {
            modelosFacade.remove(modelos);
            listaModelos = modelosFacade.findAll();
            this.mensaje = "Eliminado Correctamente";
        } catch (Exception e) {
            this.mensaje = "Error al Eliminar";
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }

    public void consultarID_vehiculos(Modelos mod) {
        try {
            this.modelos = mod;
        } catch (Exception e) {
        }
    }

    
    
}
