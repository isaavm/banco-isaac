/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.cliente;

import interfaces.Autenticavel;
import java.io.Serializable;
import java.util.Date;

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
    protected String documento;
    protected Date data;

    public Cliente(String nome, String endereco, String nomeUsuario, String senha, String documento, Date data) {
        this.nome = nome;
        this.endereco = endereco;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.documento = documento;
        this.data = data;
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

    public String getDocumento() {
        return documento;
    }

    public Date getData() {
        return data;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setNumTentativas(int numTentativas) {
        this.numTentativas = numTentativas;
    }
    
    
}
