/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.funcionario;

import java.util.Date;
import java.util.TreeSet;
import model.Agencia;

/**
 *
 * @author Isaac
 */
public class DiretorRegional extends Funcionario{

    private TreeSet<Agencia> agencias;


    public DiretorRegional(Agencia ag,String nome, String endereco, long cpf, Date dataNascimento, String nomeUsuario, String senha) {
        super(nome, endereco, cpf, dataNascimento, nomeUsuario, senha);
        this.agencias = new TreeSet<>();
        this.agencias.add(ag);
        calculaSalario();
    }    

    @Override
    protected void calculaSalario() {
        salarioTotal = SALARIOBASE + (0.1 * agencias.size());
    }

    public void addAgencia(Agencia a) {
        agencias.add(a);
    }

    @Override
    public boolean autentica(int senha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
