/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Isaac
 */

public class Agencia implements Serializable{

    private ArrayList<Cliente> clientes;
    private String uf;
    private String cidade;
    private String codigo;

    public Agencia(Cliente cliente, String uf, String cidade, String codigo) {
        this.clientes = new ArrayList<>();
        this.clientes.add(cliente);
        this.uf = uf;
        this.cidade = cidade;
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
    
    
    public void addCliente(Cliente c){
        clientes.add(c);
    }
    public int calculaNumClientes() {
        return clientes.size();
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public String getUf() {
        return uf;
    }

    @Override
    public String toString() {
        return codigo + "," + cidade + "," + uf ;
    }
    
    
}
