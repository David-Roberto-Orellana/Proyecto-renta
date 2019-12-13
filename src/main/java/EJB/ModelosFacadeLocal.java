/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Modelos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author azucena.rivasusam
 */
@Local
public interface ModelosFacadeLocal {

    void create(Modelos modelos);

    void edit(Modelos modelos);

    void remove(Modelos modelos);

    Modelos find(Object id);

    List<Modelos> findAll();

    List<Modelos> findRange(int[] range);

    int count();
    
}
