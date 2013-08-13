/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.conta.Conta;
import collection.ICollection;
import model.cliente.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javax.persistence.Entity;
import javax.persistence.*;
import model.funcionario.Gerente;

/**
 *
 * @author Isaac
 */
@Entity(name="Agencia")
public class Agencia implements Serializable {

    @OneToMany()
    private List<Cliente> clientes;
    @OneToOne
    private List<Gerente> gerentes; //histórico gerentes - Pilha
    @OneToMany
    private List<Conta> contas;
    @Column
    private String uf;
    @Column(nullable=false)
    private String cidade;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String codigo;

    public Agencia() {
    }

    public Agencia(Cliente cliente, String uf, String cidade, String codigo) {
        this.clientes = new ArrayList<>();
        this.clientes.add(cliente);
        this.gerentes = new Stack<>();
        this.uf = uf;
        this.cidade = cidade;
        this.codigo = codigo;
    }

    public void deixarSemGerente(ICollection funcionarios, ICollection agencias) {
        Gerente ultimo = gerentes.get(gerentes.size() - 1);
        if (ultimo != null) {
            gerentes.add(null);
            ultimo.removeAgencia(this);
            funcionarios.editar(ultimo);
            agencias.editar(this);
        }

    }

    public void addGerente(Gerente g, ICollection funcionarios) {
        if (gerentes.isEmpty()) {
            gerentes.add(g);
        } else {
            if (gerentes.get(gerentes.size() - 1) == null) {
                gerentes.remove(gerentes.size() - 1);
                gerentes.add(g);
            } else {
                Gerente anterior = gerentes.get(gerentes.size() - 1);
                anterior.removeAgencia(this);
                funcionarios.editar(anterior);
                gerentes.add(g);
            }
        }
    }

    public void addCliente(Cliente c) {
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

    public List<Gerente> getGerentes() {
        return gerentes;
    }

    @Override
    public String toString() {
        return codigo + "," + cidade + "," + uf;
    }
}
