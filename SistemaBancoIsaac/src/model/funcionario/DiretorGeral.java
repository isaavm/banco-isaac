/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.funcionario;

import collection.AgenciaCollection;
import collection.ICollection;
import java.util.Date;

/**
 *
 * @author Isaac
 */
public class DiretorGeral extends Funcionario {

    private ICollection agencias;

    public DiretorGeral(String nome, String endereco, long cpf, Date dataNascimento, String nomeUsuario, String senha) {
        super(nome, endereco, cpf, dataNascimento, nomeUsuario, senha);
        this.agencias = new AgenciaCollection();
        calculaSalario();
    }

    @Override
    protected void calculaSalario() {
        salarioTotal = SALARIOBASE + (0.1 * agencias.getAll().size());
    }

    @Override
    public boolean autentica(int senha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
