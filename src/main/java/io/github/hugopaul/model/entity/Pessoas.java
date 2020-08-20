package io.github.hugopaul.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pessoas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(name = "guerra", nullable = false, length = 50)
    private String guerra;

    @Column(nullable = false, length = 14)
    private Integer idtMil;

    @Column(nullable = false, length = 150)
    private String secao;

    @Column(nullable = false, length = 20)
    private Integer telefone;

    @Column( length = 4)
    private Integer ramal;
    @ManyToOne
    @JoinColumn(name = "id_carros")
    private Carros carros;
    @ManyToOne
    @JoinColumn(name = "id_motos")
    private Motos motos;
    @Column(name= "data_cadastro", updatable = false)
    private LocalDate dataCadastro;

    @PrePersist
    public void prePersist(){
        setDataCadastro(LocalDate.now());

    }

}
