package br.example.iofood.web.controller;

import br.example.iofood.domain.exception.EntidadeEmUsoException;
import br.example.iofood.domain.exception.EntidadeNaoEncontradaException;
import br.example.iofood.domain.model.Estado;
import br.example.iofood.domain.repository.EstadoRepository;
import br.example.iofood.domain.service.EstadoService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estados")
public class EstadoController {
    @Autowired
    private EstadoService service;
    @Autowired
    private EstadoRepository repository;
    @GetMapping
    public List<Estado> listar() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Estado adicionar(@RequestBody Estado estado) {
        return service.salvar(estado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Optional<Estado> estado = repository.findById(id);

        if (estado.isPresent()) {
            return ResponseEntity.ok(estado);
        }
        return ResponseEntity.notFound().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<Estado> atualizar(@PathVariable Long id,
                                            @RequestBody Estado estado) {
        Optional<Estado> estadoOptional = repository.findById(id);

        if (estadoOptional.isPresent()) {
            Estado estadoAtual = estadoOptional.get();

            BeanUtils.copyProperties(estado, estadoAtual, "id");

            estadoAtual = service.salvar(estadoAtual);
            return ResponseEntity.ok(estadoAtual);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) {
        try {
            service.excluir(id);
            return ResponseEntity.noContent().build();

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();

        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(e.getMessage());
        }
    }

}
