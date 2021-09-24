package com.frankmoley.lil.designpatternsapp.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PresidentRepository extends CrudRepository<PresidentEntity, Long> {
    Optional<PresidentEntity> findPresidentEntityByEmailAddress(String emailAddress);
}
