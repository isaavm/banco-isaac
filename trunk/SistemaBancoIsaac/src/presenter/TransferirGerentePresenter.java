/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import collection.ICollection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import javax.swing.JOptionPane;
import model.Agencia;
import model.funcionario.Funcionario;
import model.funcionario.Gerente;
import view.TransferirGerenteView;

/**
 *
 * @author Isaac
 */

/*
 * Na transferencia a agencia antiga fica com o gerente atual como null e a nova
 * como o gerente da antiga
 */
public class TransferirGerentePresenter {
    
    private ICollection funcionarios, agencias;
    private TransferirGerenteView view;
    private Gerente gerente;
    private Agencia atual, nova;
    
    public TransferirGerentePresenter(ICollection funcionarios, ICollection agencias) {
        this.funcionarios = funcionarios;
        this.agencias = agencias;
        this.view = new TransferirGerenteView();
        view.getBotaoTrasferir().setEnabled(false);
        view.setLocationRelativeTo(null);
        view.pack();
        try {
            carregaGerentes();
            gerente = getGerenteSelecionado();
            carregaAgenciasAtuais(gerente);
            carregaAgenciasNovas();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
        view.getBotaoCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelar();
            }
        });
        view.getBotaoTrasferir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transferir();
            }
        });
    }
    
    private void transferir() {
        atual = getAgenciaSelecionadaAtual();
        nova = getAgenciaSelecionadaNova();
        atual.deixarSemGerente(funcionarios, agencias);
        nova.addGerente(gerente, funcionarios);
        agencias.editar(atual);
        agencias.editar(nova);
        try {
            gerente.addAgencia(nova);
            funcionarios.editar(gerente);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
        
    }
    
    private void cancelar() {
        view.dispose();
    }
    
    private void carregaGerentes() throws Exception {
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
        if (view.getComboGerente().getItemCount() > 0) {
            view.getComboGerente().setSelectedIndex(0);
        } else {
            throw new Exception("Não existem gerentes cadastrados ou desbloqueados!");
        }
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
    
    private void carregaAgenciasAtuais(Gerente g) throws Exception {
        if (g != null) {
            Iterator<Agencia> it = g.getAgencias().getAll().iterator();
            Agencia ag;
            while (it.hasNext()) {
                ag = it.next();
                view.getComboAtual().addItem(ag.getCodigo());
            }
            if (view.getComboAtual().getItemCount() > 0) {
                view.getComboAtual().setSelectedIndex(0);
            } else {
                throw new Exception("O gerente não possui agencias cadastradas!");
            }
        }
    }
    
    private Agencia getAgenciaSelecionadaAtual() {
        Agencia ret = null;
        Iterator<Agencia> it = agencias.getAll().iterator();
        while (it.hasNext()) {
            ret = it.next();
            if (ret.getCodigo().equals(view.getComboAtual().getSelectedItem().toString())) {
                break;
            }
        }
        return ret;
    }
    
    private void carregaAgenciasNovas() throws Exception {
        Iterator<Agencia> it = agencias.getAll().iterator();
        Agencia ag;
        while (it.hasNext()) {
            ag = it.next();
            if (!ag.getGerentes().get(ag.getGerentes().size() - 1).equals(gerente)) {
                view.getComboNovo().addItem(ag.getCodigo());
            }
        }
        
        if (view.getComboNovo().getItemCount() > 0) {
            view.getComboNovo().setSelectedIndex(0);
        } else {
            throw new Exception("Não existem agencias disponíveis para este gerente!");
        }
    }
    
    private Agencia getAgenciaSelecionadaNova() {
        Agencia ret = null;
        Iterator<Agencia> it = agencias.getAll().iterator();
        while (it.hasNext()) {
            ret = it.next();
            if (ret.getCodigo().equals(view.getComboNovo().getSelectedItem().toString())) {
                break;
            }
        }
        return ret;
    }
}
