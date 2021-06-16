package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("person")
public class PersonController {

    private final PersonService personService;
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public Person create(@RequestBody Person person) {
        return personService.insertPersonData(person);
    }

    @GetMapping
    public Collection<Person> read() {
        return personService.getAllPersonInformation();
    }

    @GetMapping(path = "{id}")
    public Optional<Person> readQueryUsingId(@PathVariable("id") String id) {
        return personService.getPersonInformationUsingId(id);
    }

    @SneakyThrows
    @PutMapping(path = "/update/{id}")
    @Transactional
    public void update(@PathVariable String id, @RequestBody Person person ) {
        personService.updatePersonUsingId(id, person);
        Thread.sleep(100000);
        if(true) throw new Exception("hello");
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable("id") String id){
        personService.deletePersonUsingId(id);
    }
}
