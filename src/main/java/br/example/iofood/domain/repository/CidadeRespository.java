package br.example.iofood.domain.repository;

import br.example.iofood.domain.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRespository extends JpaRepository<Cidade, Long> {
}
