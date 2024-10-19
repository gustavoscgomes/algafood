package br.example.iofood.domain.service;

import br.example.iofood.domain.exception.EntidadeEmUsoException;
import br.example.iofood.domain.exception.EntidadeNaoEncontradaException;
import br.example.iofood.domain.model.Cozinha;
import br.example.iofood.domain.repository.CozinhaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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


    public void remover(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(String.format("Não existe cadastro de cozinha com código %d", id));

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(String.format("Cozinha de código %d não pode ser removido, pois está em uso", id));

        }
    }

}

