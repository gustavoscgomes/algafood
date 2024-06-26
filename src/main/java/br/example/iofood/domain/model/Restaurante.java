package br.example.iofood.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.logging.Log;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


@Entity
@Getter
@Setter
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    @Column(name = "taxa_frete")
    private BigDecimal taxaFrete;
    @ManyToOne
    private Cozinha cozinha;

    private Boolean ativo;

    private Boolean aberto;
    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;
    @Column(name = "data_atualizacao")
    private LocalDate dataAtualizacao = LocalDate.now();
    @Embedded
    private Endereco endereco;
    @OneToMany
    private List<FormaPagamento> formasPagamento;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurante that = (Restaurante) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
