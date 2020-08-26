package io.github.hugopaul.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Motos {
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
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    @PrePersist
    public void prePersist(){
        setDataCadastro(LocalDate.now());

    }

}
