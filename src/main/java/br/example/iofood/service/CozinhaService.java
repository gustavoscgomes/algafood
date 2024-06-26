package br.example.iofood.service;

import br.example.iofood.domain.model.Cozinha;
import br.example.iofood.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CozinhaService {
    @Autowired
    private CozinhaRepository repository;

    public Cozinha salvar(Cozinha cozinha) {
        return repository.save(cozinha);
    }

    public List<Cozinha> listar() {
        return repository.findAll();
    }

    public Optional<Cozinha> buscarById(Long id) {
        return repository.findById(id);
    }
}
