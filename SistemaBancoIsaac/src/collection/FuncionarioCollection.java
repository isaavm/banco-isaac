/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.funcionario.Funcionario;
import persistense.IPersistencia;

/**
 *
 * @author Isaac
 */
public class FuncionarioCollection<T, I extends Serializable> implements Serializable, ICollection<T, I> {

    private ArrayList<Funcionario> funcionarios;
    private IPersistencia banco;

    public FuncionarioCollection() {
        this.funcionarios = new ArrayList<>();
        funcionarios = (ArrayList<Funcionario>) banco.getAll(Funcionario.class);
    }

    public void excluir(Funcionario a) throws Exception {
    }

    @Override
    public void incluir(T entity) {
        funcionarios.add((Funcionario) entity);
        banco.save(funcionarios);
    }

    @Override
    public void editar(T entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> getAll() {
        return (List<T>) funcionarios;
    }

    @Override
    public void excluir(T entity) {
        if (funcionarios.contains((Funcionario) entity)) {
            funcionarios.remove((Funcionario) entity);
            banco.save(funcionarios);
        } else {
            throw new Exception("Agencia inexistente");
        }
    }
}