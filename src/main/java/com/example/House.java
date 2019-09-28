package com.example;


import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
//import java.time.format.DateTimeFormatter;

public class House {
    private Integer id;
    private String address;
    private Integer sqft;
    private Double price;
    //private LocalDateTime vacantBy;
    private Date vacantBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSqft() {
        return sqft;
    }

    public void setSqft(Integer sqft) {
        this.sqft = sqft;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getVacantBy() {
        return vacantBy;
    }

    public void setVacantBy(Date vacantBy) {
        this.vacantBy = vacantBy;
    }


//    public LocalDateTime getVacantBy() {
//        return vacantBy;
//    }

//    public void setVacantBy(String vacantBy) {
//        if (null != vacantBy) {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//            this.vacantBy = LocalDateTime.parse(vacantBy, formatter);
//        }
//        else{
//            this.vacantBy = LocalDateTime.now();
//        }
//    }

//    public void setVacantBy(Timestamp vacantBy) {
//        if( null != vacantBy ) {
//            //this.vacantBy = LocalDateTime.ofInstant(vacantBy.toInstant(), ZoneOffset.ofHours(0)); //new advance way
//            this.vacantBy = vacantBy.toLocalDateTime(); //depricated way
//
////            System.out.println("input argument: " + vacantBy );
////            System.out.println("Output argument: " + this.vacantBy );
//
//        }
//        else{
//            this.vacantBy = LocalDateTime.now();
//        }
//    }

}
