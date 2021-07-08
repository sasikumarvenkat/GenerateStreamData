package com.demo.truck.data;

import static com.demo.truck.data.GenrateTruckInfo.generateBooleanData;
import static com.demo.truck.data.GenrateTruckInfo.generateRandomVehicleId;
import static com.demo.truck.data.GenrateTruckInfo.generateRandomVehicleType;
import static com.demo.truck.data.GenrateTruckInfo.generateSensorData;
import static com.demo.truck.data.GenrateTruckInfo.generateSpeed;
import static com.demo.truck.data.GenrateTruckInfo.randomLonLat;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Random;

public class GenreateRandomTruckInfoJson {

	public static void main(String[] args) throws InterruptedException, IOException {

		while (true) {
			File file = new File("/Users/s0v00eo/demo-workspace/GenerateStreamData/simulated-data/truck_info.json");
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
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
				// Write the vehicleInfo data into a file
				bw.append(vehicleInfo.toString() + "\n");
			}
			System.out.println("written " + records + " to the file. ");
			bw.flush();
			bw.close();
			Thread.sleep(300);
		}
	}
}
