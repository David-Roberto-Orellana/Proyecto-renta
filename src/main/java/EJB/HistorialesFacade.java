/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Historiales;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author azucena.rivasusam
 */
@Stateless
public class HistorialesFacade extends AbstractFacade<Historiales> implements HistorialesFacadeLocal {

    @PersistenceContext(unitName = "carros_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HistorialesFacade() {
        super(Historiales.class);
    }
    
}
