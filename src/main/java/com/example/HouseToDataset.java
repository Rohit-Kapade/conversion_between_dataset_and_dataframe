package com.example;

import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class HouseToDataset implements Serializable {
    public void start(){

        SparkSession ss = new SparkSession.Builder()
                .appName("Convert House to Dataset & Dataframe")
                .master("local")
                .getOrCreate();

        Dataset<Row> ds = ss.read().format("csv")
                .option("header", true)
                .option("inferSchema", true)
                .option("sep",";")
                .option("dateFormat", "yyyy-MM-dd")  //inferSchema true, Hence Date is understood as java.sql.Timestamp
                .load("src/main/resources/houses.csv");

        ds.printSchema();
        ds.show();

        Dataset<House> houseDs = ds.map( new MapFunction<Row, House>() {
            @Override
            public House call(Row row) throws Exception {
                House h = new House();
                h.setId(row.getAs("id"));
                h.setAddress(row.getAs("address"));
                h.setPrice(row.getAs("price"));
                h.setSqft(row.getAs("sqft"));
                h.setVacantBy(row.getAs("vacantBy"));
                return h;
            }
        }, Encoders.bean(House.class));

        houseDs.printSchema();
        houseDs.show(200,150);

        Dataset<Row> houseDf = houseDs.withColumn("VanancyDate",
                                    functions.concat( houseDs.col("vacantBy.year"), functions.lit("-"),
                                                      houseDs.col("vacantBy.month"), functions.lit("-"),
                                                      houseDs.col("vacantBy.date"))
                                                 );

        houseDf.show();

    }
}
