/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import collection.ICollection;
import model.cliente.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import model.funcionario.Gerente;

/**
 *
 * @author Isaac
 */

public class Agencia implements Serializable{

    private List<Cliente> clientes;
    private List<Gerente> gerentes; //histórico gerentes - Pilha
    private String uf;
    private String cidade;
    private String codigo;

    public Agencia(Cliente cliente, String uf, String cidade, String codigo) {
        this.clientes = new ArrayList<>();
        this.clientes.add(cliente);
        this.gerentes = new Stack<>();
        this.uf = uf;
        this.cidade = cidade;
        this.codigo = codigo;
    }

    public void addGerente(Gerente g, ICollection funcionarios){
        if(gerentes.isEmpty()){
        gerentes.add(g);
        }else{
            Gerente anterior = gerentes.get(gerentes.size()-1);
            anterior.removeAgencia(this);
            funcionarios.editar(anterior);
            gerentes.add(g);
        }
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
