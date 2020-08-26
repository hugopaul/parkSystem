package io.github.hugopaul.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Carros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    @NotEmpty
    private String renavam;

    @Column(nullable = false, length = 150)
    private String modelo;

    @Column(nullable = false, length = 30)
    private String cor;

    @Column(nullable = false, length = 12)
    @NotEmpty
    private String placa;

    @Column(name = "doc_ano", nullable = false, length = 4)
    @NotEmpty
    private Integer docAno;

    @Column(name= "data_cadastro", updatable = false)
    private LocalDate dataCadastro;

    @PrePersist
    public void prePersist(){
        setDataCadastro(LocalDate.now());
    }
}
