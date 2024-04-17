package com.example.DOJO.Model;
 
import java.util.ArrayList;
import java.util.List;

import com.example.DOJO.Contas.ContaCorrente;
 
public class Usuario {
    private String nome;
    private Long idDoUSuario;
    private Long idDaConta;
    private List<Conta> contas;
   
   
    public Usuario(String nome, Long idDoUSuario, Long idDaConta) {
        this.nome = nome;
        this.idDoUSuario = idDoUSuario;
        this.idDaConta = idDaConta;
        this.contas = new ArrayList<>();
    }
 
    public void adicionarConta(Conta conta) {
        if (contas.size() < 3) {
            contas.add(conta);
        } else {
            System.out.println("O úsuario já tem o número máximo de contas");
        }
    }
 
    public void deletarConta(Conta conta) {
        if (contas.contains(conta)) {
            contas.remove(conta);
        } else {
            System.out.println("Conta não encontrada");
        }
    }
 
    public double consultarSaldoTotaldasContas() {
        double saldoTotal = 0;
        for (Conta conta : contas){
            saldoTotal += conta.consultarSaldo();
        }
        return saldoTotal;
    }
 
    public String getNome() {
        return nome;
    }
 
    public Long getIdDoUSuario() {
        return idDoUSuario;
    }
 
    public Long getIdDaConta() {
        return idDaConta;
    }

    public void fecharConta(Conta conta){
        if (conta instanceof ContaCorrente){
            System.out.println("Conta corrente não pode ser fechada");
        } 
        if (contas.contains(conta)) {
            double saldoConta = conta.consultarSaldo();
            if (saldoConta > 0) {
                for (Conta c : contas) {
                    if (c instanceof ContaCorrente){
                        c.deposito(saldoConta);
                        System.out.println("Saldo da conta transferido para a conta corrente");
                        break;
                    }
                }
            }
            contas.remove(conta);
            System.out.println("Conta fechada com sucesso");
        } else {
            System.out.println("Conta não encontrada");
        }
    }
}