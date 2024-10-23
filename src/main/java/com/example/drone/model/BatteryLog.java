package com.example.drone.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "battery_logs")
public class BatteryLog {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "drone_serial_number", nullable = false)
    private Drone drone;

    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Drone getDrone() {
		return drone;
	}
	public void setDrone(Drone drone) {
		this.drone = drone;
	}
	public int getBatteryLevel() {
		return batteryLevel;
	}
	public void setBatteryLevel(int batteryLevel) {
		this.batteryLevel = batteryLevel;
	}
	public LocalDateTime getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(LocalDateTime checkTime) {
		this.checkTime = checkTime;
	}
	private int batteryLevel; // Battery percentage
    private LocalDateTime checkTime; // Time of the check

}
