package io.github.hugopaul.pojo;

import io.github.hugopaul.model.entity.MotosEntity;

public class Motos {

    private Integer id;

    private String renavam;

    private String modelo;

    private String cor;

    private String placa;

    private String docAno;

    private Pessoas pessoas;

    public Motos(){

    }
    public Motos(MotosEntity motosEntity) {
        this.id=motosEntity.getId();
        this.renavam=motosEntity.getRenavam();
        this.modelo=motosEntity.getModelo();
        this.cor=motosEntity.getCor();
        this.placa=motosEntity.getPlaca();
        this.docAno=motosEntity.getDocAno();
        this.pessoas=new Pessoas(motosEntity.getPessoas());
    }
    public MotosEntity toEntity(){
        MotosEntity entity = new MotosEntity();
        entity.setId(id);
        entity.setRenavam(renavam);
        entity.setModelo(modelo);
        entity.setCor(cor);
        entity.setPlaca(placa);
        entity.setDocAno(docAno);
        entity.setPessoas(pessoas.toEntity());
        return entity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getDocAno() {
        return docAno;
    }

    public void setDocAno(String docAno) {
        this.docAno = docAno;
    }

    public Pessoas getPessoas() {
        return pessoas;
    }

    public void setPessoas(Pessoas pessoas) {
        this.pessoas = pessoas;
    }
}
