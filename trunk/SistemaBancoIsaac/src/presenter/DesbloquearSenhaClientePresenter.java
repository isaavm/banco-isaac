/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import collection.ICollection;
import model.cliente.Cliente;

/**
 *
 * @author Isaac
 */
public class DesbloquearSenhaClientePresenter {
    private ICollection colecao;
    private Cliente cliente;

    public DesbloquearSenhaClientePresenter(ICollection colecao, Cliente cliente) {
        this.colecao = colecao;
        this.cliente = cliente;
        if(cliente.isBloqueado()){
            cliente.setNumTentativas(0);
        }
        colecao.editar(cliente);
    }
    
}
