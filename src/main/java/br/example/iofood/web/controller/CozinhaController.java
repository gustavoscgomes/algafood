package br.example.iofood.web.controller;

import br.example.iofood.domain.model.Cozinha;
import br.example.iofood.service.CozinhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {
    @Autowired
    private CozinhaService service;

    @GetMapping
    public List<Cozinha> listar() {
        return service.listar();
    }
    @GetMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> buscarById(@PathVariable Long cozinhaId) {
      Optional<Cozinha> cozinhaOptional = service.buscarById(cozinhaId);

      if (cozinhaOptional.isPresent()) {
          return ResponseEntity.ok(cozinhaOptional.get());
      } else {
          return ResponseEntity.notFound().build();
      }
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cozinha adicionar(@RequestBody Cozinha cozinha) {
        return service.salvar(cozinha);
    }

//    @PostMapping
//    public ResponseEntity<Cozinha> salvarCliente(@RequestBody Cozinha cozinha) {
//        Cozinha cozinhaSalvo = service.salvar(cozinha);
//        return ResponseEntity.status(HttpStatus.CREATED).body(cozinhaSalvo);
//    }
}
