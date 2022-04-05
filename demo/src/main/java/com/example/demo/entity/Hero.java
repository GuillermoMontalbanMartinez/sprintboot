package com.example.demo.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="heroes")
public class Hero {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @NotBlank(message="Name is mandatory")
    private String name;

    //@NotBlank(message="Poder is mandatory")
    @OneToMany(cascade= CascadeType.PERSIST)
    private Set<Poderes> poder;

    public Hero() { 
        this.name = "name";
        this.poder = new HashSet<Poderes>();
    }

    public Hero(String name, Set<Poderes> poder) {
        this.name = name;
        this.poder = new HashSet<Poderes>(poder);
    }

    public Hero(String name) {
        this.name = name;
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

    public Set<Poderes> getPoder() {
        return this.poder;
    }

    public void setPoder (ArrayList<Poderes> poder) {
        this.poder.addAll(poder);
    }

    @Override
    public String toString() {
        return "id=" + id + ", nombre" + this.name + ", poder=" + poder;
    }


}
