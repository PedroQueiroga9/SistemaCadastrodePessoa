package com.example.Pessoa.service;

import com.example.Pessoa.model.Pessoa;
import com.example.Pessoa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public Pessoa salvar(Pessoa pessoa) {
        return repository.save(pessoa);
    }

    public List<Pessoa> listar() {
        return repository.findAll();
    }

    public Optional<Pessoa> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Pessoa atualizar(Long id, Pessoa pessoaAtualizada) {
        if (repository.existsById(id)) {
            pessoaAtualizada.setId(id);
            return repository.save(pessoaAtualizada);
        }
        return null;
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
