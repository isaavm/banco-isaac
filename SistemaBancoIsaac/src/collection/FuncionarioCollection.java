/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        //  funcionarios = (ArrayList<Funcionario>) banco.getAll(Funcionario.class);
    }

    public void excluir(Funcionario a) throws Exception {
    }

    @Override
    public void incluir(T entity) {
        funcionarios.add((Funcionario) entity);
        //     banco.save(funcionarios);
    }

    @Override
    public void editar(T entity) {
        Funcionario a = (Funcionario) entity;
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getCpf().equals(a.getCpf())) {
                funcionarios.remove(i);
                funcionarios.add(a);
                break;
            }
        }
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
            try {
                throw new Exception("Agencia inexistente");
            } catch (Exception ex) {
                Logger.getLogger(FuncionarioCollection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}