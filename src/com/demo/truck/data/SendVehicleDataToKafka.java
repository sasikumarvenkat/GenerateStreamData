package com.demo.truck.data;

import static com.demo.truck.data.GenrateTruckInfo.generateBooleanData;
import static com.demo.truck.data.GenrateTruckInfo.generateRandomVehicleId;
import static com.demo.truck.data.GenrateTruckInfo.generateRandomVehicleType;
import static com.demo.truck.data.GenrateTruckInfo.generateSensorData;
import static com.demo.truck.data.GenrateTruckInfo.generateSpeed;
import static com.demo.truck.data.GenrateTruckInfo.randomLonLat;

import java.util.Map;
import java.util.Random;

public class SendVehicleDataToKafka {

	public static void main(String[] args) throws InterruptedException {
		while (true) {
			int records = new Random().nextInt(15);
			for (int i = 1; i <= records; i++) {
				VehicleInfo vehicleInfo = new VehicleInfo();
				vehicleInfo.setVehicleId(generateRandomVehicleId());
				vehicleInfo.setVehicleType(generateRandomVehicleType());
				vehicleInfo.setSensor1(generateSensorData(12.99, 98.99));
				vehicleInfo.setSensor2(generateSensorData(-12, 12));
				vehicleInfo.setSensor3(generateBooleanData());
				vehicleInfo.setSpeed(generateSpeed(0, 200));
				Map<String, String> jw = randomLonLat(12, 15, 70, 80);
				vehicleInfo.setLocation(new Location(Double.parseDouble(jw.get("J")), Double.parseDouble(jw.get("W"))));
				SimpleKafkaProducer.sendDataToKafka(vehicleInfo.toString(), "truckInfo");
			}
			System.out.println("Written " + records + " to Kafka..");
			Thread.sleep(3000);
		}

	}

}
