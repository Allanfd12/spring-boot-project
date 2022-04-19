package com.example.demo.studant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudantRepository extends JpaRepository<Studant,Long> {

    @Query("SELECT s FROM Studant s WHERE s.email = ?1")
    Optional<Studant> findStudentByEmail(String email);
}
