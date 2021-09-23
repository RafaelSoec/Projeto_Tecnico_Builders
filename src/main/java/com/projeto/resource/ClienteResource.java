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
@RequestMapping(value="cliente")
public class ClienteResource {
	
	@Autowired
	private ClienteService service;
	

	@GetMapping
	@ApiOperation(value ="Busca todos os clientes.")
	public List<Cliente> buscarTodos() {
		return this.service.buscarTodos();
	}

	@GetMapping("buscarNome/{nome}")
	@ApiOperation(value ="Busca clientes por nome.")
	public List<Cliente> buscarClientesPorNome(@PathVariable String nome) {
		return this.service.recuperarClientePorNome(nome);
	}

	@GetMapping("buscarCpf/{cpf}")
	@ApiOperation(value ="Busca cliente por cpf.")
	public Cliente buscarClientesPorCpf(@PathVariable String cpf) {
		return this.service.recuperarClientePorCpf(cpf);
	}

	@GetMapping("/{id}")
	@ApiOperation(value ="Busca um cliente por id.")
	public Cliente buscarPorId(@PathVariable Long id) {
		return this.service.buscarPorId(id);
	}

	@PostMapping
	@ApiOperation(value ="Salva um cliente.")
	public Cliente salvar(@RequestBody Cliente cliente) {
		return this.service.salvar(cliente);
		
	}

	@PutMapping("/{id}")
	@ApiOperation(value ="Atualiza os dados de um cliente.")
	public Cliente atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
		return this.service.atualizar(id, cliente);
		
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value ="Exclui um cliente.")
	public void excluir(@PathVariable Long id) {
		 this.service.excluir(id);
	}
}
