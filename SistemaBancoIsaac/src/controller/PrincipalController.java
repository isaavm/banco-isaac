/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.PrincipalView;
import collection.Agencias;
import model.Diretor;
import model.Gerente;
import model.Agencia;
import model.Cliente;
import java.util.ArrayList;

/**
 *
 * @author Isaac
 */
public class PrincipalController {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new PrincipalView();
        /*Cliente c1 = new Cliente("João", "3422-3444");
        Cliente c2 = new Cliente("Jose", "2211-5444");
        Cliente c3 = new Cliente("Marcos", "1233-3321");
        
        Agencia a1 = new Agencia(c1, "ES", "Alegre", "01");
        
        
        Agencia a2 = new Agencia(c2, "MG", "Carangola", "02");
        a2.addCliente(c3);
        
        
        Diretor d1 = new Diretor(a1, "Curió", "curio@bancodapraca.com");
        
        Gerente g1 = new Gerente(a2, "Evangivaldo", "ahlelek@bancodapraca.com");
        */
    }
}
