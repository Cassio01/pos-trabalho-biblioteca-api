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

import br.com.postrabalho.postrabalhobibliotecaapi.model.Editora;
import br.com.postrabalho.postrabalhobibliotecaapi.service.EditoraService;

@RestController
@RequestMapping("/editoras")
public class EditoraResource {

	@Autowired
	private EditoraService service;
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Editora> editora(
			@RequestBody @Valid Editora editora) {
		Editora editoraCadastrada = this.service.inserir(editora);
		
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(editoraCadastrada.getId())
				.toUri();
		
		return ResponseEntity.created(uri)
				.body(editoraCadastrada);
	}
	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<Editora> alterar(
			@RequestBody @Valid Editora editora, 
			@PathVariable("id") Long id) {
		
		editora.setId(id);
		
		this.service.alterar(editora);
	
		return ResponseEntity.ok(editora);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Editora> pesquisarPorId(
			@PathVariable("id") Long id) {
		
		Editora editora = this.service.pesquisarPorId(id);
		
		return ResponseEntity.ok(editora);
	}
	@CrossOrigin
	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<Void> exlcuir(
			@PathVariable("id") Long id) {
		this.service.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Editora>> listar() {
		List<Editora> editoras = this.service.listar();
		return ResponseEntity.ok(editoras);
	}
}
