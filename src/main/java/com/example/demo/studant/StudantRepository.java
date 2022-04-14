package com.example.demo.studant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudantRepository extends JpaRepository<Studant,Long> {

}
