package com.alphacoders.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alphacoders.backend.model.Movement;

public interface MovementRepository extends JpaRepository<Movement, Long> {

}
