/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import collection.ICollection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import model.UnidadeFederativa;
import model.funcionario.DiretorRegional;
import model.funcionario.Funcionario;
import view.DefinicaoRegionalAgenciaView;

/**
 *
 * @author Isaac
 */
public class DefinirRegionalAgenciaPresenter {

    private ICollection colecao;
    private DefinicaoRegionalAgenciaView view;

    public DefinirRegionalAgenciaPresenter(ICollection colecao) {
        this.colecao = colecao;
        this.view = new DefinicaoRegionalAgenciaView();
        Iterator<Funcionario> it = colecao.getAll().iterator();
        Funcionario func;
        ArrayList<Funcionario> listaCandidatos = new ArrayList<>();
        while (it.hasNext()) {
            func = it.next();
            if (func instanceof DiretorRegional) {//Se for diretor
                if (((DiretorRegional) func).getRegiao() == null) {
                    listaCandidatos.add(func);
                }
            }
        }
        for (Funcionario f : listaCandidatos) {
            view.getComboBoxDiretor().addItem(f);
        }
        for (UnidadeFederativa f : UnidadeFederativa.values()) {
            view.getComboBoxRegiao().addItem(f);
        }
        view.getBotaoCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelar();
            }
        });
        view.getBotaoIncluir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                definir();
            }
        });
        view.pack();
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }

    private void cancelar() {
        view.dispose();
    }

    private void definir() {
        DiretorRegional dir = (DiretorRegional) view.getComboBoxDiretor().getSelectedItem();
        String uf = view.getComboBoxRegiao().getSelectedItem().toString();
        if (dir != null && (uf != null || !"".equals(uf))) {
            dir.setRegiao(uf);
            colecao.editar(dir);
        } else {
            JOptionPane.showMessageDialog(view, "Selecione o diretor e a região!");
        }
    }
}
