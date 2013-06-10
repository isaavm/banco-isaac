/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Isaac
 */
public interface ICollection<T, I extends Serializable> {
    void incluir(T entity);
    
    void editar(T entity);
        
    List<T> getAll();

    public void excluir(T entity);
    
    
}
