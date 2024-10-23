package com.example.drone.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.drone.model.Drone;

@Repository
public interface DroneRepository extends JpaRepository<Drone, String> {
	Optional<Drone> findBySerialNumber(String serialNumber);
}
