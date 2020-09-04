package io.github.hugopaul.pojo;

import io.github.hugopaul.model.entity.PessoasEntity;


public class Pessoas {
    private Integer id;

    private String nome;

    private String guerra;

    private String idtMil;

    private String secao;

    private String telefone;

    private Integer ramal;

    public Pessoas(){

    }
    public Pessoas (PessoasEntity pessoasEntity){
        this.id = pessoasEntity.getId();
        this.nome = pessoasEntity.getNome();
        this.guerra = pessoasEntity.getGuerra();
        this.idtMil = pessoasEntity.getIdtMil();
        this.secao = pessoasEntity.getSecao();
        this.telefone = pessoasEntity.getTelefone();
        this.ramal = pessoasEntity.getRamal();

    }
    public PessoasEntity toEntity(){
        PessoasEntity entity = new PessoasEntity();
        entity.setId(id);
        entity.setNome(nome);
        entity.setGuerra(guerra);
        entity.setIdtMil(idtMil);
        entity.setSecao(secao);
        entity.setTelefone(telefone);
        entity.setRamal(ramal);
        return entity;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGuerra() {
        return guerra;
    }

    public void setGuerra(String guerra) {
        this.guerra = guerra;
    }

    public String getIdtMil() {
        return idtMil;
    }

    public void setIdtMil(String idtMil) {
        this.idtMil = idtMil;
    }

    public String getSecao() {
        return secao;
    }

    public void setSecao(String secao) {
        this.secao = secao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getRamal() {
        return ramal;
    }

    public void setRamal(Integer ramal) {
        this.ramal = ramal;
    }

}
