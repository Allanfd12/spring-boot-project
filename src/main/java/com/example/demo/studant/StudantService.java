package com.example.demo.studant;

import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
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

    public Studant getStudant(Long id){

        Optional<Studant> studant = studantRepository.findById(id);

        if(!studant.isPresent()){
            throw new IllegalStateException("Estudante com o ID : " + id + " não foi encontrado");
        }

        return studant.get();
    }

    public void addNewStudant(Studant studant) {
        Optional<Studant> studantByEmail = studantRepository.findStudentByEmail(studant.getEmail());

        if(studantByEmail.isPresent())
            throw new IllegalStateException("Email deve ser único");

        studantRepository.save(studant);
        System.out.println(studant);
    }

    public void deleteStudant(Long id) {
        if(!studantRepository.existsById(id)){
            throw new IllegalStateException("Estudante com o id "+id+" não encontrado");
        }
        studantRepository.deleteById(id);
    }

    @Transactional
    public void updateStudant(long id, String name, String email){
        Studant studant = studantRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("Estudante com o id "+id+" não encontrado")
        );


        if(name != null && name.length() >0 && !Objects.equals(studant.getName(),name )){
            studant.setName(name);
        }
        if(email != null && email.length() >0 && !Objects.equals(studant.getEmail(),email )){
            Optional<Studant> studantByEmail = studantRepository.findStudentByEmail(email);

            if(studantByEmail.isPresent())
                throw new IllegalStateException("Email deve ser único");

            studant.setEmail(email);
        }
    }
}
