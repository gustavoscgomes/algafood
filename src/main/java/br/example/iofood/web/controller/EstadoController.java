package br.example.iofood.web.controller;

import br.example.iofood.domain.model.Cozinha;
import br.example.iofood.domain.model.Estado;
import br.example.iofood.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {
    @Autowired
    private EstadoService service;

    @GetMapping
    public List<Estado> listar() {
        return service.listar();
    }
}
