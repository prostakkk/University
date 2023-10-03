package study;

import java.util.ArrayList;
import java.util.List;

class Baggage {
    private double weight;
   // private String type = "Unsigned";
    private String type ;

    public Baggage(String type, double weight) {
        this.weight = weight;
        this.type = type;
    }

   public Baggage(String type) {
        this.type = type;
    }

   public Baggage(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

class Passenger {
    private String name;
    private Baggage baggage;

    public Passenger(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Baggage getBaggage() {
        return baggage;
    }

    public void setBaggage(Baggage baggage) {
        this.baggage = baggage;
    }

    public void addBaggage(double weight) {
        this.baggage = new Baggage(weight);
    }

    public void addBaggage(String type, double weight) {
        this.baggage = new Baggage(type, weight);
    }

    public String getBaggageInfo() {
        if (baggage == null) {
            return name + " has no baggage.";

        } else
            if (baggage.getType() == null) {
                return name + "`s baggage with " + baggage.getWeight() + " kg";
        }
            else
                return name + " has " +  baggage.getType() + " baggage with " + baggage.getWeight() + " kg";

    }
}

class Flight {
    private String flightNumber;
    private List<Passenger> passengers;

    public Flight(String flightNumber) {
        this.flightNumber = flightNumber;
        this.passengers = new ArrayList<>();
    }

    public void addPassenger(String name) {
        Passenger passenger = new Passenger(name);
        passengers.add(passenger);
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public void assignBaggageToPassenger(String passengerName,String type, double baggageWeight) {
        for (Passenger passenger : passengers) {
            if (passenger.getName().equals(passengerName)) {
                passenger.addBaggage(type, baggageWeight);
                break;
            }
        }
    }

    public void assignBaggageToPassenger(String passengerName,double baggageWeight) {
        for (Passenger passenger : passengers) {
            if (passenger.getName().equals(passengerName)) {
                passenger.addBaggage(baggageWeight);
                break;
            }
        }
    }

    public String getPassengerBaggageInfo(String passengerName) {
        for (Passenger passenger  : passengers) {
            if (passenger.getName().equals(passengerName)) {
                return passenger.getBaggageInfo();
            }
        }
        return "Passenger " + passengerName +  " not found.";
    }
}

public class Main {
    public static void main(String[] args) {
        Flight flight = new Flight("Київ - Львів");
        flight.addPassenger("Vitaliy");
        flight.addPassenger("Andrew");
        flight.addPassenger("Max");
        flight.addPassenger("Anna");
        flight.addPassenger("Diana");

        flight.assignBaggageToPassenger("Andrew", 20.0);
        flight.assignBaggageToPassenger("Max", 30.0);
        flight.assignBaggageToPassenger("Anna", 5.0);
        flight.assignBaggageToPassenger("Diana", 7);

        System.out.println(flight.getPassengerBaggageInfo("Vitaliy"));
        System.out.println(flight.getPassengerBaggageInfo("Andrew"));
        System.out.println(flight.getPassengerBaggageInfo("Anna"));
        System.out.println(flight.getPassengerBaggageInfo("Diana"));
        System.out.println(flight.getPassengerBaggageInfo("Max"));



        System.out.println(flight.getPassengerBaggageInfo("Anatoliy"));

        flight.assignBaggageToPassenger("Max", "hand luggage", 30.0);
        System.out.println(flight.getPassengerBaggageInfo("Max"));


    }
}
