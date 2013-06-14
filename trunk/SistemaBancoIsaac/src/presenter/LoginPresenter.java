package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.LoginView;


public class LoginPresenter {

    private LoginView view;

    public LoginPresenter() {
        this.view = new LoginView(null, true);
        inserirEventos();
        this.view.setLocationRelativeTo(null);
        this.view.getRootPane().setDefaultButton(view.getBtnEntrar());
        this.view.pack();

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
        
    }
}
