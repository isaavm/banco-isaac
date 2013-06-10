/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import model.cliente.Cliente;
import persistense.IPersistencia;

/**
 *
 * @author Isaac
 */
public class ClienteCollection<T, I extends Serializable> implements Serializable, ICollection<T, I> {

    private List<Cliente> clientes;
    private IPersistencia banco;

    public ClienteCollection() {
        this.clientes = new ArrayList<>();
        clientes = (ArrayList<Cliente>) banco.getAll(Cliente.class);
    }

    public void excluir(Cliente a) throws Exception {
    }

    @Override
    public void incluir(T entity) {
        clientes.add((Cliente) entity);
        banco.save(clientes);
    }

    @Override
    public void editar(T entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> getAll() {
        return (List<T>) clientes;
    }

    @Override
    public void excluir(T entity) {
        if (clientes.contains((Cliente)entity)) {
            clientes.remove((Cliente)entity);
            banco.save(clientes);
        } else {
            throw new Exception("Agencia inexistente");
        }
    }
}
