package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="poderes")
public class Poderes {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @NotBlank(message="Name is mandatory")
    private String name;

    @NotBlank(message="Tipo is mandatory")
    private String tipo;

    //@NotBlank(message = "Valor is mandatory")
    private int valor;

    public Poderes() {

    }

    public Poderes(String name, String tipo, int valor) {
        this.name = name;
        this.tipo = tipo;
        this.valor = valor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getValor() {
        return this.valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "id: " + this.id +", nombre del poder:  " + this.name + ", tipo:" + this.tipo + ", valor:" + this.tipo;
    }

}
