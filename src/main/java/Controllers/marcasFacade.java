
package Controllers;

import EJB.MarcasFacade;
import Entity.Marcas;
import java.io.Serializable;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "managetMarcas")
@ManagedBean
@SessionScoped
public class marcasFacade implements Serializable {

    String mensaje;

    @EJB
    private MarcasFacade marcasFacade;
    private Marcas marcas;
    private List<Marcas> marcasLista;

    public Marcas getMarcas() {
        return marcas;
    }

    public void setMarcas(Marcas marcas) {
        this.marcas = marcas;
    }

    public List<Marcas> getMarcasLista() {
        return marcasLista;
    }

    public void setMarcasLista(List<Marcas> marcasLista) {
        this.marcasLista = marcasLista;
    }

    @PostConstruct
    private void init(){
    marcas = new Marcas();
    }
    public void insertar_marca() {
        try {
            marcasFacade.create(marcas);
            mensaje = "Datos Insertados con Exito";
        } catch (Exception e) {
            mensaje = "Error al Insetar Datos";
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }
    public void actualizar_marca() {
        try {
            marcasFacade.edit(marcas);
            mensaje = "Datos Actualizados con Exito";
        } catch (Exception e) {
            mensaje = "Error al Actualizar Datos";
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }
    public void consultar_marca() {
        try {
            marcasFacade.findAll();
            mensaje = "Datos Consultados con Exito";
        } catch (Exception e) {
            mensaje = "Error al Consultar Datos";
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }
    public void eliminar_marca() {
        try {
            marcasFacade.remove(marcas);
            mensaje = "Datos Eliminados con Exito";
        } catch (Exception e) {
            mensaje = "Error al Eliminar Datos";
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }
}
