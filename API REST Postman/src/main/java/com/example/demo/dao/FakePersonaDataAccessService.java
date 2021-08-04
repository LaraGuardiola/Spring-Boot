package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.model.Persona;

import org.springframework.stereotype.Repository;


@Repository("fakedao") //convierte el repositorio en un bean implementable en el resto
public class FakePersonaDataAccessService implements PersonaDao{

    private static List<Persona> DB = new ArrayList<>();

    @Override
    public int insertPersona(UUID id, Persona persona){
        DB.add(new Persona(id, persona.getName()));
        return 0;
    }

    @Override
    public List<Persona> selectPersonas() {
        return DB;
    }


    @Override
    public Optional<Persona> selectPersonaById(UUID id) {
        return DB.stream()
                .filter(persona -> persona.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePersona(UUID id) {
        Optional<Persona> personaQuizas = selectPersonaById(id);
        if(personaQuizas.isEmpty()){
            return 0;
        }
        DB.remove(personaQuizas.get());
        return 1;
    }

    @Override
    public int updatePersona(UUID id, Persona personaModificada) { //de la lista de personas mapeo para ver si hay alguna ocurrencia con la id enviada y hago la modificacion
        return selectPersonaById(id)
                .map(persona -> {
                    int indexPersonaABorrar = DB.indexOf(persona);
                    if (indexPersonaABorrar >= 0){
                        DB.set(indexPersonaABorrar, new Persona(id,personaModificada.getName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

   
}
