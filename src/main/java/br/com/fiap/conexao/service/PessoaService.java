package br.com.fiap.conexao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.conexao.entity.Pessoa;
import br.com.fiap.conexao.repository.PessoaRepository;

@Service
public class PessoaService {
	@Autowired
	private PessoaRepository repo;

	public List<Pessoa> fidAll() {
		return repo.findAll();
	}

	public void save(Pessoa p) {
		repo.save(p);
	}
}
