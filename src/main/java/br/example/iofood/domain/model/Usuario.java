package br.example.iofood.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    @JsonIgnore
    @CreationTimestamp // Criação automatica da data de cadastro
    @Column(nullable = false, columnDefinition = "datetime")
    private LocalDateTime dataCadastro;

    @ManyToMany
    @JoinTable(
            name = "usuario_grupo", // Nome da tabela de junção
            joinColumns = @JoinColumn(name = "usuario_id"), // Coluna desta entidade
            inverseJoinColumns = @JoinColumn(name = "grupo_id") // Coluna da outra entidade
    )
    private List<Grupo> grupos = new ArrayList<>();

}
