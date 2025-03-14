package br.example.iofood.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;
@Data
@EqualsAndHashCode
@Entity
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String nome;

    @ManyToOne
    private Estado estado;

}
