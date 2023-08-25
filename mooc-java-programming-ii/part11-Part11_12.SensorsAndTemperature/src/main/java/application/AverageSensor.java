package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {
    private ArrayList<Sensor> sensors;
    private ArrayList<Integer> readings;

    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }
    
    public boolean isOn() {
        for (Sensor sensor : this.sensors) {
            if (!sensor.isOn()) {
                return false;
            }
        }
        return true;
    }
    
    public void setOff() {
        for (Sensor sensor : this.sensors) {
            sensor.setOff();
        }
    }
    
    public void setOn() {
        for (Sensor sensor : this.sensors) {
            sensor.setOn();
        }
    }
    
    public int read() {
        if (this.sensors.isEmpty() || !this.isOn()) {
            throw new IllegalStateException("No sensors have been added, or they are all off");
        }
        
        int sum = 0;
        for (Sensor sensor : this.sensors) {
            if (sensor.isOn()) {
                sum += sensor.read();
            }
        }
        int average = sum/this.sensors.size();
        this.readings.add(average);
        return average;
    }
    
    public void addSensor(Sensor toAdd) {
        this.sensors.add(toAdd);
    }
    
    public List<Integer> readings() {
        return this.readings;
    }
    
    
}
