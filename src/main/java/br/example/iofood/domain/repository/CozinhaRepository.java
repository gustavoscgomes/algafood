package br.example.iofood.domain.repository;

import br.example.iofood.domain.model.Cozinha;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {

    List<Cozinha> findByNomeContaining(String nome);

    List<Cozinha> findByNomeStartingWith(String nome);


}
