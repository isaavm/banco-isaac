/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import interfaces.Autenticavel;
import java.io.Serializable;

/**
 *
 * @author Isaac
 */
public class Cliente implements Autenticavel, Serializable {

    private String nome;
    private String telefone;

    public Cliente(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    @Override
    public boolean autentica(int senha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
