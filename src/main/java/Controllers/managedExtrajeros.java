package Controllers;

import EJB.ExtranjerosFacadeLocal;
import Entity.Extranjeros;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "managedExtrajeros")
@SessionScoped
public class managedExtrajeros implements Serializable {

    @EJB

    private List<Extranjeros> listaextranjero;
    private ExtranjerosFacadeLocal clientesEJBFacadeLocal;
    private Extranjeros extranjeros;
    String mensaje;

    public List<Extranjeros> getListaextranjero() {
        this.listaextranjero = this.clientesEJBFacadeLocal.findAll();
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
    public void init() {
        extranjeros = new Extranjeros();
    }

     public void consultar_extranjeros() {
        try {
            listaextranjero = clientesEJBFacadeLocal.findAll();
        } catch (Exception e) {
        }

    }
    public void insertar_extranjeros() {
        try {
            clientesEJBFacadeLocal.create(extranjeros);
            this.mensaje = "Insertado Correctamente";
        } catch (Exception e) {
            this.mensaje = "Error al Insertar";
        }
        FacesMessage msg = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msg);

    }

   
    
    public void consultarId_extranjeros(Extranjeros extran){
        try {
            this.extranjeros=extran;
        } catch (Exception e) {
        }
    }
    
    public void actualizar_extranjeros() {
        try {
            clientesEJBFacadeLocal.edit(extranjeros);
            this.mensaje = "Actualizado Correctamente";
        } catch (Exception e) {
            this.mensaje = "Error al Actualizado";
        }
        FacesMessage msg = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msg);

    }
    
    public void eliminar_extranjeros(Extranjeros extran){
        this.extranjeros=extran;
        try {
            clientesEJBFacadeLocal.remove(extranjeros);
            listaextranjero=clientesEJBFacadeLocal.findAll();
            this.mensaje = "Eliminado Correctamente";
        } catch (Exception e) {
            this.mensaje = "Error al Eliminar";
        }
}
    

}
