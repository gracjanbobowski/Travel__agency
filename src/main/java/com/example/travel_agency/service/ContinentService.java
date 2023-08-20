package com.example.travel_agency.service;


import com.example.travel_agency.model.Continent;
import com.example.travel_agency.model.Country;
import com.example.travel_agency.respositories.ContinentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContinentService {

    Continent continent;

    ContinentRepository continentRepository;

    @Transactional
    public void addContinent(Continent continent) {
        continentRepository.save(continent);
    }

    public void removeContinent(Continent continent) { continentRepository.delete(continent);}

    public Continent getContinentById(long id) {
        return continentRepository.findById(id).get();
    }

    public List<Continent> getAll() {
        return continentRepository.findAll();
    }




}
