/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import collection.ICollection;
import formats.FormatadorData;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.funcionario.DiretorRegional;
import model.funcionario.Funcionario;
import view.InclusaoDiretorRegionalView;

/**
 *
 * @author Isaac
 */
public class InclusaoDiretorRegionalPresenter {
    
    private InclusaoDiretorRegionalView view;
    private ICollection funcionarios;
    private DiretorRegional fun;
    
    public InclusaoDiretorRegionalPresenter(ICollection funcionarios, Funcionario fun) {
        this.funcionarios = funcionarios;
        this.view = new InclusaoDiretorRegionalView();
        view.setLocationRelativeTo(null);
        view.pack();
        if (fun != null) {
            this.fun = (DiretorRegional) fun;
            constroiEdicao();
        } else {
            constroiInclusao();
        }
        view.setVisible(true);
    }
    
    private void constroiEdicao() {
        view.getBotaoSalvar().setText("Editar");
        view.getCampoSenha().setEditable(false);
        view.getCampoCpf().setText(fun.getCpf());
        view.getCampoDataNasc().setText(new FormatadorData().convertToString(fun.getDataNascimento()));
        view.getCampoEndereco().setText(fun.getEndereco());
        view.getCampoNome().setText(fun.getNome());
        view.getCampoUsuario().setText(fun.getNomeUsuario());
        view.getBotaoCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelar();
            }
        });
        view.getBotaoSalvar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    editar();
                } catch (ParseException ex) {
                    Logger.getLogger(InclusaoDiretorRegionalPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void constroiInclusao() {
        view.getBotaoCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelar();
            }
        });
        view.getBotaoSalvar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    salvar();
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(view, ex.getMessage());
                }
            }
        });
    }
    
    private void editar() throws ParseException {
        String cpf = view.getCampoCpf().getText();
        Date data = new FormatadorData().convertToDate(view.getCampoDataNasc().getText());
        String end = view.getCampoEndereco().getText();
        String nome = view.getCampoNome().getText();
        String user = view.getCampoUsuario().getText();
        if (cpf.equals("") || data.equals(null) || end.equals("") || nome.equals("") || user.equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
        } else {
            fun.setCpf(cpf);
            fun.setDataNascimento(data);
            fun.setEndereco(end);
            fun.setNome(nome);
            fun.setNomeUsuario(user);
            funcionarios.editar(fun);
            JOptionPane.showMessageDialog(view, "Funcionário editado com sucesso!");
            view.dispose();
        }
        
    }
    
    private void cancelar() {
        view.dispose();
    }
    
    private void salvar() throws ParseException {
        String cpf = view.getCampoCpf().getText();
        Date data = new FormatadorData().convertToDate(view.getCampoDataNasc().getText());
        String end = view.getCampoEndereco().getText();
        String nome = view.getCampoNome().getText();
        String user = view.getCampoUsuario().getText();
        String senha = view.getCampoSenha().getText();
        if (cpf.equals("") || data.equals(null) || end.equals("") || nome.equals("") || user.equals("") || senha.equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
        } else {
            Funcionario f = new DiretorRegional(nome, end, cpf, data, nome, senha);
            funcionarios.incluir(f);
            JOptionPane.showMessageDialog(view, "Funcionário incluido com sucesso!");
            view.dispose();
        }
    }
}
