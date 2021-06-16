package com.example.demo.service;

import com.example.demo.dao.VaccineDao;
import com.example.demo.model.Vaccine;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VaccineService
{

    private final VaccineDao _vaccineDao;

    public VaccineService(VaccineDao vaccineDao)
    {
        this._vaccineDao = vaccineDao;
    }

    public Vaccine insertVaccineData(Vaccine vaccine)
    {
        return _vaccineDao.insertVaccineData(vaccine);
    }

    public Iterable<Vaccine> getAllVaccineInformation()
    {
        return _vaccineDao.getAllVaccineInformation();
    }

    public Optional<Vaccine> getVaccineInformationUsingId(String id)
    {
        return _vaccineDao.getVaccineInformationById(id);
    }

    public void updateVaccineUsingId(String id, Vaccine vaccine)
    {
        _vaccineDao.updateVaccineUsingId(id, vaccine);
    }

    public void deleteVaccineUsingId(String id)
    {
        _vaccineDao.deleteVaccineUsingId(id);
    }

}
