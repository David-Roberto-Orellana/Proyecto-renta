/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Reparaciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author azucena.rivasusam
 */
@Local
public interface ReparacionesFacadeLocal {

    void create(Reparaciones reparaciones);

    void edit(Reparaciones reparaciones);

    void remove(Reparaciones reparaciones);

    Reparaciones find(Object id);

    List<Reparaciones> findAll();

    List<Reparaciones> findRange(int[] range);

    int count();
    
}
