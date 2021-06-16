package com.example.demo.controller;

import com.example.demo.model.Vaccine;
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
@RequestMapping("vaccine")
public class VaccineController
{

    private final VaccineService _vaccineService;

    public VaccineController(VaccineService _vaccineService)
    {
        this._vaccineService = _vaccineService;
    }

    @PostMapping
    public Vaccine create(@RequestBody Vaccine vaccine)
    {
        return _vaccineService.insertVaccineData(vaccine);
    }

    @GetMapping
    public Iterable<Vaccine> read()
    {
        return _vaccineService.getAllVaccineInformation();
    }

    @GetMapping(path = "{id}")
    public Optional<Vaccine> readQueryUsingId(@PathVariable("id") String id)
    {
        return _vaccineService.getVaccineInformationUsingId(id);
    }

    @SneakyThrows
    @PutMapping(path = "/update/{id}")
    @Transactional
    public void update(@PathVariable String id, @RequestBody Vaccine vaccine)
    {
        _vaccineService.updateVaccineUsingId(id, vaccine);
        Thread.sleep(100000);
        if (true) { throw new Exception("hello"); }
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable("id") String id)
    {
        _vaccineService.deleteVaccineUsingId(id);
    }
}
