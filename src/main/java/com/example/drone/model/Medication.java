package com.example.drone.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "medications")
public class Medication {
	@Id
    private String code; // allowed uppercase letters, underscore, numbers
    private String name; // allowed letters, numbers, '-', '_'
    private int  weight;
    private String image;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int  getWeight() {
		return weight;
	}
	public void setWeight(int  weight) {
		this.weight = weight;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

}
