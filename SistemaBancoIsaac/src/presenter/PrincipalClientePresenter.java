/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import collection.ClienteCollection;
import collection.ICollection;
import javax.swing.JFrame;
import model.cliente.Cliente;
import view.PrincipalView;

/**
 *
 * @author Isaac
 */
class PrincipalClientePresenter {
    private Cliente logado;
    private ICollection clientes;
    private PrincipalView view;

    public PrincipalClientePresenter(Cliente cli) {
        this.logado = cli;
        this.clientes = new ClienteCollection();
        this.view = new PrincipalView();
        view.setLocationRelativeTo(null);
        view.setExtendedState(JFrame.MAXIMIZED_BOTH);
        view.pack();
    }
    
}
