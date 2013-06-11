/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import collection.ICollection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ListSelectionModel;
import model.funcionario.DiretorRegional;
import model.funcionario.Funcionario;
import view.ListagemDiretorRegionalView;
import view.components.ListagemDiretorRegionalTableModel;

/**
 *
 * @author Isaac
 */
public class ListagemDiretorRegionalPresenter {

    private ListagemDiretorRegionalView view;
    private ICollection diretores;
    private Funcionario diretor;

    public ListagemDiretorRegionalPresenter(ICollection diretores) {
        this.diretores = diretores;
        this.view = new ListagemDiretorRegionalView();
        view.setLocationRelativeTo(null);
        carregaDiretores();
        view.getTabelaDiReg().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        view.pack();
        view.getBotaoNovo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                novo();
                carregaDiretores();
            }
        });
        view.getBotaoEditar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editar();
                carregaDiretores();
            }
        });
        view.getBotaoFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
        });
        view.getBotaoExcluir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluir();
                carregaDiretores();
            }
        });
        view.setVisible(true);
    }

    private void novo() {
        new InclusaoDiretorRegionalPresenter(diretores, null);
    }

    private void editar() {
        diretor = ((DiretorRegional) ((ListagemDiretorRegionalTableModel) view.getTabelaDiReg().getModel()).getObject(
                view.getTabelaDiReg().getSelectedRow()));
        new InclusaoDiretorRegionalPresenter(diretores, diretor);
    }

    private void fechar() {
        view.dispose();
    }

    private void excluir() {//falta este
        diretor = ((DiretorRegional) ((ListagemDiretorRegionalTableModel) view.getTabelaDiReg().getModel()).getObject(
                view.getTabelaDiReg().getSelectedRow()));
        diretores.excluir(diretor);
    }

    private void carregaDiretores() {
        view.getTabelaDiReg().setModel(new ListagemDiretorRegionalTableModel(diretores));
    }
}
