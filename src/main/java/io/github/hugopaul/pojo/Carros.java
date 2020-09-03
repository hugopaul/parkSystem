package io.github.hugopaul.pojo;

import io.github.hugopaul.model.entity.CarrosEntity;
import io.github.hugopaul.model.entity.PessoasEntity;

import java.time.LocalDate;
import java.util.List;

public class Carros {
    private Integer id;

    private String renavam;

    private String modelo;

    private String cor;

    private String placa;

    private String docAno;

    private LocalDate dataCadastro;

    private List<PessoasEntity> pessoas;

    public Carros(){

    }
    public Carros(CarrosEntity carrosEntity) {
        this.id=carrosEntity.getId();
        this.renavam=carrosEntity.getRenavam();
        this.modelo=carrosEntity.getModelo();
        this.cor=carrosEntity.getCor();
        this.placa=carrosEntity.getPlaca();
        this.docAno=carrosEntity.getDocAno();
        this.dataCadastro=carrosEntity.getDataCadastro();
        this.pessoas=carrosEntity.getPessoas();
    }
    public CarrosEntity toEntity(){
        CarrosEntity entity = new CarrosEntity();
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
