package br.com.caelum.financas.teste;

import br.com.caelum.financas.modelo.Cliente;

public class TestaContaCliente {

	public static void main(String[] args) {
		Cliente cliente=new Cliente();
		cliente.setNome("Gabrie");
		cliente.setEndereco("rua nena");
		System.out.println("Teste de pull");
	}
}
