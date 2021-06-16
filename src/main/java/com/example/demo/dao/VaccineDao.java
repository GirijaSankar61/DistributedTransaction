package com.example.demo.dao;

import com.example.demo.dao.repository.VaccineRepository;
import com.example.demo.model.Vaccine;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class VaccineDao
{

    private final VaccineRepository _vaccineRepository;

    public VaccineDao(VaccineRepository _vaccineRepository)
    {
        this._vaccineRepository = _vaccineRepository;
    }

    public Vaccine insertVaccineData(Vaccine vaccine)
    {
        return _vaccineRepository.save(vaccine);
    }

    public Iterable<Vaccine> getAllVaccineInformation()
    {
        return _vaccineRepository.findAll();
    }

    public Optional<Vaccine> getVaccineInformationById(String id)
    {
        return _vaccineRepository.findById(id);
    }

    public Vaccine updateVaccineUsingId(String id, Vaccine vaccine1)
    {
        Optional<Vaccine> findPersonQuery = _vaccineRepository.findById(id);
        Vaccine vaccine = findPersonQuery.get();
        vaccine.setId(vaccine1.getId());
        vaccine.setName(vaccine1.getName());
        vaccine.setSlot(vaccine1.getSlot());
        vaccine.setDoseNo(vaccine1.getDoseNo());
        return _vaccineRepository.save(vaccine);
    }

    public void deleteVaccineUsingId(String id)
    {
        try
        {
            _vaccineRepository.deleteById(id);
        }
        catch (NoSuchElementException e)
        {
            e.printStackTrace();
        }
    }

}
