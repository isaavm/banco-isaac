package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.CadastrarContaView;

public class CadastrarContaPresenter {

    private CadastrarContaView view = null;

    public CadastrarContaPresenter() {
        this.view = new CadastrarContaView();
        carregarDados();
        inserirEventos();
    }

    private void carregarDados() {
        // preencher combo box cliente
        // preencher combo box agencia
        // gerar numero da conta que será criada e preencher
    }

    private void inserirEventos() {
        this.view.getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
        });

        this.view.getBtnSalvar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvar();
            }
        });

    }

    private void salvar() {
        //salvar a conta
    }

    private void fechar() {
        this.view.dispose();
    }
}
