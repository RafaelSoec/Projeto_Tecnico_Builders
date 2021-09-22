package com.projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.exception.ResponseException;
import com.projeto.model.entities.Cliente;
import com.projeto.repository.ClienteRepository;

@Service
public class ClienteService extends AbstractService<Cliente>{
	
	@Autowired
	private ClienteRepository repository;

	

	public Cliente salvar(Cliente associado){
		if(associado == null) {
			throw new ResponseException("Falha ao tentar salvar: Aluno nula.");
		}
		
		if(associado.getCpf() == null) {
			throw new ResponseException("CPF inválido.");
		}
		
		boolean cpfExiste = this.validarCpfDuplicado(associado.getCpf());
		if(cpfExiste) {
			throw new ResponseException("CPF já cadastrado.");
		}
		
		return super.salvar(associado);
	}
	
	//retorna true se o cpf do associado for duplicado
	public boolean validarCpfDuplicado(String cpf) {
		Cliente associado = this.repository.recuperarAlunoPorCpf(cpf);
		
		if(associado != null) {
			return true;
		}
		
		return false;
	}
	

	public Cliente recuperarAlunoPorCpf(String cpf) {
		return this.repository.recuperarAlunoPorCpf(cpf);
	}
}


