package Controllers;

import EJB.PartesFacade;
import EJB.ReparacionesFacade;
import EJB.VehiculosFacade;
import Entity.Partes;
import Entity.Reparaciones;
import Entity.Vehiculos;
import java.io.Serializable;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "managetReparaciones")
@ManagedBean
@SessionScoped
public class managedReparaciones implements Serializable {

    String mensaje;

    @EJB
    private ReparacionesFacade reparacionesFacade;
    private Reparaciones reparaciones;
    private List<Reparaciones> listaReparaciones;

    @EJB
    private PartesFacade partesFacade;
    private Partes partes;
    private List<Partes> listaPartes;

    @EJB
    private VehiculosFacade vehiculosFacade;
    private Vehiculos vehiculos;
    private List<Vehiculos> listaVehiculos;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Reparaciones getReparaciones() {
        return reparaciones;
    }

    public void setReparaciones(Reparaciones reparaciones) {
        this.reparaciones = reparaciones;
    }

    public List<Reparaciones> getListaReparaciones() {
        return listaReparaciones;
    }

    public void setListaReparaciones(List<Reparaciones> listaReparaciones) {
        this.listaReparaciones = listaReparaciones;
    }

    public Partes getPartes() {
        return partes;
    }

    public void setPartes(Partes partes) {
        this.partes = partes;
    }

    public List<Partes> getListaPartes() {
        return listaPartes;
    }

    public void setListaPartes(List<Partes> listaPartes) {
        this.listaPartes = listaPartes;
    }

    public Vehiculos getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Vehiculos vehiculos) {
        this.vehiculos = vehiculos;
    }

    public List<Vehiculos> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculos> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    @PostConstruct
    private void init() {
        reparaciones = new Reparaciones();
        partes = new Partes();
        vehiculos = new Vehiculos();
    }

    public void insertar_reparacion() {
        try {
            reparacionesFacade.create(reparaciones);
            mensaje = "Datos Insertados con Exito";
        } catch (Exception e) {
            mensaje = "Error al Insetar Datos";
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }

    public void actualizar_reparacion() {
        try {
            reparacionesFacade.edit(reparaciones);
            mensaje = "Datos Actualizados con Exito";
        } catch (Exception e) {
            mensaje = "Error al Actualizar Datos";
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }

    public void consultar_reparacion() {
        try {
            reparacionesFacade.findAll();
            mensaje = "Datos Consultados con Exito";
        } catch (Exception e) {
            mensaje = "Error al Consultar Datos";
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }

    public void eliminar_reparacion() {
        try {
            reparacionesFacade.remove(reparaciones);
            mensaje = "Datos Eliminados con Exito";
        } catch (Exception e) {
            mensaje = "Error al Eliminar Datos";
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }
}
