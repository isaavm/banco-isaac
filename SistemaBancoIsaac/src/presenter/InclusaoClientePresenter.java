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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.cliente.Cliente;
import model.cliente.PessoaFisica;
import model.cliente.PessoaJuridica;
import model.funcionario.Funcionario;
import model.funcionario.Gerente;
import view.InclusaoClienteView;

/**
 *
 * @author Isaac
 */
public class InclusaoClientePresenter {
    
    private ICollection clientes;
    private Cliente clienteAtual;
    private InclusaoClienteView view;
    private Funcionario funcionario;
    
    public static void main(String args[]) {/////////////////////////teste
        new InclusaoClientePresenter(null, null, null).constroiInclusao();
    }
    
    public InclusaoClientePresenter(ICollection clientes, Cliente clienteAtual, Funcionario fun) {
        this.clientes = clientes;
        this.funcionario = funcionario;
        view = new InclusaoClienteView();
        view.setLocationRelativeTo(null);
        view.pack();
        if (clienteAtual != null) {
            this.clienteAtual = clienteAtual;
            constroiEdicao();
        } else {
            constroiInclusao();
        }
        view.setVisible(true);
    }
    
    private void constroiEdicao() {
        if (funcionario instanceof Gerente) {
            if (clienteAtual.isBloqueado()) {
                view.getBotaoDesbloquear().setEnabled(true);
                view.getBotaoDesbloquear().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new DesbloquearSenhaClientePresenter(clientes, clienteAtual);
                    }
                });
            }
            view.getBotaoSalvar().setText("Editar");
            view.getCampoSenha().setEditable(false);
            view.getCampoCpf().setText(clienteAtual.getDocumento());
            view.getCampoData().setText(new FormatadorData().convertToString(clienteAtual.getData()));
            view.getCampoEndereco().setText(clienteAtual.getEndereco());
            view.getCampoNome().setText(clienteAtual.getNome());
            view.getCampoUser().setText(clienteAtual.getNomeUsuario());
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
                        JOptionPane.showMessageDialog(view, ex.getMessage());
                    }
                }
            });
        }
    }
    
    private void constroiInclusao() {
        view.getBotaoDesbloquear().setEnabled(false);
        view.getGrupoButtonClientes().setSelected(view.getRadioFisica().getModel(), true);
        view.getRadioFisica().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interfacePessoaFisica();
            }
        });
        view.getRadioJuridica().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interfacePessoaJuridica();
            }
        });
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
                    JOptionPane.showMessageDialog(view, ex.getLocalizedMessage());
                }
            }
        });
        
    }
    
    private void interfacePessoaFisica() {
        view.getLabelCpf().setText("CPF:");
        view.getLabelData().setText("Data de nascimento:");
    }
    
    private void interfacePessoaJuridica() {
        
        view.getLabelCpf().setText("CNPJ:");
        view.getLabelData().setText("Data de abertura:");
    }
    
    private void cancelar() {
        view.dispose();
    }
    
    private void salvar() throws ParseException {
        String nome = view.getCampoNome().getText();
        String endereco = view.getCampoEndereco().getText();
        String cpf = view.getCampoCpf().getText();
        String dat = view.getCampoData().getText();
        String user = view.getCampoUser().getText();
        String senha = view.getCampoSenha().getText();
        char tipo = view.getGrupoButtonClientes().getSelection().toString().charAt(0);
        if (nome.isEmpty() || endereco.isEmpty() || cpf.isEmpty() || dat.isEmpty() || user.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(view, new FaltaPreencherCamposException());
        } else {
            Date data = new FormatadorData().convertToDate(dat);
            if (tipo == 'J') {
                clienteAtual = new PessoaJuridica(cpf, data, nome, endereco, user, senha);
            } else {
                clienteAtual = new PessoaFisica(cpf, data, nome, endereco, user, senha);
            }
            clientes.incluir(clienteAtual);
            JOptionPane.showMessageDialog(view, "Cliente incluido com sucesso!");
        }
    }
    
    private void editar() throws ParseException {
        String doc = view.getCampoCpf().getText();
        String data = view.getCampoData().getText();
        String end = view.getCampoEndereco().getText();
        String nome = view.getCampoNome().getText();
        String user = view.getCampoUser().getText();
        if (doc.isEmpty() || data.isEmpty() || end.isEmpty()
                || nome.isEmpty() || user.isEmpty()) {
            JOptionPane.showMessageDialog(view, new FaltaPreencherCamposException());
        } else {
            clienteAtual.setData(new FormatadorData().convertToDate(data));
            clienteAtual.setDocumento(doc);
            clienteAtual.setEndereco(end);
            clienteAtual.setNome(nome);
            clienteAtual.setNomeUsuario(user);
            clientes.editar(clienteAtual);
            JOptionPane.showMessageDialog(view, "Cliente editado com sucesso!");
            view.dispose();
        }
    }
}
