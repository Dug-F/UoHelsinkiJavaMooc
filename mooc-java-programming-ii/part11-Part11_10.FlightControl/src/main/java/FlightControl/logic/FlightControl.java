package FlightControl.logic;

import java.util.HashMap;
import FlightControl.domain.Plane;
import FlightControl.domain.Flight;
import FlightControl.domain.Place;

public class FlightControl {
    private HashMap<String, Plane> planes;
    private HashMap<String, Flight> flights;
    private HashMap<String, Place> places;

    public FlightControl() {
        this.planes = new HashMap<>();
        this.flights = new HashMap<>();
        this.places = new HashMap<>();
    }
    
    public void addPlane(String ID, int capacity) {
        this.planes.put(ID, new Plane(ID, capacity));
    }
    
    public void addFlight(String planeID, String departureID, String destinationID) {
        this.places.putIfAbsent(departureID, new Place(departureID));
        this.places.putIfAbsent(destinationID, new Place(destinationID));
        
        Place departure = this.places.get(departureID);
        Place destination = this.places.get(destinationID);
        Plane plane = this.planes.get(planeID);
        
        Flight flight = new Flight(plane, departure, destination);
        
        this.flights.put(planeID + " " + departure + " " + destination, flight);
    }
    
    public void printPlanes() {
        for (Plane plane : this.planes.values()) {
            System.out.println(plane);
        }
    }
    
    public void printFlights() {
        for (Flight flight : this.flights.values()) {
            System.out.println(flight);
        }
    }
    
    public void printPlane(String planeID) {
        System.out.println(this.planes.get(planeID));
    }
}
