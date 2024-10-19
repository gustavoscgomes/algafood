package br.example.iofood.domain.service;

import br.example.iofood.domain.exception.EntidadeEmUsoException;
import br.example.iofood.domain.exception.EntidadeNaoEncontradaException;
import br.example.iofood.domain.model.Cidade;
import br.example.iofood.domain.model.Estado;
import br.example.iofood.domain.repository.CidadeRespository;
import br.example.iofood.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRespository repository;

    @Autowired
    private EstadoRepository estadoRepository;

    public Cidade salvar(Cidade cidade) {
        Optional<Estado> estadoOptional = estadoRepository.findById(cidade.getEstado().getId());

        if (estadoOptional.isEmpty()) {
            throw new EntidadeNaoEncontradaException(String.format("Não existe cadastro de estado com código %d",
                    cidade.getEstado().getId()));
        }
        cidade.setEstado(estadoOptional.get());

        return repository.save(cidade);
    }

    public void excluir(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(String.format("Não existe um cadastro de cidade com código %d", id));
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format("Cidade de código %d não pode ser removida, pois está em uso", id));
        }
    }
}
