/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import collection.ICollection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ListSelectionModel;
import model.Agencia;
import view.ListagemAgenciaView;
import view.components.ListagemAgenciaTableModel;

/**
 *
 * @author Isaac
 */
public class ListagemAgenciaPresenter {

    private ListagemAgenciaView view;
    private ICollection agencias;
    private Agencia agenciaAtual;

    public ListagemAgenciaPresenter(ICollection agencias) {
        this.agencias = agencias;
        this.view = new ListagemAgenciaView();
        view.setLocationRelativeTo(null);
        carregaAgencias();
        view.getTabAgencia().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        view.pack();
        view.getBotaoNovo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                novo();
                carregaAgencias();
            }
        });
        view.getBotaoEditar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editar();
                carregaAgencias();
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
                carregaAgencias();
            }
        });
        view.setVisible(true);
    }

    private void novo() {
        new InclusaoAgenciaPresenter(agencias, null);
    }

    private void editar() {
        agenciaAtual = ((Agencia) ((ListagemAgenciaTableModel) view.getTabAgencia().getModel()).getObject(
                view.getTabAgencia().getSelectedRow()));
        new InclusaoAgenciaPresenter(agencias, agenciaAtual);
    }

    private void fechar() {
        view.dispose();
    }

    private void excluir() {//falta este
        agenciaAtual = ((Agencia) ((ListagemAgenciaTableModel) view.getTabAgencia().getModel()).getObject(
                view.getTabAgencia().getSelectedRow()));
        agencias.excluir(agenciaAtual);
    }

    private void carregaAgencias() {
        /*DefaultTableModel tm = new DefaultTableModel(
         new Object[][]{},
         new String[]{"Código", "Cidade", "UF"});
         tm.setRowCount(0);
         Iterator<Agencia> it = agencias.getAll().iterator();
         while (it.hasNext()) {
         Agencia a = it.next();
         String linha = a.toString();
         String[] campos = linha.split(",");
         tm.addRow(new Object[]{campos});
         }*/

        view.getTabAgencia().setModel(new ListagemAgenciaTableModel(agencias));
    }
}
