package com.demo.truck.data;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class GenrateTruckInfo {

	public static void main(String[] args) {
		for (int i = 1; i <= 5; i++) {

			System.out.println("VechileId:" + generateRandomVehicleId());

			System.out.println("VechileType:" + generateRandomVehicleType());

			System.out.println("Sensor 1:" + generateSensorData(12.99, 98.99));

			System.out.println("Sensor 2:" + generateSensorData(-12, 12));

			System.out.println("Sensor 3:" + generateBooleanData());

			System.out.println("SpeedinKmsph :" + generateSpeed(0, 200));

			Map<String, String> jw = randomLonLat(12, 15, 70, 80);
			System.out.println("Location :" + jw.get("J") + "," + jw.get("W"));

			System.out.println("----------------------------");

		}
	}

	public static int generateSpeed(int min, int max) {
		return new Random().nextInt(max);
	}

	public static boolean generateBooleanData() {
		return new Random().nextBoolean();
	}

	/**
	 * @Description: Randomly generate latitude and longitude within a rectangle
	 * @param MinLon: minimum longitude MaxLon: maximum longitude MinLat: minimum
	 *                latitude MaxLat: maximum latitude
	 * @return @throws
	 */
	public static Map<String, String> randomLonLat(double MinLon, double MaxLon, double MinLat, double MaxLat) {
		BigDecimal db = new BigDecimal(Math.random() * (MaxLon - MinLon) + MinLon);
		String lon = db.setScale(6, BigDecimal.ROUND_HALF_UP).toString();// 6 digits after the decimal
		db = new BigDecimal(Math.random() * (MaxLat - MinLat) + MinLat);
		String lat = db.setScale(6, BigDecimal.ROUND_HALF_UP).toString();
		Map<String, String> map = new HashMap<String, String>();
		map.put("J", lon);
		map.put("W", lat);
		return map;
	}

	public static String generateRandomVehicleId() {
		return UUID.randomUUID().toString();
	}

	public static String generateRandomVehicleType() {
		String[] vehicleTypeArray = { "Car", "Truck", "Bus", "Mini-Van", "Auto" };
		return vehicleTypeArray[new Random().nextInt(vehicleTypeArray.length)];
	}

	public static double generateSensorData(double min, double max) {
		return Math.random() * (max - min) + min;
	}

}