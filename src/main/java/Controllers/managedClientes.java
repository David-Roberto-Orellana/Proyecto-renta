package Controllers;

import EJB.ClientesFacadeLocal;
import Entity.Clientes;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "managedClientes")
@SessionScoped
public class managedClientes implements Serializable {

    @EJB
    private List<Clientes> listacliente;
    private ClientesFacadeLocal clientesEJBFacadeLocal;
    private Clientes clientes;
    String mensaje;

    public List<Clientes> getListacliente() {
        this.listacliente = this.clientesEJBFacadeLocal.findAll();
        return listacliente;
    }

    public void setListacliente(List<Clientes> listacliente) {
        this.listacliente = listacliente;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @PostConstruct

    public void init() {
        clientes = new Clientes();
    }

    public void consultar_clientes() {
        try {
            listacliente = clientesEJBFacadeLocal.findAll();
        } catch (Exception e) {
        }

    }

    public void insertar_clientes() {
        try {
            clientesEJBFacadeLocal.create(clientes);
            this.mensaje = "Insertado Correctamente";
        } catch (Exception e) {
            this.mensaje = "Error al Insertar";
        }
        FacesMessage msg = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msg);

    }

    public void consultarId_clientes(Clientes cliente) {
        try {
            this.clientes = cliente;
        } catch (Exception e) {
        }
    }

    public void actualizar_clientes() {
        try {
            clientesEJBFacadeLocal.edit(clientes);
            this.mensaje = "Actualizado Correctamente";
        } catch (Exception e) {
            this.mensaje = "Error al Actualizar";
        }
        FacesMessage msg = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msg);

    }

    public void eliminar(Clientes cliente) {
        try {
            this.clientesEJBFacadeLocal.remove(clientes);
            listacliente = clientesEJBFacadeLocal.findAll();
            this.mensaje = "Eliminado Correctamente";
        } catch (Exception e) {
            this.mensaje = "Error al Eliminar";
        }
    }

}
