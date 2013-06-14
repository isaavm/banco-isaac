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
    private String cnpj;
    private Date dataAbertura;

    public PessoaJuridica(String cnpj, Date dataAbertura, String nome, String endereco, String nomeUsuario, String senha) {
        super(nome, endereco, nomeUsuario, senha);
        this.cnpj = cnpj;
        this.dataAbertura = dataAbertura;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    @Override
    public boolean autentica(int senha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
