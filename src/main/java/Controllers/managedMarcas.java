/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import EJB.MarcasFacadeLocal;
import Entity.Marcas;
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
@Named(value = "managedMarcas")
@SessionScoped
public class managedMarcas implements Serializable {

    @EJB
    private MarcasFacadeLocal marcalocalEJB;
    private List<Marcas> listamarcas;
    private Marcas marcas;
    String mensaje;

    public List<Marcas> getListamarcas() {
        this.listamarcas = this.marcalocalEJB.findAll();
        return listamarcas;
    }

    public void setListamarcas(List<Marcas> listamarcas) {
        this.listamarcas = listamarcas;
    }

    public Marcas getMarcas() {
        return marcas;
    }

    public void setMarcas(Marcas marcas) {
        this.marcas = marcas;
    }

    @PostConstruct
    public void init() {
        marcas = new Marcas();
         this.marcas.setIdMarca(0);
    }

    public void consultar_marca() {
        try {
            listamarcas = marcalocalEJB.findAll();
        } catch (Exception e) {
        }

    }

    public void insertar_marca() {
        try {
            marcalocalEJB.create(marcas);
            mensaje = "Datos Insertados con Exito";
        } catch (Exception e) {
            mensaje = "Error al Insetar Datos";
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }

    public void consultarId_marcas(Marcas marca) {
        try {
            this.marcas = marca;
        } catch (Exception e) {
        }
    }

    public void actualizar_marca() {
        try {
            marcalocalEJB.edit(marcas);
            mensaje = "Datos Actualizados con Exito";
        } catch (Exception e) {
            mensaje = "Error al Actualizar Datos";
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }

    public void eliminar_marca(Marcas marca) {
        this.marcas = marca;
        try {
            marcalocalEJB.remove(marcas);
            mensaje = "Datos Eliminados con Exito";
        } catch (Exception e) {
            mensaje = "Error al Eliminar Datos";
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msj);
    }

    public void limpiar_marcas() {
        this.marcas = new Marcas();
        this.marcas.setIdMarca(0);

    }
}
