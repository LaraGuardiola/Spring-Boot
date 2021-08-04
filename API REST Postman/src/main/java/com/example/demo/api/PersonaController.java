package com.example.demo.api;

import java.util.List;
import java.util.UUID;

import com.example.demo.model.Persona;
import com.example.demo.service.PersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//* EL CONTROLADOR ES EL QUE ESTA EXPUESTO A LA API REST

@RequestMapping("api/v1/persona")
@RestController //*RestController class que nos da acceso a algunos métodos
public class PersonaController {

    private final PersonaServicio personaServicio;

    @Autowired //*se vuelve a wirear con el servicio, aun no se bien porque
    public PersonaController(PersonaServicio personaServicio){
        this.personaServicio = personaServicio;
    }

    //*AÑADE UNA PERSONA

    @PostMapping //* Marca que va a ser una peticion POST
    public void addPersona(@RequestBody Persona persona){ //@RequestBody acepta la peticion del cliente postman definida en el body (convertir el json de postman en una persona)
        personaServicio.addPersona(persona);
    }

    //*OBTENER TODAS LAS PERSONAS

    @GetMapping //*Anotacion que va a ser una request GET
    public List<Persona> getAllPersonas(){
        return personaServicio.selectPersonas();
    }

    //*OBTENER PERSONA POR ID 

    @GetMapping(path ="{id}")  //mapea una peticion get añadiendo el path con la id
    public Persona getPersonaById(@PathVariable("id") UUID id){
        return personaServicio.selectPersonaById(id)
        .orElse(null);
    }

    //*ELIMINA UNA PERSONA POR ID

    @DeleteMapping(path ="{id}")
    public int deletePersona(@PathVariable("id") UUID id){
        return personaServicio.deletePersona(id);
    }

    //*MODIFICA UNA PERSONA POR ID

    @PutMapping(path ="{id}")
    public int updatePersona(@PathVariable("id") UUID id, @RequestBody Persona personaAModificar){
        return personaServicio.updatePersona(id,personaAModificar);
    }
    

}

//?PETICIONES GET, POST, PUT , DELETE
//? =================================================================

//*GET - RETRIEVE DATA FROM YOUR SERVER - recupera datos del servidor

//*POST - ADD RESOURCES TO YOUR SERVER - añade recursos a tu servidor

//*PUT - MODIFYING - modifica recursos

//*DELETE - elimina recursos

//? ==================================================================