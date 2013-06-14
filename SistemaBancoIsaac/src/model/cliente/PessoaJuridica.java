/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.cliente;

import java.util.Date;

/**
 *
 * @author Isaac
 */
public class PessoaJuridica extends Cliente {

    public PessoaJuridica(String documento, Date data, String nome, String endereco, String nomeUsuario, String senha) {
        super(nome, endereco, nomeUsuario, senha, documento, data);
    }

    @Override
    public boolean autentica(int senha) {
        boolean ret = false;
        String pass = String.valueOf(senha);
        if (pass.equals(this.senha)) {
            ret = true;
        }
        return ret;
    }
}
