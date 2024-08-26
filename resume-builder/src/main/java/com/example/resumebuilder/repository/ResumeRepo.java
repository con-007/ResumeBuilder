package com.example.resumebuilder.repository;

import com.example.resumebuilder.model.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResumeRepo extends JpaRepository<Resume, Long> {
    /** in case we prefer JPQL
    @Query("SELECT r FROM Resume r WHERE (r.firstName = :firstName AND r.lastName = :lastName) " +
            "OR r.firstName = :firstName OR r.lastName = :lastName")
    List<Resume> findByFirstNameOrLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);
     */
    List<Resume> findByFirstNameAndLastName(String firstName, String lastName);
    List<Resume> findByFirstName(String firstName);
    List<Resume> findByLastName(String lastName);
}
