package com.example.demo.studant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudantService {

    private final StudantRepository studantRepository;

    @Autowired
    public StudantService(StudantRepository studantRepository) {
        this.studantRepository = studantRepository;
    }

    public List<Studant> getStudants(){

        return studantRepository.findAll();
    }

}
