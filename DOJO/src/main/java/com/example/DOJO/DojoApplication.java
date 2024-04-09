package com.example.DOJO;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DojoApplication {

	public static void main(String[] args) {
	SpringApplication.run(DojoApplication.class, args);
	

	Usuario usuario = new Usuario("João", 1);
	
	ContaCorrente contaCorrente = new ContaCorrente(1L, 1L, 0);
	usuario.adicionarConta(contaCorrente);

	contaCorrente.deposito(1000);

	ContaInvestimento contaInvestimento = new ContaInvestimento(2L, 1L, 0);
	usuario.adicionarConta(contaInvestimento);

	contaInvestimento.deposito(2000);

	contaInvestimento.transferirValorParaOutraConta(contaCorrente, contaInvestimento.consultarSaldo());

	try {
		ContaCorrente.sacar(2000);
	} catch (IllegalArgumentException e) {
		System.out.println(e.getMessage("Não foi possivel sacar"));
	}

	System.out.println("Saldo da conta corrente: " + contaCorrente.consultarSaldo());
    	
	}
}
