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
    protected String cpf;
    protected Date dataNascimento;
    protected String nomeUsuario;
    protected String senha;
    protected double salarioTotal;
    protected static final double SALARIOBASE = 650;

    public Funcionario(String nome, String endereco, String cpf, Date dataNascimento, String nomeUsuario, String senha) {
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
    
    

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    protected abstract void calculaSalario();
}
