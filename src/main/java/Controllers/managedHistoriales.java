/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import EJB.HistorialesFacadeLocal;
import Entity.Extranjeros;
import Entity.Historiales;
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
@Named(value = "managedHistoriales")
@SessionScoped
public class managedHistoriales implements Serializable {
    
    String mensaje;
    @EJB
    private HistorialesFacadeLocal historialesFacadeLocal;
    private List<Historiales> listaHistoriales = null;
    private Historiales historiales;
    private Extranjeros extranjeros;
    private Vehiculos vehiculos;


    public List<Historiales> getListaHistoriales() {
        this.listaHistoriales=this.historialesFacadeLocal.findAll();
        return listaHistoriales;
    }

    public void setListaHistoriales(List<Historiales> listaHistoriales) {
        this.listaHistoriales = listaHistoriales;
    }

    public Historiales getHistoriales() {
        return historiales;
    }

    public void setHistoriales(Historiales historiales) {
        this.historiales = historiales;
    }

    public Extranjeros getExtranjeros() {
        return extranjeros;
    }

    public void setExtranjeros(Extranjeros extranjeros) {
        this.extranjeros = extranjeros;
    }

    public Vehiculos getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Vehiculos vehiculos) {
        this.vehiculos = vehiculos;
    }
    

    
    @PostConstruct
    private void init() {
        historiales = new Historiales();
        this.historiales.setIdHistorial(0);
    }
    
    public void consultar_historiales(){
        try {
            listaHistoriales = historialesFacadeLocal.findAll();
            
        } catch (Exception e) {
        }
    
    }
    
    public void insertar_historiales(){
        try {
            historialesFacadeLocal.create(historiales);
            this.mensaje ="Insertado Correctamente";
        } catch (Exception e) {
            this.mensaje="Error al Insertar";
        }
        FacesMessage msg = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msg);
    }
    
    public void consultarId_historiales(Historiales historiales){
        try {
            this.historiales = historiales;
        } catch (Exception e) {
        }
    }
    
    public void actualizar(){
        try {
            historialesFacadeLocal.create(historiales);
            this.mensaje ="Actualizado Correctamente";
        } catch (Exception e) {
            this.mensaje="Error al actualizar";
        }
        
        FacesMessage msg = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msg);
    
    }
    
    public void eliminar_historiales(Historiales historiales){
    
        try {
            historialesFacadeLocal.remove(historiales);
        this.mensaje ="Eliminado Correctamente";
        } catch (Exception e) {
            this.mensaje="Error al Eliminar";
        }
        FacesMessage msg = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msg);
        
    }
    
    public void limpiar(){
    this.historiales = new Historiales();
    this.historiales.setIdHistorial(0);
    }
    
}
