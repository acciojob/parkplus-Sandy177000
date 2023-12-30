package com.driver.services.impl;

import com.driver.model.*;
import com.driver.repository.ParkingLotRepository;
import com.driver.repository.ReservationRepository;
import com.driver.repository.SpotRepository;
import com.driver.repository.UserRepository;
import com.driver.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    UserRepository userRepository3;
    @Autowired
    SpotRepository spotRepository3;
    @Autowired
    ReservationRepository reservationRepository3;
    @Autowired
    ParkingLotRepository parkingLotRepository3;
    @Override
    public Reservation reserveSpot(Integer userId, Integer parkingLotId, Integer timeInHours, Integer numberOfWheels) throws Exception {

        User user = userRepository3.findById(userId).get();
        ParkingLot parkingLot = parkingLotRepository3.findById(parkingLotId).get();
        List<Spot> spotList = parkingLot.getSpotList();
        Collections.sort(spotList,(a,b)->a.getPricePerHour()-b.getPricePerHour());
        Spot registerSpot = null;
        for (Spot spot: spotList) {
            if(!spot.getOccupied())
            {
                SpotType spotType = spot.getSpotType();
                int wheels = Integer.MAX_VALUE;
                if (spotType.equals(SpotType.TWO_WHEELER)) {
                    wheels = 2;
                } else if (spotType.equals(SpotType.FOUR_WHEELER)) {
                    wheels = 4;
                }
                if (numberOfWheels <= wheels) {
                    registerSpot = spot;
                    spot.setOccupied(true);
                    break;
                }
            }
        }
        if(registerSpot==null){
            throw new Exception("Cannot make reservation");
        }

        Reservation reservation = new Reservation(timeInHours, registerSpot,user);

        reservationRepository3.save(reservation);

        return reservation;

    }

    //Reserve a spot in the given parkingLot such that the total price is minimum.
    // Note that the price per hour for each spot is different
    //Note that the vehicle can only be parked in a spot having a type equal to or larger than given vehicle
    //If parkingLot is not found, user is not found, or no spot is available, throw "Cannot make reservation" exception.

}
