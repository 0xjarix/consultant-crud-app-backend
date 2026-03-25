package com.josephar.consultant_crud.repository;

import com.josephar.consultant_crud.model.Consultant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ConsultantRepository extends JpaRepository<Consultant, Long> {

    Optional<Consultant> findByEmail(String email);

    List<Consultant> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrExpertiseContainingIgnoreCase(
            String firstName,
            String lastName,
            String email,
            String expertise
    );
}
