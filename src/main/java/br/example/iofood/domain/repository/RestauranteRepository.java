package br.example.iofood.domain.repository;

import br.example.iofood.domain.model.Cozinha;
import br.example.iofood.domain.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface RestauranteRepository extends CustomJpaRepository<Restaurante, Long>,
        RestauranteRepositoryImplQueries, JpaSpecificationExecutor<Restaurante> {

    List<Restaurante> findByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);

    @Query("from Restaurante where nome like %:nome% and cozinha.id =:id")
    List<Restaurante> consultaPorNome(String nome, @Param("id") Long cozinha);

}
