package br.com.postrabalho.postrabalhobibliotecaapi.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.postrabalho.postrabalhobibliotecaapi.model.Cliente;
import br.com.postrabalho.postrabalhobibliotecaapi.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService service;
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Cliente> cliente(
			@RequestBody @Valid Cliente cliente) {
		Cliente clienteCadastrado = this.service.inserir(cliente);
		
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(clienteCadastrado.getId())
				.toUri();
		
		return ResponseEntity.created(uri)
				.body(clienteCadastrado);
	}
	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> alterar(
			@RequestBody @Valid Cliente cliente, 
			@PathVariable("id") Long id) {
		
		cliente.setId(id);
		
		this.service.alterar(cliente);
	
		return ResponseEntity.ok(cliente);
	}
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> pesquisarPorId(
			@PathVariable("id") Long id) {
		
		Cliente cliente = this.service.pesquisarPorId(id);
		
		return ResponseEntity.ok(cliente);
	}
	@CrossOrigin
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> exlcuir(
			@PathVariable("id") Long id) {
		this.service.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Cliente>> listar() {
		List<Cliente> clientes = this.service.listar();
		return ResponseEntity.ok(clientes);
	}
}
