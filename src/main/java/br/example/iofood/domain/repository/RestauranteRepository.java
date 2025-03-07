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

    // Errata: se um restaurante não tiver nenhuma forma de pagamento associada a ele,
    // esse restaurante não será retornado usando JOIN FETCH r.formasPagamento.
    // Para resolver isso, temos que usar LEFT JOIN FETCH r.formasPagamento
//	@Query("from Restaurante r join fetch r.cozinha join fetch r.formasPagamento")
    @Query("from Restaurante r join fetch r.cozinha left join fetch r.formasPagamento")
    List<Restaurante> findAll();

    List<Restaurante> findByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);

    @Query("from Restaurante where nome like %:nome% and cozinha.id =:id")
    List<Restaurante> consultaPorNome(String nome, @Param("id") Long cozinha);

}
