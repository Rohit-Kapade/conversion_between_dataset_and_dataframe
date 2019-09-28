package com.example;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;


public class SparkAppMain {

    public static void main(String[] args) {

        Logger.getLogger("org").setLevel(Level.ERROR);

//        ArrayToDataset arr2data = new ArrayToDataset();
//        arr2data.start();

//        CarToDataset car2data = new CarToDataset();
//        car2data.start();

        HouseToDataset houseToDataset = new HouseToDataset();
        houseToDataset.start();

    }
}
