/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.cliente;

import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Isaac
 */
@Entity(name = "PessoaFisica")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@AttributeOverrides(value = {
    @AttributeOverride(name = "nome", column =
    @Column(name = "nome")),
    @AttributeOverride(name = "endereco", column =
    @Column(name = "endereco")),
    @AttributeOverride(name = "nomeUsuario", column =
    @Column(name = "nomeUsuario")),
    @AttributeOverride(name = "numTentativas", column =
    @Column(name = "numTentativas")),
    @AttributeOverride(name = "senha", column =
    @Column(name = "senha")),
    @AttributeOverride(name = "documento", column =
    @Column(name = "documento")),
    @AttributeOverride(name = "data", column =
    @Column(name = "data"))
})
public class PessoaFisica extends Cliente {

    public PessoaFisica(String documento, Date data, String nome, String endereco, String nomeUsuario, String senha) {
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
