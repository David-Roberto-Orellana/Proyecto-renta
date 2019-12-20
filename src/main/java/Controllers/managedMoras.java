/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import EJB.HistorialesFacadeLocal;
import EJB.MorasFacadeLocal;
import EJB.VehiculosFacadeLocal;
import Entity.Historiales;
import Entity.Marcas;
import Entity.Moras;
import Entity.Vehiculos;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author azucena.rivasusam
 */
@Named(value = "managedMoras")
@SessionScoped
public class managedMoras implements Serializable {

    @EJB
    private MorasFacadeLocal morafacadeLocal;
    private List<Moras> listamora;
    private Moras mora;

    @EJB
    private HistorialesFacadeLocal historialfacadeLocal;
    private List<Historiales> listahistorial;
    private Historiales historiales;
    
      @EJB
    private VehiculosFacadeLocal vehiculofacadeLocal;
    private List<Vehiculos> listavehiculo;
    private Vehiculos vehiculo;

    String mensaje;

    public List<Moras> getListamora() {
         this.listamora=this.morafacadeLocal.findAll();
        return listamora;
    }

    public void setListamora(List<Moras> listamora) {
        this.listamora = listamora;
    }

    public Moras getMora() {
        return mora;
    }

    public void setMora(Moras mora) {
        this.mora = mora;
    }

    public List<Historiales> getListahistorial() {
        this.listahistorial=this.historialfacadeLocal.findAll();
        return listahistorial;
    }

    public void setListahistorial(List<Historiales> listahistorial) {
        this.listahistorial = listahistorial;
    }

    public List<Vehiculos> getListavehiculo() {
        this.listavehiculo=this.vehiculofacadeLocal.findAll();
        return listavehiculo;
    }

    public void setListavehiculo(List<Vehiculos> listavehiculo) {
        this.listavehiculo = listavehiculo;
    }

    public Vehiculos getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculos vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    

    public Historiales getHistoriales() {
        return historiales;
    }

    public void setHistoriales(Historiales historiales) {
        this.historiales = historiales;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @PostConstruct

    public void init() {
        this.mora = new Moras();
        this.historiales = new Historiales();
        this.vehiculo=new Vehiculos();
        mora.setIdMora(0);
    }

    public void insertar_mora() {
        try {
            mora.setIdHistorial(historiales);
            morafacadeLocal.create(mora);
            this.mensaje = "Insertado Correctamente";
        } catch (Exception e) {
            this.mensaje = "Error al Insertar";
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }

    public void actualizar_mora() {
        try {
            morafacadeLocal.edit(mora);
            this.mensaje = "Actualizado Correctamente";
        } catch (Exception e) {
            this.mensaje = "Error al Actualizar";
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }

    public void eliminar_mora(Moras mora) {
        this.mora = mora;
        try {
            morafacadeLocal.remove(this.mora);
            listamora = morafacadeLocal.findAll();
            this.mensaje = "Eliminado Correctamente";
        } catch (Exception e) {
            this.mensaje = "Error al Eliminar";
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }

    public void consultarID_mora(Moras mora) {
        try {
            this.historiales.setIdHistorial(mora.getIdHistorial().getIdHistorial());
            this.mora = mora;
        } catch (Exception e) {
        }
    }

    public void limpiar_Mora() {
        this.mora = new Moras();
        mora.setIdMora(0);
    }

}
