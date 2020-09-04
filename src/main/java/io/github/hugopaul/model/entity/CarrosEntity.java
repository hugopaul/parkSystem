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
public class CarrosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    @NotEmpty(message = "O campo RENAVAM é obrigatório.")
    private String renavam;

    @Column(nullable = false, length = 150)
    @NotEmpty(message = "O campo MODELO é obrigatório")
    private String modelo;

    @Column(nullable = false, length = 30)
    @NotEmpty(message = "O campo COR é obrigatório.")
    private String cor;

    @Column(nullable = false, length = 12)
    @NotEmpty(message = "O campo PLACA é obrigatório.")
    private String placa;

    @Column(name = "doc_ano", nullable = false, length = 4)
    @NotEmpty(message = "O ANO DO DOCUMENTO é obrigatório.")
    private String docAno;

    @Column(name= "data_cadastro", updatable = false)
    private LocalDate dataCadastro;

    @ManyToOne
    @JoinColumn(name = "carros_pessoas")
    private PessoasEntity pessoas;


    @PrePersist
    public void prePersist(){
        setDataCadastro(LocalDate.now());
    }
}
