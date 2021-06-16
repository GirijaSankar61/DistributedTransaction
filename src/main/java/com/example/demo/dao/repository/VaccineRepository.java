package com.example.demo.dao.repository;

import com.example.demo.model.Vaccine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineRepository
    extends CrudRepository<Vaccine, String>
{

}
