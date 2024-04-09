package com.example.DOJO.Model;

import com.example.DOJO.interfaceOperacoes.Operacoes;

public abstract class Conta implements Operacoes{
    private Long idConta;
    private Long idUsuario;
    protected double saldo;

    public Conta(Long idConta, Long idUsuario, double saldo) {
        this.idConta = idConta;
        this.idUsuario = idUsuario;
        this.saldo = 0;
    }

    @Override
    public double consultarSaldo() {
        return saldo;
    }

    @Override
    public void deposito(double valor) {
        this.saldo += valor;
    }
    
}
