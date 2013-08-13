package presenter;

import collection.ClienteCollection;
import collection.FuncionarioCollection;
import com.clickjr.controleestoque.exception.FaltaPreencherCamposException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import javax.swing.JOptionPane;
import model.cliente.Cliente;
import model.funcionario.Funcionario;
import view.LoginView;

public class LoginPresenter {

    private LoginView view;

    public LoginPresenter() {
        this.view = new LoginView(null, true);
        inserirEventos();
        this.view.setLocationRelativeTo(null);
        this.view.getRootPane().setDefaultButton(view.getBtnEntrar());
        this.view.pack();
        this.view.setVisible(true);

    }

    private void inserirEventos() {
        this.view.getBtnCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelar();
            }
        });

        this.view.getBtnEntrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entrar();
            }
        });
    }

    private void cancelar() {
        this.view.dispose();
    }

    private void entrar() {
        if (view.getTxtLogin().getText().isEmpty() || view.getTxtPassSenha().getPassword().length == 0) {
            JOptionPane.showMessageDialog(view, new FaltaPreencherCamposException());
        } else {
            boolean logou = false;
            Iterator<Cliente> it = new ClienteCollection().getAll().iterator();
            Cliente cli;
            while (it.hasNext()) {
                cli = it.next();
                if (cli.getNomeUsuario().equals(view.getTxtLogin())) {
                    if (cli.autentica(Integer.parseInt(
                            String.valueOf(view.getTxtPassSenha().getPassword())))) {
                        logou = true;
                        new PrincipalClientePresenter(cli);
                    } else {
                        JOptionPane.showMessageDialog(view, "Senha incorreta!");
                    }
                }
            }
            if (!logou) {
                Funcionario fun;
                Iterator<Funcionario> i = new FuncionarioCollection().getAll().iterator();
                while (i.hasNext()) {
                    fun = i.next();
                    if (fun.getNomeUsuario().equals(view.getTxtLogin())) {
                        if (fun.autentica(Integer.parseInt(
                                String.valueOf(view.getTxtPassSenha().getPassword())))) {
                            logou = true;
                            new PrincipalFuncionarioPresenter(fun);
                        } else {
                            JOptionPane.showMessageDialog(view, "Senha incorreta!");
                        }
                    }
                }
            }
            if (!logou) {
                JOptionPane.showMessageDialog(view, "Usuário inexistente");
            }
        }
    }
}
