package com.example.DOJO.Model;

public abstract class Conta {
    private Long idConta;
    private Long idUsuario;
    protected double saldo;

    public Conta(Long idConta, Long idUsuario, double saldo) {
        this.idConta = idConta;
        this.idUsuario = idUsuario;
        this.saldo = 0;
    }

    public double consultarSaldo() {
        return saldo;
    }

    public abstract void Saque(double valor);

    public abstract void Deposito(double valor);
    
}
