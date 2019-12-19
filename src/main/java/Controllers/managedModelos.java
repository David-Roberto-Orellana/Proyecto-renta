package Controllers;

import EJB.MarcasFacadeLocal;
import EJB.ModelosFacadeLocal;
import Entity.Marcas;
import Entity.Modelos;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "managedModelos")
@SessionScoped
public class managedModelos implements Serializable {

    

    @EJB
    private ModelosFacadeLocal modelosFacadeLocal;
    private List<Modelos> listaModelos;
    private Modelos modelos;

    @EJB
    private MarcasFacadeLocal marcaEJB;  
    private List<Marcas> listaMarcas;
    private Marcas marcas;

String mensaje;
    public List<Modelos> getListaModelos() {
    listaModelos = modelosFacadeLocal.findAll();
        return listaModelos;
    }

    public void setListaModelos(List<Modelos> listaModelos) {
        this.listaModelos = listaModelos;
    }

    public List<Marcas> getListaMarcas() {
        listaMarcas = marcaEJB.findAll();
        return listaMarcas;
    }

    public void setListaMarcas(List<Marcas> listaMarcas) {
        this.listaMarcas = listaMarcas;
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
    public void init() {
        this.modelos = new Modelos();
        this.marcas = new Marcas();
        modelos.setIdModelo(0);
       
    }

    public void consultar_modelos() {
        try {
            this.modelosFacadeLocal.findAll();
        } catch (Exception e) {
      
        }
       
    }

    public void insertar_vehiculos() {
        try {
            modelos.setIdMarca(marcas);
            modelosFacadeLocal.create(modelos);
            this.mensaje = "Insertado Correctamente";
        } catch (Exception e) {
            this.mensaje = "Error al Insertar";
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }

    public void actualizar_vehiculos() {
        try {
            this.modelos.setIdMarca(marcas);
            modelosFacadeLocal.edit(modelos);
            this.modelos=new Modelos();
            this.marcas=new Marcas();
            this.mensaje = "Actualizado Correctamente";
        } catch (Exception e) {
            this.mensaje = "Error al Actualizar";
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }

    public void eliminar_vehiculos(Modelos mod) {
        this.modelos=mod;
        try {
            modelosFacadeLocal.remove(modelos);
            listaModelos = modelosFacadeLocal.findAll();
            this.mensaje = "Eliminado Correctamente";
        } catch (Exception e) {
            this.mensaje = "Error al Eliminar";
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }

    public void consultarID_vehiculos(Modelos mod) {
        try {
            this.marcas.setIdMarca(mod.getIdMarca().getIdMarca());
            this.modelos = mod;
        } catch (Exception e) {
        }
    }
    
     public void limpiar_Modelos() {
        this.modelos = new Modelos();
        modelos.setIdModelo(0);
    }

}
