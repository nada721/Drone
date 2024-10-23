package com.example.drone.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.example.drone.model.Drone;
import com.example.drone.repository.DroneRepository;

@Component
public class BatteryCheckTask {
	private static final Logger logger = LoggerFactory.getLogger(BatteryCheckTask.class);
    private static final int LOW_BATTERY_THRESHOLD = 25; // Threshold for low battery warning

    private final DroneRepository droneRepository;

    public BatteryCheckTask(DroneRepository droneRepository) {
        this.droneRepository = droneRepository;
    }

    @Scheduled(fixedRate = 60000) // Check every 60 seconds
    public void checkBatteryLevels() {
        List<Drone> drones = droneRepository.findAll();

        for (Drone drone : drones) {
            int batteryLevel = drone.getBatteryCapacity();
            logger.info("Drone {} has battery level: {}%", drone.getSerialNumber(), batteryLevel);

            if (batteryLevel < LOW_BATTERY_THRESHOLD) {
                logger.warn("Drone {} has a low battery level: {}%. Consider charging!", drone.getSerialNumber(), batteryLevel);
            }
        }
    }
}
