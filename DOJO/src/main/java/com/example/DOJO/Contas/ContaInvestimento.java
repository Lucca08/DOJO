package com.example.DOJO.Contas;

import java.time.LocalDate;


import com.example.DOJO.Model.Conta;

public class ContaInvestimento extends Conta {

    private final double depositoInicial = 1000;
    private final double taxaRendimento = 0.10;
    private LocalDate dataAbertura;

    public ContaInvestimento(Long idConta, Long idUsuario, double saldo) {
        super(idConta, idUsuario, saldo);
        this.dataAbertura = LocalDate.now();
    }

    @Override
    public void Deposito(double valor) {
        if (saldo == 0) {
            saldo = depositoInicial;
        }else{
            saldo += valor;
        }
    }

    @Override
    public void Saque(double valor) {
        LocalDate dataAtual = LocalDate.now();
        long dias = dataAbertura.until(dataAtual).getDays();
    
        rendimento(); 
    
        if (dias < 1) {
            System.out.println("Não é possível sacar antes de 1 dia do primeiro depósito.");
            return;
        }
      
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque efetuado com Sucesso!");
        } else {
            System.out.println("Saldo insuficiente para realizar o saque.");
        }
    }
    

    private void rendimento(){
      double rendimento = saldo * taxaRendimento;
      saldo += rendimento;
    }
    
}
