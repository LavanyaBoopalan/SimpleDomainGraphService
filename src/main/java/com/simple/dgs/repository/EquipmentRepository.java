package com.simple.dgs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simple.dgs.model.Equipment;


@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}
