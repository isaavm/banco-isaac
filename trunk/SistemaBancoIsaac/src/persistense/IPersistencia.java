/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistense;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Isaac
 */
public interface IPersistencia <T, I extends Serializable> {
    public T save(T entity);
    public List<T> getAll(Class<T> classe);
}
