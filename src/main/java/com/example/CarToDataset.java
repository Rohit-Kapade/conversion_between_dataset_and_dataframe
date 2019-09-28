package com.example;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.SparkSession;

import java.util.Arrays;
import java.util.List;

public class CarToDataset {
    public void start(){

        SparkSession ss = new SparkSession.Builder()
                .master("local")
                .appName("Car to Dataset & Dataframe")
                .getOrCreate();

        Car c1 = new Car();
        Car c2 = new Car(200, "Black");
        Car c3 = new Car(300, "Blue");

        List<Car> carList = Arrays.asList(c1,c2, c3, new Car(300,"White"));
        Dataset<Car> carDs = ss.createDataset(carList, Encoders.bean(Car.class));

        carDs.show();

    }
}
