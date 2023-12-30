package com.driver.model;

import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.util.List;


@Entity
public class ParkingLot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String name;
    String address;

    @OneToMany(mappedBy = "ParkingLot")
    List<Spot> spotList;

    public ParkingLot(String name, String address) {
        this.name = name;
        this.address = address;
    }


    public ParkingLot() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Spot> getSpotList() {
        return spotList;
    }

    public void setSpotList(List<Spot> spotList) {
        this.spotList = spotList;
    }
}
