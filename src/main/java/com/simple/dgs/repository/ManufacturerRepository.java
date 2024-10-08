package com.simple.dgs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simple.dgs.model.Manufacturer;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
}
