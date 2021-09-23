package com.projeto;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.projeto.model.entities.Cliente;
import com.projeto.service.ClienteService;

@SpringBootTest
class BuildersApplicationTests {
	@Autowired
	private ClienteService clienteService;


	@Test
	void contextLoads() {
		this.criarClientes();
		this.atualizarClientes();
	}
	

	void atualizarClientes(){
		
		Cliente clienteSalvo = this.clienteService.buscarPorId(1L);
		clienteSalvo.setCpf("99912233342");
		clienteSalvo.setDataNascimento(new Date("01/01/1992"));
		//Sucesso - Atualizacao de cliente existente
		this.atualizarCliente(1L, clienteSalvo);

		
		Cliente cliente = new Cliente();
		cliente.setCpf("99912233342");
		cliente.setDataNascimento(new Date("01/01/1992"));
		cliente.setNome("Mario Santos Souza");
		//Falha - Atualizacao cliente inexistente
		this.atualizarCliente(1000L, cliente);
	}
	
	void criarClientes(){
		//Falha - Sem cpf
		this.criarClienteSemCpf();
		
		//Falha - Sem nome
		this.criarClienteSemNome("98988989891");
		
		//Falha - Sem nascimento
		this.criarClienteSemDataNascimento("98988980091");
		
		//Sucesso - Criação bem sucedida
		this.criarCliente("77777777777");

		//Sucesso - Criação bem sucedida
		this.criarCliente("09890646150");
		
		//Falha - Cpf ja cadastrado
		this.criarCliente("04729646150");
	}
	
	
	Cliente criarCliente(String cpf) {
		Cliente cliente = new Cliente();
		cliente.setCpf(cpf);
		
		
		cliente.setDataNascimento(new Date("01/01/1992"));
		cliente.setNome("Rafael Souza");
		
		
		cliente = this.clienteService.salvar(cliente);
		
		assertNotEquals(cliente.getId(), null);
		return cliente;
	}

	Cliente criarClienteSemDataNascimento(String cpf) {
		Cliente cliente = new Cliente();
		cliente.setCpf(cpf);
		cliente.setNome("Rafael Souza");
		
		
		cliente = this.clienteService.salvar(cliente);
		
		assertNotEquals(cliente.getId(), null);
		return cliente;
	}

	Cliente criarClienteSemNome(String cpf) {
		Cliente cliente = new Cliente();
		cliente.setDataNascimento(new Date("01/01/1992"));
		cliente.setCpf(cpf);
		
		
		cliente = this.clienteService.salvar(cliente);
		
		assertNotEquals(cliente.getId(), null);
		return cliente;
	}
	
	Cliente criarClienteSemCpf() {
		Cliente cliente = new Cliente();
		cliente.setDataNascimento(new Date("01/01/1992"));
		cliente.setNome("Rafael Souza");
		
		
		cliente = this.clienteService.salvar(cliente);
		
		assertNotEquals(cliente.getId(), null);
		return cliente;
	}

	
	Cliente atualizarCliente(Long id, Cliente cliente) {
		cliente = this.clienteService.atualizar(id, cliente);
		
		assertNotEquals(cliente.getId(), null);
		return cliente;
	}
	


}
