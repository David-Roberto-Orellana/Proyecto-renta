/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Partes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author azucena.rivasusam
 */
@Local
public interface PartesFacadeLocal {

    void create(Partes partes);

    void edit(Partes partes);

    void remove(Partes partes);

    Partes find(Object id);

    List<Partes> findAll();

    List<Partes> findRange(int[] range);

    int count();
    
}
