package com.example.travel_agency.service;


import com.example.travel_agency.model.Continent;
import com.example.travel_agency.model.Country;
import com.example.travel_agency.respositories.ContinentRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContinentService {

    ContinentRepository continentRepository;

    public ContinentService() {
    }

    @Transactional
    public void addContinent(Continent continent) {
        continentRepository.save(continent);
    }
    public void removeContinent(Continent continent) { continentRepository.delete(continent);}

    public List<Continent> getAll() {
        return continentRepository.findAll();
    }

    public Continent getContinent(Long id){
        return continentRepository.findById(id).orElse(null);
    }




}
