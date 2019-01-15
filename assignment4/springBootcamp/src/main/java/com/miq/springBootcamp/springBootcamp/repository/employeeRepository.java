package com.miq.springBootcamp.springBootcamp.repository;

import com.miq.springBootcamp.springBootcamp.model.employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface employeeRepository extends JpaRepository<employee, Long> {
    public Optional<employee> findByEmail(String email);
}
