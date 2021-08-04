package com.example.demo.dao;

import java.util.UUID;
import java.util.*;
import com.example.demo.model.Persona;


public interface PersonaDao {

    int insertPersona(UUID id,Persona persona);


    //metodo default que crea uma id random dada una persona

    default int insertPersona(Persona persona){
        UUID id = UUID.randomUUID();
        return insertPersona(id, persona);
    }

    public List<Persona> selectPersonas();

    Optional<Persona> selectPersonaById(UUID id);

    public int deletePersona(UUID id);

    public int updatePersona(UUID id, Persona persona);
    
}
