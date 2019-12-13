/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Extranjeros;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author azucena.rivasusam
 */
@Local
public interface ExtranjerosFacadeLocal {

    void create(Extranjeros extranjeros);

    void edit(Extranjeros extranjeros);

    void remove(Extranjeros extranjeros);

    Extranjeros find(Object id);

    List<Extranjeros> findAll();

    List<Extranjeros> findRange(int[] range);

    int count();
    
}
