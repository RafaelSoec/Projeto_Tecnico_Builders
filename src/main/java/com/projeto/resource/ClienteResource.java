package com.projeto.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.model.entities.Cliente;
import com.projeto.service.ClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@Api(value = "API REST Aluno")
@RequestMapping(value="aluno")
public class ClienteResource {
	
	@Autowired
	private ClienteService service;
	

	@GetMapping
	@ApiOperation(value ="Busca todos os alunos.")
	public List<Cliente> buscarTodos() {
		return this.service.buscarTodos();
	}

	@GetMapping("/{id}")
	@ApiOperation(value ="Busca um aluno por id.")
	public Cliente buscarPorId(@PathVariable Long id) {
		return this.service.buscarPorId(id);
	}

	@PostMapping
	@ApiOperation(value ="Salva um aluno.")
	public Cliente salvar(@RequestBody Cliente aluno) {
		return this.service.salvar(aluno);
		
	}

	@PutMapping("/{id}")
	@ApiOperation(value ="Atualiza os dados de um aluno.")
	public Cliente atualizar(@PathVariable Long id, @RequestBody Cliente aluno) {
		return this.service.atualizar(id, aluno);
		
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value ="Exclui um aluno.")
	public void excluir(@PathVariable Long id) {
		 this.service.excluir(id);
	}
}
