package io.github.hugopaul.pojo;

import io.github.hugopaul.model.entity.MotosEntity;
import io.github.hugopaul.model.entity.PessoasEntity;

import java.time.LocalDate;
import java.util.List;

public class Motos {private Integer id;

    private String renavam;

    private String modelo;

    private String cor;

    private String placa;

    private String docAno;

    private LocalDate dataCadastro;

    private List<PessoasEntity> pessoas;

    public Motos(){

    }
    public Motos(MotosEntity motosEntity) {
        this.id=motosEntity.getId();
        this.renavam=motosEntity.getRenavam();
        this.modelo=motosEntity.getModelo();
        this.cor=motosEntity.getCor();
        this.placa=motosEntity.getPlaca();
        this.docAno=motosEntity.getDocAno();
        this.dataCadastro=motosEntity.getDataCadastro();
        this.pessoas=motosEntity.getPessoas();
    }
    public MotosEntity toEntity(){
        MotosEntity entity = new MotosEntity();
        entity.setId(id);
        entity.setRenavam(renavam);
        entity.setModelo(modelo);
        entity.setCor(cor);
        entity.setPlaca(placa);
        entity.setDocAno(docAno);
        entity.setDataCadastro(dataCadastro);
        entity.setPessoas(pessoas);
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

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
