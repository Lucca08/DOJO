package com.example.DOJO.Contas;

import com.example.DOJO.Model.Conta;


public class ContaCorrente extends Conta{
    private final int limiteNegativo = -500;

    public ContaCorrente(Long idConta, Long idUsuario, double saldo) {
        super(idConta, idUsuario, saldo);
    }

    @Override
    public void Saque(double valor) {
        if(valor <= 0) {
            throw new IllegalArgumentException("Valor inválido");
        } 
        if(this.saldo - valor < limiteNegativo){
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        this.saldo -= valor;
        System.out.println("Saque efetuado com Sucesso!!");
    }

    
}
   