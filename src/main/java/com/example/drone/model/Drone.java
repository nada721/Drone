package com.example.drone.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "drones")
public class Drone {
	 @Id
	    private String serialNumber; // max 100 characters

	    private String model; // Lightweight, Middleweight, Cruiserweight, Heavyweight
	    private double weightLimit; // max 500 grams
	    private int batteryCapacity; // percentage

	    @Enumerated(EnumType.STRING)
	    private DroneState state; // IDLE, LOADING, LOADED, DELIVERING, DELIVERED, RETURNING

	    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    @JoinColumn(name = "drone_serial_number")
	    private List<Medication> loadedMedications = new ArrayList<>(); // medications loaded ont

		public String getSerialNumber() {
			return serialNumber;
		}

		public void setSerialNumber(String serialNumber) {
			this.serialNumber = serialNumber;
		}

		public String getModel() {
			return model;
		}

		public void setModel(String model) {
			this.model = model;
		}

		public double getWeightLimit() {
			return weightLimit;
		}

		public void setWeightLimit(double weightLimit) {
			this.weightLimit = weightLimit;
		}

		public int getBatteryCapacity() {
			return batteryCapacity;
		}

		public void setBatteryCapacity(int batteryCapacity) {
			this.batteryCapacity = batteryCapacity;
		}

		public DroneState getState() {
			return state;
		}

		public void setState(DroneState state) {
			this.state = state;
		}

		public List<Medication> getLoadedMedications() {
			return loadedMedications;
		}

		public void setLoadedMedications(List<Medication> loadedMedications) {
			this.loadedMedications = loadedMedications;
		}

		public void setState(String string) {
			// TODO Auto-generated method stub
			
		}

}
