/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.funcionario;

import interfaces.Autenticavel;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Isaac
 */


public abstract class Funcionario implements Serializable, Autenticavel {

    protected String nome;
    protected String endereco;
    protected long cpf;
    protected Date dataNascimento;
    protected String nomeUsuario;
    protected String senha;
    protected double salarioTotal;
    protected static final double SALARIOBASE = 650;

    public Funcionario(String nome, String endereco, long cpf, Date dataNascimento, String nomeUsuario, String senha) {
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }

    protected abstract void calculaSalario();
}
