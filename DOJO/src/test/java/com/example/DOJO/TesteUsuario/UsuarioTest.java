package com.example.DOJO.TesteUsuario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.DOJO.Contas.ContaCorrente;
import com.example.DOJO.Contas.ContaInvestimento;
import com.example.DOJO.Contas.ContaPoupanca;
import com.example.DOJO.Model.Conta;
import com.example.DOJO.Model.Usuario;

public class UsuarioTest {
    private Usuario usuario;
    private Conta conta1;
    private Conta conta2;
    private Conta conta3;

    @BeforeEach
    public void setUp() {
        usuario = new Usuario("João", 1L, 101L);
        conta1 = new ContaCorrente(1L,1L, 1000);
        conta2 = new ContaPoupanca(2L, 1L, 3000);
        conta3 = new ContaInvestimento(3L, 1L, 3000);
    }

    @Test
    public void testAdicionarConta() {
        usuario.adicionarConta(conta1);
        assertTrue(usuario.getContas().contains(conta1));
        assertEquals(1, usuario.getContas().size());
    }

    @Test
    public void testAdicionarConta_erro() {
        usuario.adicionarConta(conta1);
        usuario.adicionarConta(conta1);
        assertNotEquals(1, usuario.getContas().size());
    }

    @Test
    public void testDeletarConta() {
        usuario.adicionarConta(conta1);
        usuario.deletarConta(conta1);
        assertEquals(0, usuario.getContas().size());
    }

    @Test
    public void testDeletarConta_erro() {
        usuario.adicionarConta(conta1);
        usuario.deletarConta(conta1);
        assertNotEquals(1, usuario.getContas().size());
    }
    
    @Test
    public void testLimiteMaximoDeContas() {
        usuario.adicionarConta(conta1);
        usuario.adicionarConta(conta2);
        usuario.adicionarConta(conta3);
        Conta conta4 = new ContaCorrente(4L, usuario.getIdDoUSuario(), 4000);
        usuario.adicionarConta(conta4); 
        assertEquals(3, usuario.getContas().size());
    
   }

   @Test
   public void testLimiteMaximoDeContas_erro() {
       usuario.adicionarConta(conta1);
       usuario.adicionarConta(conta2);
       usuario.adicionarConta(conta3);
       Conta conta4 = new ContaCorrente(4L, usuario.getIdDoUSuario(), 4000);
       usuario.adicionarConta(conta4); 
       assertNotEquals(4, usuario.getContas().size());
    }

    @Test
    public void testGetSaldoTotal() {
        usuario.adicionarConta(conta1);
        usuario.adicionarConta(conta2);
        usuario.adicionarConta(conta3);
        assertEquals(7000, usuario.consultarSaldoTotaldasContas());
    }

    @Test
    public void testConsultarSaldoErro() {
        usuario.adicionarConta(conta1);
        usuario.adicionarConta(conta2);

        assertNotEquals(1000, usuario.consultarSaldoTotaldasContas());
    }
}