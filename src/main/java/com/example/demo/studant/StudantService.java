package com.example.demo.studant;

import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    public void addNewStudant(Studant studant) {
        Optional<Studant> studantByEmail = studantRepository.findStudentByEmail(studant.getEmail());

        if(studantByEmail.isPresent())
            throw new IllegalStateException("Email deve ser único");

        studantRepository.save(studant);
        System.out.println(studant);
    }
}
