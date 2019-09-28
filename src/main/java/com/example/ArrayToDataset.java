package com.example;

import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.api.java.function.ReduceFunction;
import org.apache.spark.sql.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayToDataset {

    public void start(){
        SparkSession ss = new SparkSession.Builder()
                .appName("Conversion between Dataset and Dataframe")
                .master("local")
                .getOrCreate();

        List<String> stringList = Arrays.asList("Banana", "Car","Computer", "Band", "Car", "Banana", "Mobile", "mobile", "Cat");
        Dataset<String> ds = ss.createDataset(stringList, Encoders.STRING());
//        ds.printSchema();
//        ds.show();
        Dataset<Row> ds2df = ds.toDF();
//        ds2df.printSchema();
//        ds2df.show();
        Dataset<Row> df = ds.groupBy("value").count();
//        df.printSchema();
//        df.show();
        Dataset<String> df2ds = ds2df.as(Encoders.STRING());
//        df2ds.printSchema();
//        df2ds.show();

        ds = ds.map(new MyMapperFunction(), Encoders.STRING());
        ds.show();

//        Dataset<Integer> ds1 = ds.map( (MapFunction<String, Integer>) row -> {
//            if(row.startsWith("B"))
//                return 1;
//            if(row.contains("C"))
//                return 2;
//            if(row.contains("M"))
//                return 3;
//            else
//                return 4;
//        }, Encoders.INT());
//        ds1.show();

        String reducedValue = ds.reduce(new MyReduceFunction());
        System.out.println("New Reduced value is : "  + reducedValue);

//        String reducedIntValue = ds.reduce( (row1, row2) -> {
//            Integer ans = 1;
//            if(row1.startsWith("B"))
//                ans*=row2.length();
//            if(row1.contains("C"))
//                ans*=5;
//            if(row1.contains("M"))
//                ans*=row2.length();
//            else
//                ans*=2;
//            return ans.toString();
//        });
//        System.out.println("New Reduced value is : "  + reducedIntValue);
    }

    static class MyMapperFunction implements MapFunction<String, String>, Serializable{

        @Override
        public String call(String s) throws Exception {
            return "word: "+s;
        }

    }

    static class MyReduceFunction implements ReduceFunction<String>, Serializable{

        @Override
        public String call(String s, String t1) throws Exception {
            return s+t1;
        }
    }
}
