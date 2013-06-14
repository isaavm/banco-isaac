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
import javax.swing.JOptionPane;
import model.cliente.Cliente;
import model.cliente.PessoaFisica;
import model.cliente.PessoaJuridica;
import view.InclusaoClienteView;

/**
 *
 * @author Isaac
 */
public class InclusaoClientePresenter {

    private ICollection clientes;
    private Cliente clienteAtual;
    private InclusaoClienteView view;

    public static void main(String args[]) {/////////////////////////teste
        new InclusaoClientePresenter(null, null).constroiInclusao();
    }

    public InclusaoClientePresenter(ICollection clientes, Cliente clienteAtual) {
        this.clientes = clientes;
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
        throw new UnsupportedOperationException("Not yet implemented");
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
}
