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
public class PessoaFisica extends Cliente{
    

    public PessoaFisica(String documento, Date data, String nome, String endereco, String nomeUsuario, String senha) {
        super(nome, endereco, nomeUsuario, senha, documento, data);
    }


    @Override
    public boolean autentica(int senha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
