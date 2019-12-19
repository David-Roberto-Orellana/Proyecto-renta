package Controllers;

import EJB.VehiculosFacadeLocal;
import Entity.Modelos;
import Entity.Vehiculos;
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
public class managedVehiculos implements Serializable {

    String mensaje;

    @EJB
    private VehiculosFacadeLocal vehiculosFacade;
    private List<Vehiculos> listaVehiculos;
    private Vehiculos vehiculos;
    private Modelos modelos;

    public List<Vehiculos> getListaVehiculos() {
        this.listaVehiculos = this.vehiculosFacade.findAll();
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculos> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public Vehiculos getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Vehiculos vehiculos) {
        this.vehiculos = vehiculos;
    }

    public Modelos getModelos() {
        return modelos;
    }

    public void setModelos(Modelos modelos) {
        this.modelos = modelos;
    }

    @PostConstruct
    public void init() {
        this.vehiculos = new Vehiculos();
        this.modelos = new Modelos();
        this.vehiculos.setIdVehiculo(0);
    }

    public void consultar_vehiculos() {
        try {
            vehiculosFacade.findAll();
        } catch (Exception e) {
            this.mensaje = "Error al Consultar";
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }

    public void insertar_vehiculos() {
        try {
            vehiculosFacade.create(vehiculos);
            this.mensaje = "Insertado Correctamente";
        } catch (Exception e) {
            this.mensaje = "Error al Insertar";
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }

    public void actualizar_vehiculos() {
        try {
            vehiculosFacade.edit(vehiculos);
            this.mensaje = "Actualizado Correctamente";
        } catch (Exception e) {
            this.mensaje = "Error al Actualizar";
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }

    public void eliminar_vehiculos(Vehiculos veh) {
        this.vehiculos = veh;
        try {
            vehiculosFacade.remove(vehiculos);
            listaVehiculos = vehiculosFacade.findAll();
            this.mensaje = "Eliminado Correctamente";
        } catch (Exception e) {
            this.mensaje = "Error al Eliminar";
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }

    public void consultarID_vehiculos(Vehiculos veh) {
                this.vehiculos = veh;
        try {
            this.vehiculos = veh;
        } catch (Exception e) {
        }
    }
    
    public void limpiar(){
    this.vehiculos = new Vehiculos();
    this.vehiculos.setIdVehiculo(0);
    
    }

}
