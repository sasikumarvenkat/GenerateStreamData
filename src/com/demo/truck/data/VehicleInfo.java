package com.demo.truck.data;

import com.google.gson.Gson;

public class VehicleInfo {

	private String vehicleId;
	private String vehicleType;
	private double sensor1;
	private double sensor2;
	private boolean sensor3;
	private int speed;
	private Location location;

	public VehicleInfo() {

	}

	public VehicleInfo(String vehicleId, String vehicleType, double sensor1, double sensor2, boolean sensor3, int speed,
			Location location) {
		this.vehicleId = vehicleId;
		this.vehicleType = vehicleType;
		this.sensor1 = sensor1;
		this.sensor2 = sensor2;
		this.sensor3 = sensor3;
		this.speed = speed;
		this.location = location;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public double getSensor1() {
		return sensor1;
	}

	public void setSensor1(double sensor1) {
		this.sensor1 = sensor1;
	}

	public double getSensor2() {
		return sensor2;
	}

	public void setSensor2(double sensor2) {
		this.sensor2 = sensor2;
	}

	public boolean isSensor3() {
		return sensor3;
	}

	public void setSensor3(boolean sensor3) {
		this.sensor3 = sensor3;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
}

class Location {
	private double lat;
	private double lon;

	public Location(double lat, double lon) {
		super();
		this.lat = lat;
		this.lon = lon;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	@Override
	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
}