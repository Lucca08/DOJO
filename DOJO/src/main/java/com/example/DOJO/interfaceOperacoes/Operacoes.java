package com.example.DOJO.interfaceOperacoes;

import com.example.DOJO.Model.Conta;

public interface Operacoes {
    void deposito(double valor);
    void saque(double valor);
    double consultarSaldo();

    default void transferirValorParaOutraConta(Conta contaDestino, double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido");
        }

        if (this.consultarSaldo() < valor) {
            System.out.println("Saldo insuficiente");
        } else {
            this.saque(valor);
            contaDestino.deposito(valor);   
        }
    }

        
}
