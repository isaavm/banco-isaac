/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Conta;
import view.AumentarLimiteView;

public class AumentarLimitePresenter {

    private AumentarLimiteView view = null;
    private Conta conta = null;

    public AumentarLimitePresenter(Conta c) {
        this.view = new AumentarLimiteView(null, true);
        this.conta = c;
        carregarDados();
        inserirEventos();
        this.view.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        this.view.setLocationRelativeTo(null);
        this.view.pack();
        this.view.setVisible(true);
    }

    private void carregarDados() {
        this.view.getRootPane().setDefaultButton(this.view.getBtnConfirmar());
        this.view.getTxtLimiteAtual().setText(this.conta.getLimite() + "");
        this.view.getTxtNomeCliente().setText(this.conta.getCliente().getNome());
        this.view.getTxtNovoLimite().setText(0 + "");
        this.view.getTxtNumeroAgencia().setText(this.conta.getAgencia().getCodigo());
        this.view.getTxtNumeroConta().setText(this.conta.getNumeroConta() + "");

    }

    private void inserirEventos() {
        this.view.getBtnConfirmar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmar();
            }
        });
        this.view.getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
        });
    }

    private void fechar() {
        this.view.dispose();

    }

    private void confirmar() {
        try {
            this.conta.setLimite(Double.parseDouble(this.view.getTxtNovoLimite().getText() + ""));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }
}
