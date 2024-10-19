package br.example.iofood.web.controller;

import br.example.iofood.domain.exception.EntidadeEmUsoException;
import br.example.iofood.domain.exception.EntidadeNaoEncontradaException;
import br.example.iofood.domain.model.Cidade;
import br.example.iofood.domain.repository.CidadeRespository;
import br.example.iofood.domain.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeService service;
    @Autowired
    private CidadeRespository repository;

    @PostMapping
    public ResponseEntity<?> adicionar(@RequestBody Cidade cidade) {
        try {
            service.salvar(cidade);
            return ResponseEntity.status(HttpStatus.CREATED).body(cidade);
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping
    public List<Cidade> listar() {
        return repository.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        try {
            service.excluir(id);
            return ResponseEntity.noContent().build(); // 204 No Content, quando a exclusão é bem-sucedida
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build(); // 404 Not Found, quando o ID não é encontrado
        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build(); // 409 Conflict, quando a entidade está em uso
        }
    }
}
