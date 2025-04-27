package br.example.iofood.domain.service;

import br.example.iofood.domain.exception.EntidadeNaoEncontradaException;
import br.example.iofood.domain.exception.RestauranteNaoEncontradoException;
import br.example.iofood.domain.model.Cozinha;
import br.example.iofood.domain.model.Restaurante;
import br.example.iofood.domain.repository.CozinhaRepository;
import br.example.iofood.domain.repository.RestauranteRepository;
import br.example.iofood.web.controller.CozinhaController;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CozinhaService cozinhaService;

    public Restaurante salvar(Restaurante restaurante) {
        Long cozinhaId = restaurante.getCozinha().getId();

        Cozinha cozinha = cozinhaService.buscarOuFlhar(cozinhaId);

        restaurante.setCozinha(cozinha);

        return restauranteRepository.save(restaurante);
    }

    public Restaurante buscarOuFalhar(Long restauranteId) {
        return restauranteRepository.findById(restauranteId)
                .orElseThrow(()
                        -> new RestauranteNaoEncontradoException(restauranteId));
    }
}
