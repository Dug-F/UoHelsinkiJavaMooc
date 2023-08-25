package FlightControl.ui;

import java.util.Scanner;
import FlightControl.logic.FlightControl;

public class UserInterface {
    private Scanner scanner;
    private FlightControl flightControl;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
        this.flightControl = new FlightControl();
    }
    
    public void start() {
        this.startAssetControl();
        System.out.println("");
        this.startFlightControl();

    }
    
    public void startAssetControl() {
        
        System.out.println("Airport Asset Control");
        System.out.println("--------------------");
        System.out.println();
        
        while(true) {
            System.out.println("Choose an action:");
            System.out.println("[1] Add an airplane");
            System.out.println("[2] Add a flight");
            System.out.println("[x] Exit Airport Asset Control");
            
            String command = this.scanner.nextLine();
            
            if (command.equals("x")) {
                break;
            }
            
            if (command.equals("1")) {
                this.addPlane();
            } else if (command.equals("2")) {
                this.addFlight();
            }
        }
    }
    
    public void startFlightControl() {
        
        System.out.println("Flight Control");
        System.out.println("------------");
        System.out.println();
        
        while(true) {
            System.out.println("Choose an action:");
            System.out.println("[1] Print airplanes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print airplane details");
            System.out.println("[x] Quit");
            
            String command = this.scanner.nextLine();
            
            if (command.equals("x")) {
                break;
            }
            
            if (command.equals("1")) {
                this.printPlanes();
            } else if (command.equals("2")) {
                this.printFlights();
            } else if (command.equals("3")) {
                this.printPlane();
            }
        }
    }
    
    public void addPlane() {
        System.out.println("Give the airplane id:");
        String ID = scanner.nextLine();
        System.out.println("Give the airplane capacity:");
        int capacity = Integer.valueOf(scanner.nextLine());
        
        this.flightControl.addPlane(ID, capacity);
    }
    
    public void addFlight() {
        System.out.println("Give the airplane id: ");
        String planeID = scanner.nextLine();
        System.out.println("Give the departure airport id: ");
        String departureID = scanner.nextLine();
        System.out.println("Give the target airport id: ");
        String destinationID = scanner.nextLine();
        
        this.flightControl.addFlight(planeID, departureID, destinationID);
    }
    
    public void printPlanes() {
        this.flightControl.printPlanes();
    }
    
    public void printFlights() {
        this.flightControl.printFlights();
    }
    
    public void printPlane() {
        System.out.println("Give the airplane id:");
        String planeID = scanner.nextLine();
        
        this.flightControl.printPlane(planeID);
    }

    
    
}


