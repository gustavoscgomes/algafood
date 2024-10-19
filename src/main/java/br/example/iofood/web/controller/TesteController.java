package br.example.iofood.web.controller;

import static br.example.iofood.infrastructure.spec.RestauranteSpecs.*;
import br.example.iofood.domain.model.Cozinha;
import br.example.iofood.domain.model.Restaurante;
import br.example.iofood.domain.repository.CozinhaRepository;
import br.example.iofood.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/teste")
public class TesteController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

    @GetMapping("/cozinhas/nome")
    public List<Cozinha> cozinhasPorNome(String nome) {
        return cozinhaRepository.findByNomeContaining(nome);
    }

    @GetMapping("cozinhas/nome-comeca")
    public List<Cozinha> cozinhasNomeComecaCom(String nome) {
        return cozinhaRepository.findByNomeStartingWith(nome);
    }

    @GetMapping("restaurantes/por-taxafrete")
    public List<Restaurante> restaurantesPorTaxaFrete(BigDecimal taxaInicial, BigDecimal taxaFinal) {
        return restauranteRepository.findByTaxaFreteBetween(taxaInicial, taxaFinal);
    }

    @GetMapping("restaurantes/por-nome")
    public List<Restaurante> restaurantesPornome(String nome, Long id) {
        return restauranteRepository.consultaPorNome(nome, id);
    }

    @GetMapping("/restaurantes/por-nome-e-frete")
    public List<Restaurante> restaurantesPorNomeFrete(String nome,
                                                      BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {
        return restauranteRepository.find(nome, taxaFreteInicial, taxaFreteFinal);
    }

    @GetMapping("/restaurantes/com-frete-gratis")
    public List<Restaurante> restaurantesComFreteGratis(String nome) {

        return restauranteRepository.findAll(comFreteGratis().and(comNomeSemelhante(nome)));
    }
}
