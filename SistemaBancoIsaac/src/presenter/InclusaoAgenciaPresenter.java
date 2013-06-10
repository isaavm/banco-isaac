/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import collection.ICollection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Agencia;
import view.InclusaoAgenciaView;

/**
 *
 * @author Isaac
 */
public class InclusaoAgenciaPresenter {//ok

    private InclusaoAgenciaView view;
    private ICollection agencias;
    private Agencia age;

    public InclusaoAgenciaPresenter(ICollection agencias, Agencia age) {
        this.agencias = agencias;
        view = new InclusaoAgenciaView();
        view.setLocationRelativeTo(null);
        view.pack();
        if (age != null) {
            this.age = age;
            constroiEdicao();
        } else {
            constroiInclusao();
        }
        view.setVisible(true);
    }

    private void constroiEdicao() {
        view.getBotaoFechar().setText("Cancelar");
        view.getBotaoSalvar().setText("Editar");
        view.getCampoCodigo().setEditable(false);
        view.getCampoCodigo().setText(age.getCodigo());
        view.getCampoCidade().setText(age.getCidade());
        setUfView();
        view.getBotaoFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
        });
        view.getBotaoSalvar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editar();
            }
        });
    }

    private void constroiInclusao() {

        view.getBotaoFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
        });
        view.getBotaoSalvar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvar();
            }
        });
    }

    private void salvar() {
        if (view.getCampoCodigo().getText().equals("")
                || view.getCampoCidade().getText().equals("")) {
            JOptionPane.showMessageDialog(view, "Preencha todos os campos");
        } else {
            String cod = view.getCampoCodigo().getText();
            String cid = view.getCampoCidade().getText();
            String est = view.getComboBoxEstados().getSelectedItem().toString();
            Agencia ag = new Agencia(null, est, cid, cod);
            agencias.incluir(ag);
            JOptionPane.showMessageDialog(view, "Agencia incluida com sucesso!");
            view.dispose();
        }
    }

    private void editar() {
        if (view.getCampoCidade().getText().equals("")
                || view.getComboBoxEstados().getSelectedItem().toString().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
        } else {
            String cid = view.getCampoCidade().getText();
            String est = view.getComboBoxEstados().getSelectedItem().toString();
            age.setCidade(cid);
            age.setUf(est);
            agencias.editar(age);
            JOptionPane.showMessageDialog(view, "Agencia editada com sucesso!");
            view.dispose();
        }
    }

    private void fechar() {
        view.dispose();
    }

    private void setUfView() {
        for (int i = 0; i < view.getComboBoxEstados().getItemCount(); i++) {
            if (view.getComboBoxEstados().getItemAt(i).toString().equals(age.getUf())) {
                view.getComboBoxEstados().setSelectedIndex(i);
                break;
            }
        }
    }
}
