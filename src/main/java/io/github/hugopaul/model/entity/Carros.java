package io.github.hugopaul.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Carros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String renavam;

    @Column(nullable = false, length = 150)
    private String modelo;

    @Column(nullable = false, length = 30)
    private String cor;

    @Column(nullable = false, length = 12)
    private String placa;

    @Column(nullable = false, length = 4)
    private Integer docAno;
}
