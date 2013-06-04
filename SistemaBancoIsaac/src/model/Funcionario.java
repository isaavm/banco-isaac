/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Isaac
 */


public class Funcionario implements Serializable {

    protected String nome;
    protected double salarioTotal;
    protected String email;
    protected static final double SALARIOBASE = 650;

    public Funcionario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public void calculaSalario(){
        
    }
}
