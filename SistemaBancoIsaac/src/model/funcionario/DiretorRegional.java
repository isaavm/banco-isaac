/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.funcionario;

import collection.AgenciaCollection;
import collection.ICollection;
import java.util.Date;
import model.Agencia;

/**
 *
 * @author Isaac
 */
public class DiretorRegional extends Funcionario{

    private ICollection agencias;
    private String regiao;


    public DiretorRegional(String nome, String endereco, String cpf, Date dataNascimento, String nomeUsuario, String senha) {
        super(nome, endereco, cpf, dataNascimento, nomeUsuario, senha);
        this.agencias = new AgenciaCollection();
        this.regiao=null;
        calculaSalario();
    }    

    @Override
    protected void calculaSalario() {
        salarioTotal = SALARIOBASE + (0.1 * agencias.getAll().size());
    }

    public void addAgencia(Agencia a) {
        agencias.incluir(a);
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }
    
    

    @Override
    public boolean autentica(int senha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
