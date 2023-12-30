package com.driver.model;

import javax.persistence.*;
import java.util.List;


@Entity
public class Spot {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    SpotType spotType;
    int pricePerHour;
    Boolean occupied;

    @ManyToOne(cascade = CascadeType.ALL)
    ParkingLot parkingLot;

    @OneToMany(mappedBy = "spot")
    List<Reservation> reservationList;

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    public Spot() {
    }

    public Spot( SpotType spotType, int pricePerHour, Boolean occupied) {
        this.spotType = spotType;
        this.pricePerHour = pricePerHour;
        this.occupied = occupied;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }

    public int getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(int pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public Boolean getOccupied() {
        return occupied;
    }

    public void setOccupied(Boolean occupied) {
        this.occupied = occupied;
    }
}
