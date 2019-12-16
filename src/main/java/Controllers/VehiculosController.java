/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import EJB.VehiculosFacadeLocal;
import Entity.Modelos;
import Entity.Vehiculos;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@SessionScoped
public class VehiculosController implements Serializable{
    
    @EJB
    private VehiculosFacadeLocal vehiculosEJB;
    private Vehiculos vehiculos;
    private List<Vehiculos>listaVehiculos;
    private Modelos modelos;

    public Modelos getModelos() {
        return modelos;
    }

    public void setModelos(Modelos modelos) {
        this.modelos = modelos;
    }

    
    public Vehiculos getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Vehiculos vehiculos) {
        this.vehiculos = vehiculos;
    }

    public List<Vehiculos> getListaVehiculos() {
        this.listaVehiculos=vehiculosEJB.findAll();
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculos> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

   
    
    @PostConstruct
    
    public void init(){
        try {
            vehiculos=new Vehiculos();
            modelos=new Modelos();
        } catch (Exception e) {
        }
    }
    
    public void insertar(){
        try {
            vehiculosEJB.create(vehiculos);
        } catch (Exception e) {
        }
    }
    
    public void listar(){
        try {
            lista=vehiculosEJB.findAll();
        } catch (Exception e) {
        }
    }
    
    public void leerId(Vehiculos veh){
        try {
            this.vehiculos=veh;
            
        } catch (Exception e) {
        }
    }
    
    public void actualizar(){
        try {
            vehiculosEJB.edit(vehiculos);
            lista=vehiculosEJB.findAll();
        } catch (Exception e) {
        }
    }
    
    public void eliminar(Vehiculos veh){
        try {
            this.vehiculos=veh;
            vehiculosEJB.remove(vehiculos);
            lista=vehiculosEJB.findAll();
        } catch (Exception e) {
        }
    }
}
