package com.example.demo;

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

    @OneToMany(cascade= CascadeType.PERSIST)
    private Set<Poderes> poder;

    public Hero() { 

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

    public @NotBlank(message = "Poder is mandatory") Set<Poderes> getPoder() {
        return this.poder;
    }

    public void setPoder(@NotBlank(message = "Poder is mandatory") Set<Poderes> poder) {
        this.poder = poder;
    }

    @Override
    public String toString() {
        return "id=" + id + ", nombre" + this.name + ", poder=" + poder;
    }

}
