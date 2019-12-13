/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Marcas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author azucena.rivasusam
 */
@Local
public interface MarcasFacadeLocal {

    void create(Marcas marcas);

    void edit(Marcas marcas);

    void remove(Marcas marcas);

    Marcas find(Object id);

    List<Marcas> findAll();

    List<Marcas> findRange(int[] range);

    int count();
    
}
