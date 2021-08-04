package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.dao.PersonaDao;
import com.example.demo.model.Persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service //convierte en un servicio  -CONTIENE LA LOGICA DEL NEGOCIO
public class PersonaServicio {
    
    private final PersonaDao personaDao;


    @Autowired //wirea a PersonaDao y cualifica con el mismo nombre que le fue dado al @Repository en FakePersonaDataAccessService
    public PersonaServicio(@Qualifier("fakedao") PersonaDao personaDao){
        this.personaDao = personaDao;
    }

    public int addPersona(Persona persona){
        return personaDao.insertPersona(persona);
    }

    public List<Persona> selectPersonas(){
        return personaDao.selectPersonas();
    }

    public Optional<Persona> selectPersonaById(UUID id) {
        return personaDao.selectPersonaById(id);
    }

    public int deletePersona(UUID id){
        return personaDao.deletePersona(id);
    }

    public int updatePersona(UUID id, Persona persona){
        return personaDao.updatePersona(id, persona);
    }

}
