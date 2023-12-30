package com.driver.model;


import javax.persistence.*;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    int numberOfHours;


    @ManyToOne(cascade = CascadeType.ALL)
    Spot spot;

    @OneToOne
    Payment payment;

    @ManyToOne(cascade = CascadeType.ALL)
    User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(int numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Reservation() {
    }

    public Reservation(int numberOfHours, Spot spot,User user) {
        this.numberOfHours = numberOfHours;
        this.spot = spot;
        this.user = user;
    }
}
