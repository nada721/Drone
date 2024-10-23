package com.example.drone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.drone.exception.DroneNotFoundException;
import com.example.drone.model.Drone;
import com.example.drone.model.DroneState;
import com.example.drone.model.Medication;
import com.example.drone.repository.DroneRepository;

import jakarta.transaction.Transactional;

@Service
public class DroneService {
	 private final DroneRepository droneRepository;

	    @Autowired
	    public DroneService(DroneRepository droneRepository) {
	        this.droneRepository = droneRepository;
	    }

	    public Drone registerDrone(Drone drone) {
	        return droneRepository.save(drone);
	    }

	    @Transactional
	    public Drone loadDrone(String serialNumber, List<Medication> medications) {
	        Drone drone = droneRepository.findBySerialNumber(serialNumber)
	                .orElseThrow(() -> new DroneNotFoundException("Drone not found: " + serialNumber));

	        int totalWeight = medications.stream().mapToInt(Medication::getWeight).sum();

	        if (totalWeight > drone.getWeightLimit()) {
	            throw new IllegalArgumentException("Total weight exceeds drone weight limit.");
	        }

	        if (drone.getBatteryCapacity() < 25) {
	            throw new IllegalStateException("Drone battery is too low for loading.");
	        }

	        drone.getLoadedMedications().addAll(medications);
	        drone.setState("LOADED");
	        return droneRepository.save(drone);
	    }

	    public List<Medication> getLoadedMedications(String serialNumber) {
	        Drone drone = droneRepository.findBySerialNumber(serialNumber)
	                .orElseThrow(() -> new DroneNotFoundException("Drone not found: " + serialNumber));
	        return drone.getLoadedMedications();
	    }

	    public List<Drone> getAvailableDrones() {
	        return droneRepository.findAll().stream()
	                .filter(drone -> "IDLE".equals(drone.getState()))
	                .toList();
	    }

	    public int checkBatteryLevel(String serialNumber) {
	        Drone drone = droneRepository.findBySerialNumber(serialNumber)
	                .orElseThrow(() -> new DroneNotFoundException("Drone not found: " + serialNumber));
	        return drone.getBatteryCapacity();
	    }
}