/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import collection.AgenciaCollection;
import collection.ICollection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.JFrame;
import model.Agencia;
import model.cliente.Cliente;
import model.cliente.PessoaFisica;
import view.PrincipalView;

/**
 *
 * @author Isaac
 */
public class PrincipalPresenter {

    private ICollection colecao;

    /**
     * @param args the command line arguments
     */
    public PrincipalPresenter() {
        colecao = new AgenciaCollection();
        Cliente c1 = new PessoaFisica(123456, new java.util.Date(), "João paulo", "Rua qualquer", "jão", "1234");
        Cliente c2 = new PessoaFisica(123456, new java.util.Date(), "Manel paulo", "Rua qualquer", "lolo", "1234");
        Cliente c3 = new PessoaFisica(123456, new java.util.Date(), "Luucas pereira paulo", "Rua tambem", "jpo", "1234");

        Agencia a1 = new Agencia(c1, "ES", "Alegre", "01");


        Agencia a2 = new Agencia(c2, "MG", "Carangola", "02");
        a2.addCliente(c3);

        colecao.incluir(a1);
        colecao.incluir(a2);
        PrincipalView view = new PrincipalView();
        view.setLocationRelativeTo(null);
        view.setExtendedState(JFrame.MAXIMIZED_BOTH);
        view.pack();
        view.getItemAgencia().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visualizaAgencias();
            }
        });
        view.getItemDiretoria().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visualizaDiretoria();
            }
        });
        view.getItemGerente().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visualizaGerencia();
            }
        });
        view.setVisible(true);
    }

    private void visualizaAgencias() {
        new ListagemAgenciaPresenter(colecao);
    }

    private void visualizaDiretoria() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void visualizaGerencia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
