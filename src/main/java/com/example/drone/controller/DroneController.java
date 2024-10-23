package com.example.drone.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.drone.model.Drone;
import com.example.drone.model.Medication;
import com.example.drone.service.DroneService;

@RestController
@RequestMapping("/drones")
public class DroneController {
	 private final DroneService droneService;

	    public DroneController(DroneService droneService) {
	        this.droneService = droneService;
	    }

	    @PostMapping
	    public ResponseEntity<Drone> registerDrone(@RequestBody Drone drone) {
	        Drone registeredDrone = droneService.registerDrone(drone);
	        return ResponseEntity.ok(registeredDrone);
	    }

	    @PostMapping("/{serialNumber}/load")
	    public ResponseEntity<Drone> loadDrone(@PathVariable String serialNumber, @RequestBody List<Medication> medications) {
	        Drone loadedDrone = droneService.loadDrone(serialNumber, medications);
	        return ResponseEntity.ok(loadedDrone);
	    }

	    @GetMapping("/{serialNumber}/medications")
	    public ResponseEntity<List<Medication>> getLoadedMedications(@PathVariable String serialNumber) {
	        List<Medication> medications = droneService.getLoadedMedications(serialNumber);
	        return ResponseEntity.ok(medications);
	    }

	    @GetMapping("/available")
	    public ResponseEntity<List<Drone>> getAvailableDrones() {
	        List<Drone> availableDrones = droneService.getAvailableDrones();
	        return ResponseEntity.ok(availableDrones);
	    }

	    @GetMapping("/{serialNumber}/battery")
	    public ResponseEntity<Integer> checkBatteryLevel(@PathVariable String serialNumber) {
	        int batteryLevel = droneService.checkBatteryLevel(serialNumber);
	        return ResponseEntity.ok(batteryLevel);
	    }
	}