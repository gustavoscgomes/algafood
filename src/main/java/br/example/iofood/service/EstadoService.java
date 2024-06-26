package br.example.iofood.service;

import br.example.iofood.domain.model.Estado;
import br.example.iofood.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {
    @Autowired
    private EstadoRepository repository;

    public List<Estado> listar() {
        return repository.findAll();
    }
}
