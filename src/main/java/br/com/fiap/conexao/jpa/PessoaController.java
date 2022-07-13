package br.com.fiap.conexao.jpa;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.conexao.entity.Pessoa;
import br.com.fiap.conexao.repository.PessoaRepository;

@RestController
@RequestMapping(value = "/api/v0/pessoa")
public class PessoaController {

	@Autowired
	private PessoaRepository repo;

	@GetMapping
	public ResponseEntity<List<Pessoa>> findAll() {
		List<Pessoa> list = repo.findAll();
		return ResponseEntity.ok(list);
	}

	@PostMapping
	public ResponseEntity<Pessoa> save(@RequestBody Pessoa p) {
		Pessoa pessoa = repo.save(p);

		try {
			URI recurso = new URI("/api/v0/pessoa/" + pessoa.getId());
			return ResponseEntity.created(recurso).body(pessoa);
		} catch (URISyntaxException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}
}
