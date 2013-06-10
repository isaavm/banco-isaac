/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

import model.Agencia;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import persistense.IPersistencia;

/**
 *
 * @author Isaac
 */
public class AgenciaCollection<T, I extends Serializable> implements Serializable, ICollection<T, I> {

    private List<Agencia> agencias;
    private IPersistencia banco;

    public AgenciaCollection() {
        this.agencias = new ArrayList<>();
//        agencias = (ArrayList<Agencia>) banco.getAll(Agencia.class);
    }

    @Override
    public void incluir(T entity) {
        agencias.add((Agencia) entity);
   //     banco.save(agencias);
    }

    @Override
    public void editar(T entity) {
        Agencia a = (Agencia) entity;
        for(int i=0;i< agencias.size();i++){
            if(agencias.get(i).getCodigo().equals(a.getCodigo())){
                agencias.remove(i);
                agencias.add(a);
                break;
            }
        }
//        banco.save(agencias);
    }

    @Override
    public List<T> getAll() {
        return (List<T>) agencias;
    }

    @Override
    public void excluir(T entity) {
        agencias.remove((Agencia) entity);
 //       banco.save(agencias);
    }
}