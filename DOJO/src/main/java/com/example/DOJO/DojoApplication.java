package com.example.DOJO;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.DOJO.Contas.ContaCorrente;
import com.example.DOJO.Contas.ContaInvestimento;
import com.example.DOJO.Model.Usuario;

@SpringBootApplication
public class DojoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DojoApplication.class, args);

		Usuario usuario = new Usuario("João", 1L, 1L);

		ContaCorrente contaCorrente = new ContaCorrente(1L, 1L, 0);
		usuario.adicionarConta(contaCorrente);

		contaCorrente.deposito(1000);

		ContaInvestimento contaInvestimento = new ContaInvestimento(2L, 1L, 0);
		usuario.adicionarConta(contaInvestimento);

		contaInvestimento.deposito(2000);

		contaInvestimento.transferirValorParaOutraConta(contaCorrente, contaInvestimento.consultarSaldo());

		try {
			contaCorrente.saque(1000);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Saldo da conta corrente: " + contaCorrente.consultarSaldo());

	}
}