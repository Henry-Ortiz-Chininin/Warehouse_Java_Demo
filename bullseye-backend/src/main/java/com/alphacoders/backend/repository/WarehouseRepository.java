package com.alphacoders.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alphacoders.backend.model.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

}
