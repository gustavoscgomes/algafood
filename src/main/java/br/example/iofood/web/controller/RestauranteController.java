package br.example.iofood.web.controller;

import br.example.iofood.domain.exception.EntidadeNaoEncontradaException;
import br.example.iofood.domain.model.Restaurante;
import br.example.iofood.domain.service.RestauranteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteService service;

    @PostMapping
    public ResponseEntity<?> adicionar(@RequestBody Restaurante restaurante) {
        try {
            service.salvar(restaurante);
            return ResponseEntity.status(HttpStatus.CREATED).body(restaurante);
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @GetMapping
    public List<Restaurante> listar() {
        return service.listar();
    }

    @PutMapping("/{restauranteId}")
    public ResponseEntity<?> atualizar(@PathVariable Long restauranteId,
                                                 @RequestBody Restaurante restauranteAtualizado) {
        try {
            Restaurante restauranteAtual = service.buscarById(restauranteId);

            if (restauranteAtual != null) {
                BeanUtils.copyProperties(restauranteAtualizado, restauranteAtual, "id");

                restauranteAtual = service.salvar(restauranteAtual);
                return ResponseEntity.ok(restauranteAtual);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
    }
}
