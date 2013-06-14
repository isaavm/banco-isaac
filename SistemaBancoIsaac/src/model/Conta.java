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
}
