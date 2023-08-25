package FlightControl.domain;

public class Flight {
    private Plane plane;
    private Place departure;
    private Place destination;

    public Flight(Plane plane, Place departure, Place destination) {
        this.plane = plane;
        this.departure = departure;
        this.destination = destination;
    }

    public Plane getPlane() {
        return plane;
    }

    public Place getDeparture() {
        return departure;
    }

    public Place getDestination() {
        return destination;
    }
    
    public String toString() {
        return this.plane.toString() + " (" + this.departure.toString() + "-" + this.destination.toString() + ")";
    }
    
    
}
