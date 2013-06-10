/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.funcionario;

import java.util.Date;
import java.util.Iterator;
import java.util.TreeSet;
import model.Agencia;

/**
 *
 * @author Isaac
 */
public class Gerente extends Funcionario {
    
    private TreeSet<Agencia> agencias;
    
    public Gerente(Agencia ag, String nome, String endereco, long cpf, Date dataNascimento, String nomeUsuario, String senha) {
        super(nome, endereco, cpf, dataNascimento, nomeUsuario, senha);
        agencias = new TreeSet<>();
        agencias.add(ag);
        calculaSalario();
    }
    
    @Override
    protected void calculaSalario() {
        int totalClientes = 0;
        Iterator<Agencia> it = agencias.iterator();
        while (it.hasNext()) {
            totalClientes += it.next().calculaNumClientes();
        }
        salarioTotal = SALARIOBASE + (0.01 * totalClientes) + calculaAdicional();
    }
    
    private double calculaAdicional() {
        double ret = 0;
        Iterator<Agencia> it = agencias.iterator();
        while (it.hasNext()) {
            Agencia a = it.next();
            if (a.getUf().equals("AC")) {
                ret += SALARIOBASE * 0.2;
            }
            if (a.getUf().equals("AL")) {
                ret += SALARIOBASE * 0.2;
            }
            if (a.getUf().equals("AP")) {
                ret += SALARIOBASE * 0.2;
            }
            if (a.getUf().equals("AM")) {
                ret += SALARIOBASE * 0.2;
            }
            if (a.getUf().equals("BA")) {
                ret += SALARIOBASE * 0.2;
            }
            if (a.getUf().equals("CE")) {
                ret += SALARIOBASE * 0.2;
            }
            if (a.getUf().equals("DF")) {
                ret += SALARIOBASE * 0.2;
            }
            if (a.getUf().equals("ES")) {
                ret += SALARIOBASE * 0.2;
            }
            if (a.getUf().equals("GO")) {
                ret += SALARIOBASE * 0.2;
            }
            if (a.getUf().equals("MA")) {
                ret += SALARIOBASE * 0.2;
            }
            if (a.getUf().equals("MT")) {
                ret += SALARIOBASE * 0.2;
            }
            if (a.getUf().equals("MS")) {
                ret += SALARIOBASE * 0.2;
            }
            if (a.getUf().equals("MG")) {
                ret += SALARIOBASE * 0.2;
            }
            if (a.getUf().equals("PA")) {
                ret += SALARIOBASE * 0.2;
            }
            if (a.getUf().equals("PB")) {
                ret += SALARIOBASE * 0.2;
            }
            if (a.getUf().equals("PR")) {
                ret += SALARIOBASE * 0.2;
            }
            if (a.getUf().equals("PE")) {
                ret += SALARIOBASE * 0.2;
            }
            if (a.getUf().equals("PI")) {
                ret += SALARIOBASE * 0.2;
            }
            if (a.getUf().equals("RJ")) {
                ret += SALARIOBASE * 0.2;
            }
            if (a.getUf().equals("RN")) {
                ret += SALARIOBASE * 0.2;
            }
            if (a.getUf().equals("RS")) {
                ret += SALARIOBASE * 0.2;
            }
            if (a.getUf().equals("RO")) {
                ret += SALARIOBASE * 0.2;
            }
            if (a.getUf().equals("RR")) {
                ret += SALARIOBASE * 0.2;
            }
            if (a.getUf().equals("SC")) {
                ret += SALARIOBASE * 0.2;
            }
            if (a.getUf().equals("SP")) {
                ret += SALARIOBASE * 0.2;
            }
            if (a.getUf().equals("SE")) {
                ret += SALARIOBASE * 0.2;
            }
            if (a.getUf().equals("TO")) {
                ret += SALARIOBASE * 0.2;
            }
        }
        return ret;
    }
    
    public void addAgencia(Agencia a) throws Exception {
        if (agencias.size() <= 2) {
            agencias.add(a);
        } else {
            throw new Exception("Numero maximo de agencias atingido");
        }
    }
    
    @Override
    public boolean autentica(int senha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}