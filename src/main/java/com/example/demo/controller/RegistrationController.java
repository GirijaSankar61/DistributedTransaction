package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.model.Vaccine;
import com.example.demo.service.PersonService;
import com.example.demo.service.VaccineService;
import lombok.SneakyThrows;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("registration")
public class RegistrationController
{

    private final VaccineService _vaccineService;
    private final PersonService  _personService;

    public RegistrationController(VaccineService _vaccineService, PersonService _personService)
    {
        this._vaccineService = _vaccineService;
        this._personService = _personService;
    }

    @GetMapping
    @Transactional("platformTransactionManager")
    public void doRegistration()
    {
        _personService.insertPersonData(new Person("1", "Hari"));
        if (true) { throw new RuntimeException("My Bad"); }
        _vaccineService.insertVaccineData(new Vaccine("COVIE-19", "COVAXINE", "10AM-11AM", 1));
    }

}
