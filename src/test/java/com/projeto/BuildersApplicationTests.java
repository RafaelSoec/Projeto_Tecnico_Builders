package com.projeto;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
		//this.criarAluno("04729646150");
		//this.criarPlano();
		
	}
	
	Cliente criarCliente(String cpf) {
		Cliente cliente = new Cliente();
		cliente.setCpf(cpf);
		
		
	//	cliente.setDataNascimento(new Date("01/01/1992"));
		cliente.setNome("Rafael Souza");
		
		
		cliente = this.clienteService.salvar(cliente);
		
		assertNotEquals(cliente.getId(), null);
		return cliente;
	}
	


}
