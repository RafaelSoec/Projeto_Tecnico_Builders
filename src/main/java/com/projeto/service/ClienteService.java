package com.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.projeto.exception.ResponseException;
import com.projeto.model.entities.Cliente;
import com.projeto.repository.ClienteRepository;

@Service
public class ClienteService extends AbstractService<Cliente>{
	
	@Autowired
	private ClienteRepository repository;


	//Por padrão a busca por clientes realiza uma paginação de 10 elementos por vez
	public List<Cliente> buscarTodos() {
		int page = 10, size = 10;
        PageRequest pageRequest = PageRequest.of(page, size,  Sort.Direction.ASC, "nome");
        Page<Cliente> clientes = new PageImpl<>(this.repository.findAll(), pageRequest, size);
        
       return clientes.toList();
	}
	
	public List<Cliente> buscarTodos(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size,  Sort.Direction.ASC, "nome");
        Page<Cliente> clientes = new PageImpl<>(this.repository.findAll(), pageRequest, size);
        
       return clientes.toList();
	}

	public Cliente atualizar(Long id, Cliente cliente){
		this.validarDadosCliente(cliente);
		return super.atualizar(id, cliente);
	}

	public Cliente salvar(Cliente cliente){
		this.validarDadosCliente(cliente);
		boolean cpfExiste = this.validarCpfDuplicado(cliente.getCpf());
		if(cpfExiste) {
			throw new ResponseException("CPF já cadastrado.");
		}
		
		return super.salvar(cliente);
	}
	
	//retorna true se o cpf do cliente for duplicado
	public boolean validarCpfDuplicado(String cpf) {
		Cliente cliente = this.repository.recuperarClientePorCpf(cpf);
		
		if(cliente != null) {
			return true;
		}
		
		return false;
	}
	
	public void validarDadosCliente(Cliente cliente) {
		if(cliente == null) {
			throw new ResponseException("Cliente não informado.");
		}
		if(cliente.getNome() == null) {
			throw new ResponseException("Nome não informado.");
		}
		
		if(cliente.getDataNascimento() == null) {
			throw new ResponseException("Data de nascimento não informada.");
		}
		
		if(cliente.getCpf() == null) {
			throw new ResponseException("CPF não informado.");
		}
	}

	public Cliente recuperarClientePorCpf(String cpf) {
		return this.repository.recuperarClientePorCpf(cpf);
	}

	public List<Cliente> recuperarClientePorNome(String nome) {
		return this.repository.recuperarClientePorNome(nome);
	}
}


