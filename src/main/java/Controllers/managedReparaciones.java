package Controllers;

import EJB.ReparacionesFacadeLocal;
import Entity.Partes;
import Entity.Reparaciones;
import Entity.Vehiculos;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "")
@ManagedBean
@SessionScoped
public class managedReparaciones implements Serializable {

    String mjs;
    @EJB
    private ReparacionesFacadeLocal reparacionesFacade;
    private List<Reparaciones> listaReparaciones;
    private Reparaciones reparaciones;
    private Vehiculos vehiculos;
    private Partes partes;

    public List<Reparaciones> getListaReparaciones() {
        this.listaReparaciones = this.reparacionesFacade.findAll();
        return listaReparaciones;
    }

    public void setListaReparaciones(List<Reparaciones> listaReparaciones) {
        this.listaReparaciones = listaReparaciones;
    }

    public Reparaciones getReparaciones() {
        return reparaciones;
    }

    public void setReparaciones(Reparaciones reparaciones) {
        this.reparaciones = reparaciones;
    }

    public Vehiculos getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Vehiculos vehiculos) {
        this.vehiculos = vehiculos;
    }

    public Partes getPartes() {
        return partes;
    }

    public void setPartes(Partes partes) {
        this.partes = partes;
    }

    @PostConstruct
    public void init() {
        this.reparaciones = new Reparaciones();
        this.vehiculos = new Vehiculos();
        this.partes = new Partes();
        this.reparaciones.setIdReparacion(0);
    }

    public void consultar() {
        try {
            listaReparaciones = reparacionesFacade.findAll();
        } catch (Exception e) {
        }
    }

    public void consultarById(Reparaciones re) {
        try {
            this.reparaciones = re;
            this.reparaciones.setIdVehiculo(re.getIdVehiculo());
            this.reparaciones.setIdParte(re.getIdParte());
            reparaciones.setIdReparacion(re.getIdReparacion());
        } catch (Exception e) {
        }
    }

    public void guardar() {
        try {

            this.reparaciones.setIdVehiculo(vehiculos);
            this.reparaciones.setIdParte(partes);
            this.reparacionesFacade.create(reparaciones);
            this.reparaciones = new Reparaciones();
            this.vehiculos = new Vehiculos();
            this.partes = new Partes();
            this.mjs = "Guardado Correctamente";
        } catch (Exception e) {
            this.mjs = "Error" + e.getMessage();
            e.printStackTrace();
        }
        FacesMessage msg = new FacesMessage(this.mjs);
        FacesContext.getCurrentInstance().addMessage(mjs, msg);
    }

    public void actualizar() {
        try {
            this.reparaciones.setIdVehiculo(vehiculos);
            this.reparaciones.setIdParte(partes);
            reparacionesFacade.edit(reparaciones);

            this.mjs = "Actualizado Correctamente";
        } catch (Exception e) {
            this.mjs = "Error al Actualizar";
            e.printStackTrace();
        }
        FacesMessage msg = new FacesMessage(this.mjs);
        FacesContext.getCurrentInstance().addMessage(mjs, msg);
    }

    /*public void insertar() {
        try {
            reparacionesFacade.create(reparaciones);
            this.mjs = "Actualizado Correctamente";
        } catch (Exception e) {
            this.mjs = "Error al Actualizar";
        }
        FacesMessage msg = new FacesMessage(this.mjs);
        FacesContext.getCurrentInstance().addMessage(mjs, msg);
    } */
    public void eliminar(Reparaciones repa) {
        this.reparaciones = repa;
        try {
            this.reparacionesFacade.remove(reparaciones);
            listaReparaciones = reparacionesFacade.findAll();
            this.mjs = "Eliminado Correctamente";
        } catch (Exception e) {
            this.mjs = "Error al eliminar" +e;
            e.printStackTrace();
        }
        FacesMessage msg = new FacesMessage(this.mjs);
        FacesContext.getCurrentInstance().addMessage(mjs, msg);
    }

    public void limpiar() {
        this.reparaciones = new Reparaciones();
        this.reparaciones.setIdReparacion(0);
    }
}