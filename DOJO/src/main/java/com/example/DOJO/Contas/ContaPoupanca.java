package com.example.DOJO.Contas;

import java.util.Date;

import com.example.DOJO.Model.Conta;

public class ContaPoupanca extends Conta {
    private final double depositoInicial = 50.00;
    private final double taxaRendimento = 0.05;
    private Date dataAbertura;

    public ContaPoupanca(Long idConta, Long idUsuario) {
        super(idConta, idUsuario, 0); 
        this.dataAbertura = new Date();
        this.saldo = depositoInicial; 

    }
    
    @Override
    public void Deposito(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido para depósito.");
        }
        this.saldo += valor;
        System.out.println("Depósito efetuado com sucesso!");
    }

    @Override
    public void Saque(double valor) {
        if (saldo >= valor && saldo - valor >= 0) {
            saldo -= valor;
            System.out.println("Saque efetuado com sucesso!");
        } else {
            System.out.println("Não é possível realizar o saque.");
        }
    }

    public double consultarSaldo() {
        if (dataAbertura != null) {
            Date dataAtual = new Date();
            long diffEmDias = (dataAtual.getTime() - dataAbertura.getTime()) / (1000 * 60 * 60 * 24);
            double saldoAtualizado = saldo * Math.pow(1 + taxaRendimento, diffEmDias);
            return saldoAtualizado;
        } else {
            return saldo;
        }
    }
}
