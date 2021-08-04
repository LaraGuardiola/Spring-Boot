package com.example.demo.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

//* CONTIENE EL MODELO DEL NEGOCIO

public class Persona {
    
    private final UUID id;
    private final String name;

//@JsonProperty es una anotacion que indica que el cliente enviara un json con esas propiedades
    public Persona(@JsonProperty("id") UUID id, 
                    @JsonProperty("name")String name) {
        this.id = id;
        this.name = name;
    }


    public UUID getId() {
        return this.id;
    }


    public String getName() {
        return this.name;
    }


}
