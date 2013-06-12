/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import collection.ICollection;
import exceptions.FaltaPreencherCamposException;
import formats.FormatadorData;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JOptionPane;
import model.Agencia;
import model.funcionario.Funcionario;
import model.funcionario.Gerente;
import view.CadastrarGerenteView;

/**
 *
 * @author Isaac
 */
public class CadastrarGerentePresenter {

    private ICollection funcionarios;
    private ICollection agencias;
    private CadastrarGerenteView view;
    private Funcionario gerente;

    public CadastrarGerentePresenter(ICollection funcionarios, ICollection agencias) {
        this.funcionarios = funcionarios;
        this.agencias = agencias;
        this.view = new CadastrarGerenteView();
        view.setLocationRelativeTo(null);
        carregaAgencias();
        view.pack();
        view.getBotaoCadastrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cadastrar();
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(view, ex.getCause().getMessage());
                }
            }
        });
        view.getBotaoCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelar();
            }
        });
        view.setVisible(true);
    }

    private void cancelar() {
        view.dispose();
    }

    private void cadastrar() throws ParseException {
        String nome = view.getCampoNome().getText();
        String endereco = view.getCampoEndereco().getText();
        String cpf = view.getCampoCpf().getText();
        String nascimento = view.getCampoNascimento().getText();
        String user = view.getCampoUser().getText();
        String senha = view.getCampoSenha().getText();
        if (nome.equals("") || endereco.equals("") || cpf.equals("")
                || nascimento.equals("") || user.equals("") || senha.equals("")) {
            JOptionPane.showMessageDialog(view, new FaltaPreencherCamposException().getMessage());
        } else {
            Date data = new FormatadorData().convertToDate(nascimento);
            Agencia a = getAgenciaSelecionada();
            gerente = new Gerente(a, nome, endereco, cpf, data, nome, senha);
            a.addGerente((Gerente) gerente, funcionarios);
            funcionarios.incluir(gerente);
            agencias.editar(a);
            JOptionPane.showMessageDialog(view, "Gerente cadastrado com sucesso!");
        }
        view.dispose();
    }

    private void carregaAgencias() {
        Iterator<Agencia> it = agencias.getAll().iterator();
        Agencia ag;
        while (it.hasNext()) {
            ag = it.next();
            view.getComboAgencias().addItem(ag.getCodigo());
        }
        view.getComboAgencias().setSelectedIndex(0);
    }

    private Agencia getAgenciaSelecionada() {
        Agencia ret = null;
        Iterator<Agencia> it = agencias.getAll().iterator();
        while (it.hasNext()) {
            ret = it.next();
            if (ret.getCodigo().equals(view.getComboAgencias().getSelectedItem().toString())) {
                break;
            }
        }
        return ret;
    }
}
