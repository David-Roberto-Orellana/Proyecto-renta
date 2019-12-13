/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Historiales;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author azucena.rivasusam
 */
@Local
public interface HistorialesFacadeLocal {

    void create(Historiales historiales);

    void edit(Historiales historiales);

    void remove(Historiales historiales);

    Historiales find(Object id);

    List<Historiales> findAll();

    List<Historiales> findRange(int[] range);

    int count();
    
}
