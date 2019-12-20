package Controllers;

import EJB.ClientesFacadeLocal;
import EJB.ExtranjerosFacadeLocal;
import EJB.LicenciasFacadeLocal;
import Entity.Clientes;
import Entity.Extranjeros;
import Entity.Licencias;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "managedClientes")
@SessionScoped
public class managedClientes implements Serializable {

    String mensaje;

    @EJB
    private ClientesFacadeLocal clientesEJBFacadeLocal;
    private List<Clientes> listacliente;
    private Clientes clientes;

    @EJB
    private LicenciasFacadeLocal licenciasFacadeLocal;
    private Licencias licencias;
    private List<Licencias> listaLicencias;

    @EJB
    private ExtranjerosFacadeLocal ExtranjerosEJBFacadeLocal;
    private List<Extranjeros> listaextranjero;
    private Extranjeros extranjeros;

    public List<Extranjeros> getListaextranjero() {
        listaextranjero = ExtranjerosEJBFacadeLocal.findAll();
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

    public List<Licencias> getListaLicencias() {
        listaLicencias = licenciasFacadeLocal.findAll();
        return listaLicencias;
    }

    public void setListaLicencias(List<Licencias> listaLicencias) {
        this.listaLicencias = listaLicencias;
    }

    public List<Clientes> getListacliente() {
        listacliente = clientesEJBFacadeLocal.findAll();
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

    public Licencias getLicencias() {
        return licencias;
    }

    public void setLicencias(Licencias licencias) {
        this.licencias = licencias;
    }

    @PostConstruct
    private void init() {
        clientes = new Clientes();
        licencias = new Licencias();
        extranjeros = new Extranjeros();
        clientes.setIdClientes(0);
        listaextranjero = ExtranjerosEJBFacadeLocal.findAll();
        listacliente = clientesEJBFacadeLocal.findAll();
    }

    public void consultar_clientes() {
        try {
            listacliente = clientesEJBFacadeLocal.findAll();
        } catch (Exception e) {
        }

    }

    public void insertar_clientes() {
        try {
            clientes.setIdLicencia(licencias);
            clientesEJBFacadeLocal.create(clientes);
            extranjeros.setIdExtranjero(clientesEJBFacadeLocal.Last_id());
            System.out.println("******************************************" + clientesEJBFacadeLocal.Last_id());
            ExtranjerosEJBFacadeLocal.create(extranjeros);
            listacliente = clientesEJBFacadeLocal.findAll();
            this.mensaje = "Insertado Correctamente";
        } catch (Exception e) {
            this.mensaje = "Error al Insertar";
        }
        FacesMessage msg = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msg);

    }

    public void consultarId_clientes(Clientes cliente) {
        try {
            this.licencias.setIdLicencia(cliente.getIdLicencia().getIdLicencia());
            this.extranjeros.setIdExtranjero(cliente.getExtranjeros().getIdExtranjero());
            this.clientes = cliente;
        } catch (Exception e) {
        }
    }

    public void actualizar_clientes() {
        try {
            clientes.setIdLicencia(licencias);
            clientesEJBFacadeLocal.edit(clientes);
            listacliente = clientesEJBFacadeLocal.findAll();
            this.mensaje = "Actualizado Correctamente";
        } catch (Exception e) {
            this.mensaje = "Error al Actualizar";
        }
        FacesMessage msg = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msg);

    }

    public void eliminar(Clientes cliente) {
        try {
            clientes = cliente;
            this.clientesEJBFacadeLocal.remove(clientes);
            listacliente = clientesEJBFacadeLocal.findAll();
            this.mensaje = "Eliminado Correctamente";
        } catch (Exception e) {
            this.mensaje = "Error al Eliminar";
        }
        FacesMessage msg = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msg);
    }

    public void limpiar() {
        clientes = new Clientes();
        licencias = new Licencias();
        extranjeros = new Extranjeros();
        managedClientes a = new managedClientes();
        listaextranjero = a.ExtranjerosEJBFacadeLocal.findAll();
        listacliente = a.clientesEJBFacadeLocal.findAll();
        clientes.setIdClientes(0);
    }

}
