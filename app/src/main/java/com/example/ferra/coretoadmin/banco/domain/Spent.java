package com.example.ferra.coretoadmin.banco.domain;

/**
 * Created by ferrari on 12/05/2017.
 */

public class Spent {
    private long id;
    private String data;
    private String categoria;
    private String descricao;
    private Float valor;
    private String latitude;
    private String longitude;
    private Integer gastoId;
    private String location;


    public Spent(long id, String data, String categoria, String descricao,
                 Float valor, String latitude,String  longitude , String mlocation, Integer gastoId) {
        this.id = id;
        this.data = data;
        this.categoria = categoria;
        this.descricao = descricao;
        this.valor = valor;
        this.latitude = latitude;
        this.gastoId = gastoId;
        this.longitude = longitude;
        this.location = mlocation;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getLatitude() {
        return latitude;
    }

    public void getlatitude(String local) {
        this.latitude = local;
    }

    public Integer getGastoId() {
        return gastoId;
    }

    public void setGastoId(Integer gastoId) {
        this.gastoId = gastoId;
    }
    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
