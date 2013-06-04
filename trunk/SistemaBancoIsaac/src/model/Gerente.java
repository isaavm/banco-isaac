/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import interfaces.Autenticavel;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Isaac
 */

public class Gerente extends Funcionario implements Autenticavel, Serializable {

    private ArrayList<Agencia> agencia;

    public Gerente(Agencia agencia, String nome, String email) {
        super(nome, email);
        
        calculaSalario();
    }

    @Override
    public void calculaSalario() {
        int totalClientes = 0;
        for (int i = 0; i < agencia.size(); i++) {
            totalClientes += agencia.get(i).calculaNumClientes();
        }
        salarioTotal = SALARIOBASE + (0.01 * totalClientes) + calculaAdicional();
    }

    private double calculaAdicional() {
        double ret = 0;
        for (int i = 0; i < agencia.size(); i++) {
            if (agencia.get(i).getUf().equals("AC")) {
                ret += SALARIOBASE * 0.2;
            }
            if (agencia.get(i).getUf().equals("AL")) {
                ret += SALARIOBASE * 0.2;
            }
            if (agencia.get(i).getUf().equals("AP")) {
                ret += SALARIOBASE * 0.2;
            }
            if (agencia.get(i).getUf().equals("AM")) {
                ret += SALARIOBASE * 0.2;
            }
            if (agencia.get(i).getUf().equals("BA")) {
                ret += SALARIOBASE * 0.2;
            }
            if (agencia.get(i).getUf().equals("CE")) {
                ret += SALARIOBASE * 0.2;
            }
            if (agencia.get(i).getUf().equals("DF")) {
                ret += SALARIOBASE * 0.2;
            }
            if (agencia.get(i).getUf().equals("ES")) {
                ret += SALARIOBASE * 0.2;
            }
            if (agencia.get(i).getUf().equals("GO")) {
                ret += SALARIOBASE * 0.2;
            }
            if (agencia.get(i).getUf().equals("MA")) {
                ret += SALARIOBASE * 0.2;
            }
            if (agencia.get(i).getUf().equals("MT")) {
                ret += SALARIOBASE * 0.2;
            }
            if (agencia.get(i).getUf().equals("MS")) {
                ret += SALARIOBASE * 0.2;
            }
            if (agencia.get(i).getUf().equals("MG")) {
                ret += SALARIOBASE * 0.2;
            }
            if (agencia.get(i).getUf().equals("PA")) {
                ret += SALARIOBASE * 0.2;
            }
            if (agencia.get(i).getUf().equals("PB")) {
                ret += SALARIOBASE * 0.2;
            }
            if (agencia.get(i).getUf().equals("PR")) {
                ret += SALARIOBASE * 0.2;
            }
            if (agencia.get(i).getUf().equals("PE")) {
                ret += SALARIOBASE * 0.2;
            }
            if (agencia.get(i).getUf().equals("PI")) {
                ret += SALARIOBASE * 0.2;
            }
            if (agencia.get(i).getUf().equals("RJ")) {
                ret += SALARIOBASE * 0.2;
            }
            if (agencia.get(i).getUf().equals("RN")) {
                ret += SALARIOBASE * 0.2;
            }
            if (agencia.get(i).getUf().equals("RS")) {
                ret += SALARIOBASE * 0.2;
            }
            if (agencia.get(i).getUf().equals("RO")) {
                ret += SALARIOBASE * 0.2;
            }
            if (agencia.get(i).getUf().equals("RR")) {
                ret += SALARIOBASE * 0.2;
            }
            if (agencia.get(i).getUf().equals("SC")) {
                ret += SALARIOBASE * 0.2;
            }
            if (agencia.get(i).getUf().equals("SP")) {
                ret += SALARIOBASE * 0.2;
            }
            if (agencia.get(i).getUf().equals("SE")) {
                ret += SALARIOBASE * 0.2;
            }
            if (agencia.get(i).getUf().equals("TO")) {
                ret += SALARIOBASE * 0.2;
            }
        }
        return ret;
    }

    public void addAgencia(Agencia a) throws Exception {
        if (agencia.size() <= 2) {
            agencia.add(a);
        } else {
            throw new Exception("Numero maximo de agencias atingido");
        }
    }

    @Override
    public boolean autentica(int senha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}