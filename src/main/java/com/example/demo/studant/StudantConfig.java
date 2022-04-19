package com.example.demo.studant;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudantConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudantRepository studantRepository){
         return args -> {
             Studant allan = new Studant("Allan","allanfd12@gmail.com", LocalDate.of(1999,9,30) );
             Studant gabi = new Studant("Gabriela","gamacarrerag@gmail.com", LocalDate.of(2001,7,18) );

             studantRepository.saveAll(
                     List.of(
                             allan,
                             gabi
                     )
             );
         };
    }
}
