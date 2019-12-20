/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Clientes;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author azucena.rivasusam
 */
@Stateless
public class ClientesFacade extends AbstractFacade<Clientes> implements ClientesFacadeLocal {

    @PersistenceContext(unitName = "carros_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientesFacade() {
        super(Clientes.class);
    }

    @Override
    public int Last_id() {
        int id = 0;
        String sql = "SELECT c FROM Clientes c "
                + "ORDER BY c.idClientes DESC";
        try {
            Query q = em.createQuery(sql);
            List<Clientes> lista= q.getResultList();
            if (!lista.isEmpty()) {
                id = lista.get(0).getIdClientes();
            }
        } catch (Exception e) {
            
            System.out.println("*********************************************");
            System.out.println("*********************************************");
            System.out.println("Error al ejecutar Last_id");
            System.out.println(e);
            System.out.println("*********************************************");
            System.out.println("*********************************************");
        }
        return id;
        }

    }
