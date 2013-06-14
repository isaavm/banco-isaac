/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.cliente;

import interfaces.Autenticavel;
import java.io.Serializable;

/**
 *
 * @author Isaac
 */
public abstract class Cliente implements Autenticavel, Serializable {

    protected String nome;
    protected String endereco;
    protected String nomeUsuario;
    protected int numTentativas;
    protected String senha;

    public Cliente(String nome, String endereco, String nomeUsuario, String senha) {
        this.nome = nome;
        this.endereco = endereco;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.numTentativas = 0;
    }

    public final boolean isBloqueado() {
        boolean ret = true;
        if (numTentativas < 3) {
            ret = false;
        }
        return ret;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public int getNumTentativas() {
        return numTentativas;
    }

    public String getSenha() {
        return senha;
    }

    public void setNumTentativas(int numTentativas) {
        this.numTentativas = numTentativas;
    }
    
    
}
