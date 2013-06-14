package model;

import model.cliente.Cliente;

public class Conta {
    // true= conta boloqueada, false = conta liberada
    private boolean status = false;
    
    // true= conta desativada permantente, false= conta não bloqueada
    private boolean desativarPermanente = false;
    
    private Cliente cliente = null;
    
    private Agencia agencia = null;
    
    private int numeroConta = 0;
    
    private double limite = 0.0;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isDesativarPermanente() {
        return desativarPermanente;
    }

    public void setDesativarPermanente(boolean desativarPermanente) {
        this.desativarPermanente = desativarPermanente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }        

    @Override
    public String toString() {
        return this.numeroConta+"";
    }
    
    
}
