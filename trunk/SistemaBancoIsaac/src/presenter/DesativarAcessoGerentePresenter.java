/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import collection.ICollection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import model.funcionario.Funcionario;
import model.funcionario.Gerente;
import view.DesativarAcessoGerenteView;

/**
 *
 * @author Isaac
 */
public class DesativarAcessoGerentePresenter {

    private ICollection funcionarios;
    private DesativarAcessoGerenteView view;
    private Funcionario gerente;

    public DesativarAcessoGerentePresenter(ICollection funcionarios) {
        this.funcionarios = funcionarios;
        this.view = new DesativarAcessoGerenteView();
        view.setLocationRelativeTo(null);
        view.pack();
        carregaGerentes();
        view.getBotaoCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelar();
            }
        });
        view.getBotaoRevogar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                revogarAcesso();
            }
        });
    }

    private void cancelar() {
        view.dispose();
    }

    private void revogarAcesso() {
        Gerente x9 = getGerenteSelecionado(); //hehe
        x9.setIsBlocked(true);
        funcionarios.editar(x9);
    }

    private void carregaGerentes() {
        Iterator<Funcionario> it = funcionarios.getAll().iterator();
        Funcionario ger;
        while (it.hasNext()) {
            ger = it.next();
            if (ger instanceof Gerente) {
                if (!((Gerente) ger).isIsBlocked()) {// se for instancia de gerente e não estiver bloqueado
                    view.getComboGerente().addItem(ger.getCpf());
                }
            }
        }
        view.getComboGerente().setSelectedIndex(0);
    }

    private Gerente getGerenteSelecionado() {
        Funcionario ret = null;
        Iterator<Funcionario> it = funcionarios.getAll().iterator();
        while (it.hasNext()) {
            ret = it.next();
            if (ret.getCpf().equals(view.getComboGerente().getSelectedItem().toString())) {
                break;
            }
        }
        return (Gerente) ret;
    }
}
