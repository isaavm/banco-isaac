/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.cliente.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.funcionario.Gerente;

/**
 *
 * @author Isaac
 */

public class Agencia implements Serializable{

    private List<Cliente> clientes;
    private List<Gerente> gerentes; //histórico gerentes
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

    public void addCliente(Cliente c){
        clientes.add(c);
    }
    public int calculaNumClientes() {
        return clientes.size();
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public String getCodigo() {
        return codigo;
    }

    
    @Override
    public String toString() {
        return codigo + "," + cidade + "," + uf ;
    }
}
