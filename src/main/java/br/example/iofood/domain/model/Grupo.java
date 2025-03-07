package br.example.iofood.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode
@Entity
public class Grupo {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @ManyToMany
    @JoinTable(
            name = "grupo_permissao", // Nome da tabela de junção
            joinColumns = @JoinColumn(name = "grupo_id"), // Coluna desta entidade
            inverseJoinColumns = @JoinColumn(name = "permissao_id") // Coluna da outra entidade
    )
    private List<Permissao> permissoes = new ArrayList<>();
}
