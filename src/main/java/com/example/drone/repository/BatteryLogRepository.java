package com.example.drone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.drone.model.BatteryLog;

@Repository
public interface BatteryLogRepository extends JpaRepository<BatteryLog, Long> {
    List<BatteryLog> findByDroneSerialNumber(String droneSerialNumber);

}
