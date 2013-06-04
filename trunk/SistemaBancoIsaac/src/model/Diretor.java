/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import interfaces.Autenticavel;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Isaac
 */
public class Diretor extends Funcionario implements Autenticavel, Serializable {

    private ArrayList<Agencia> agencia;

    public Diretor(Agencia agencia, String nome, String email) {
        super(nome, email);
        this.agencia = new ArrayList<>();
        this.agencia.add(agencia);
        calculaSalario();
    }

    @Override
    public void calculaSalario() {
        salarioTotal = SALARIOBASE + (0.1 * agencia.size());
    }

    public void addAgencia(Agencia a) {
        agencia.add(a);
    }

    @Override
    public boolean autentica(int senha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
