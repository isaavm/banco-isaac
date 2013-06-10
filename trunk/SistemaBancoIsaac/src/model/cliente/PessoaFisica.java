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
    private long cpf;
    private Date dataNascimento;

    public PessoaFisica(long cpf, Date dataNascimento, String nome, String endereco, String nomeUsuario, String senha) {
        super(nome, endereco, nomeUsuario, senha);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public long getCpf() {
        return cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public boolean autentica(int senha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
