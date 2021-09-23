package com.projeto;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.projeto.model.entities.Cliente;
import com.projeto.repository.ClienteRepository;
import com.projeto.service.ClienteService;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
public class ClienteServiceTests {
	@Mock
	private ClienteRepository clienteRepository;
	
	@InjectMocks
	private ClienteService clienteService;

	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}


	@Test
	void testeRecuperarIdadeCliente() {
		Cliente cliente = new Cliente();
		cliente.setDataNascimento(new Date("01/03/1993"));

		assertEquals(28, cliente.getIdade());
		
	}
	
	@Test
	void testeRecuperarClientePorCpf() {
		String cpf = "00066912365";

		Cliente cliente = Mockito.mock(Cliente.class);
		Mockito.when(cliente.getCpf()).thenReturn(cpf);
		
		Mockito.mock(Cliente.class);
		Mockito.when(clienteRepository.recuperarClientePorCpf(ArgumentMatchers.eq(cpf))).thenReturn(cliente);
		
	}
	

	@Test
	void testeSalvarClienteSucesso() {
		String cpf = "00066912365";
		Cliente cliente = new Cliente();
		cliente.setCpf(cpf);
		cliente.setDataNascimento(new Date("01/01/1992"));
		cliente.setNome("Rafael Souza");
        
		assertDoesNotThrow(() -> clienteService.salvar(cliente));
	}

	@Test
	void testeSalvarClienteSemCpf() {
		Cliente cliente = new Cliente();
		cliente.setDataNascimento(new Date("01/01/1992"));
		cliente.setNome("Rafael Souza");
		
		RuntimeException exception = assertThrows(RuntimeException.class, () -> clienteService.salvar(cliente));
		assertEquals("CPF não informado.", exception.getMessage());
	}

	@Test
	void testeSalvarClienteSemDataNascimento() {
		String cpf = "00066912365";
		Cliente cliente = new Cliente();
		cliente.setNome("Rafael Souza");
		cliente.setCpf(cpf);
		
		RuntimeException exception = assertThrows(RuntimeException.class, () -> clienteService.salvar(cliente));
		assertEquals("Data de nascimento não informada.", exception.getMessage());
	}
	
	@Test
	void testeSalvarClienteSemNome() {
		String cpf = "00066912365";
		Cliente cliente = new Cliente();
		cliente.setCpf(cpf);
		cliente.setDataNascimento(new Date("01/01/1992"));
		
		RuntimeException exception = assertThrows(RuntimeException.class, () -> clienteService.salvar(cliente));
		assertEquals("Nome não informado.", exception.getMessage());
	}
	

	@Test
	void testeAtualizarClienteInexistente(){
		Cliente cliente = new Cliente();
		cliente.setCpf("00066912365");
		cliente.setDataNascimento(new Date("01/01/1992"));
		cliente.setNome("Rafael Souza");
		RuntimeException exception = assertThrows(RuntimeException.class, () -> clienteService.atualizar(9999L, cliente));
		assertEquals("Id não encontrado.", exception.getMessage());
	}
	
}
