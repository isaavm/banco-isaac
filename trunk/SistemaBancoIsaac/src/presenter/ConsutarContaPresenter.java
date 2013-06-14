package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Conta;
import view.ConsultarContaView;

public class ConsutarContaPresenter {

    private ConsultarContaView view = null;
    private DefaultTableModel modeloTabela = null;

    public ConsutarContaPresenter() {
        this.view = new ConsultarContaView();
        carregarDados();
        inserirEventos();
    }

    private void carregarDados() {
        
        this.modeloTabela = new DefaultTableModel();
        this.modeloTabela.addColumn("Número da Conta");
        this.modeloTabela.addColumn("Nome do Cliente");
        this.modeloTabela.addColumn("Agencia");
        this.modeloTabela.addColumn("Limite");
        this.modeloTabela.addColumn("Status");
        this.modeloTabela.addColumn("Desativada Permanente");
        this.view.getTblContas().setModel(modeloTabela);

        // recuperar as contas e colocar no array abaixo       
        ArrayList<Conta> contas = null;

        for (Conta conta : contas) {
            Vector v = new Vector();
            v.add(conta);
            v.add(conta.getCliente());
            v.add(conta.getAgencia().getCodigo());
            v.add(conta.getLimite());
            if (conta.isStatus()) {
                v.add("Sim");
            } else {
                v.add("Não");
            }
            if (conta.isDesativarPermanente()) {
                v.add("Sim");
            } else {
                v.add("Não");
            }
            this.modeloTabela.addRow(v);
        }
    }

    private void inserirEventos() {
        this.view.getBtnAumentarLimite().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aumentarLimite();
            }
        });

        this.view.getBtnBloquear().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bloquearConta();
            }
        });

        this.view.getBtnDesativarPermanente().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                desativarPermanente();
            }
        });

        this.view.getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
        });

        this.view.getBtnLiberar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liberarConta();
            }
        });
    }

    private void aumentarLimite() {
        if (this.view.getTblContas().getSelectedRow() == 1) {
            if (!((Conta) this.view.getTblContas().getModel().getValueAt(this.view.getTblContas().getSelectedRow(), 1)).isDesativarPermanente()) {
                new AumentarLimitePresenter(((Conta) this.view.getTblContas().getModel().getValueAt(this.view.getTblContas().getSelectedRow(), 1)));
            } else {
                JOptionPane.showMessageDialog(view, "Conta bloqueada permanente.");
            }
        } else {
            JOptionPane.showMessageDialog(view, "Selecione uma linha");
        }
    }

    private void bloquearConta() {
        if (this.view.getTblContas().getSelectedRow() == 1) {
            if (!((Conta) this.view.getTblContas().getModel().getValueAt(this.view.getTblContas().getSelectedRow(), 1)).isDesativarPermanente()) {
                if (JOptionPane.showConfirmDialog(view, "Deseja bloquear a conta?") == JOptionPane.YES_OPTION) {
                    
                }
            } else {
                JOptionPane.showMessageDialog(view, "Conta bloqueada permanente.");
            }
        } else {
            JOptionPane.showMessageDialog(view, "Selecione uma linha");
        }
    }

    private void desativarPermanente() {
        if (this.view.getTblContas().getSelectedRow() == 1) {
            if (!((Conta) this.view.getTblContas().getModel().getValueAt(this.view.getTblContas().getSelectedRow(), 1)).isDesativarPermanente()) {
                if (JOptionPane.showConfirmDialog(this.view, "Deseja desativar permanentemente a conta?") == JOptionPane.YES_OPTION) {
                
                }
            } else {
                JOptionPane.showMessageDialog(view, "Conta bloqueada permanente.");
            }
        } else {
            JOptionPane.showMessageDialog(view, "Selecione uma linha");
        }
    }

    private void liberarConta() {
        if (this.view.getTblContas().getSelectedRow() == 1) {
            if (!((Conta) this.view.getTblContas().getModel().getValueAt(this.view.getTblContas().getSelectedRow(), 1)).isDesativarPermanente()) {
                if (JOptionPane.showConfirmDialog(view, "Deseja liberar a conta?") == JOptionPane.YES_OPTION) {
               
                }
            } else {
                JOptionPane.showMessageDialog(view, "Conta bloqueada permanente.");
            }
        } else {
            JOptionPane.showMessageDialog(view, "Selecione uma linha");
        }
    }

    private void fechar() {
        this.view.dispose();
    }
}
