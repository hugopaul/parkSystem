package io.github.hugopaul.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Pessoas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(name = "nomedeguerra", nullable = false, length = 50)
    private String gNome;

    @Column(nullable = false, length = 14)
    private Integer idtMil;

    @Column(nullable = false, length = 150)
    private String secao;

    @Column(nullable = false, length = 20)
    private Integer telefone;

    @Column(nullable = false, length = 4)
    private Integer ramal;
    @ManyToOne
    @JoinColumn(name = "id_carros")
    private Carros carros;
    @ManyToOne
    @JoinColumn(name = "id_motos")
    private Motos motos;

}
