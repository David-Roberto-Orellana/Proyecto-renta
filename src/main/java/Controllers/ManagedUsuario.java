package Controllers;

import EJB.UsuariosFacadeLocal;
import Entity.Usuarios;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@ManagedBean
@SessionScoped
@Named(value = "ManagedUsuario")
public class ManagedUsuario implements Serializable {
 
    String mensaje;
    
    @EJB
    private UsuariosFacadeLocal usuariosFacade;
    private List<Usuarios> listaUsuarios = null;
    private Usuarios usuarios;
   

    public List<Usuarios> getListaUsuarios(){
        this.listaUsuarios= this.usuariosFacade.findAll();
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuarios> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @PostConstruct
    private void init() {
        usuarios = new Usuarios();   
        this.usuarios.setIdUsuario(0);
    }
    
    
    
      public void consultar_usuarios() {
        try {
            this.listaUsuarios = usuariosFacade.findAll();
        } catch (Exception e) {
        }
    }
    

    public void insertar_usuario() {
        try {
            this.usuariosFacade.create(usuarios);
            this.mensaje = "Insertado Correctamente";
        } catch (Exception e) {
            this.mensaje = "Error al Insertar :" + e.getMessage();
        }
        FacesMessage msg = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msg);
    }
    public void ConsultarId_usuario(Usuarios u){
        this.usuarios= u;
    }
    
    public void actualizar_usuario(){
          try {
            this.usuariosFacade.edit(usuarios);
            this.mensaje = "Actualizado Correctamente";
        } catch (Exception e) {
            this.mensaje = "Error al Actualizar :" + e.getMessage();
        }
        FacesMessage msg = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msg);
    }
    public void limpiar_usuario(){
        this.usuarios = new Usuarios();
         this.usuarios.setIdUsuario(0);
    }
    
    public void eliminar_usuarios(Usuarios u){
        this.usuarios= u;
         try {
            this.usuariosFacade.remove(u);
            listaUsuarios = usuariosFacade.findAll();
            this.mensaje = "Eliminado Correctamente";
        } catch (Exception e) {
            this.mensaje = "Error al Actualizar :" + e.getMessage();
        }
        FacesMessage msg = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(mensaje, msg); 
    }
}