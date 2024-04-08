package com.example.DOJO.Contas;

import java.util.Date;

import com.example.DOJO.Model.Conta;

public class ContaInvestimento extends Conta {

    private final double depositoInicial = 1000;
    private final double taxaRendimento = 0.10;
    private Date dataAbertura;

    public ContaInvestimento(Long idConta, Long idUsuario, double saldo) {
        super(idConta, idUsuario, saldo);
        this.dataAbertura = new Date();
    }

    @Override
    public void Deposito(double valor) {
        if (saldo == 0) {
            saldo = depositoInicial;
        }
    }

    @Override
    public void Saque(double valor) {
        if (dataAbertura == null) {
            System.out.println("A conta de investimento ainda não foi aberta.");
            return;
        }

        Date dataAtual = new Date();
        long diferenca = dataAtual.getTime() - dataAbertura.getTime();
        long dias = diferenca / (1000 * 60 * 60 * 24);

        if (dias < 1) {
            System.out.println("Não é possível sacar antes de 1 dia do primeiro depósito.");
            return;
        }

        double saldoAtualizado = saldo + saldo * taxaRendimento * dias;

        if (saldoAtualizado >= valor) {
            saldo = saldoAtualizado - valor;
            System.out.println("Saque efetuado com Sucesso!!");
        } else {
            System.out.println("Saldo insuficiente para realizar o saque.");
        }
    }
}
