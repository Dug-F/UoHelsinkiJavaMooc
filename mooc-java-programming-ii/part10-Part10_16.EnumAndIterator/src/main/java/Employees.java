import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Employees {
    private ArrayList<Person> employees;

    public Employees() {
        this.employees = new ArrayList<>();
    }
    
    public void add(Person personToAdd) {
        employees.add(personToAdd);
    }
    
    public void add(List<Person> peopleToAdd) {
        peopleToAdd.stream()
                .forEach(s -> employees.add(s));
    }
    
    public void print() {
        this.employees.stream()
                .forEach(s -> System.out.println(s));
    }
    
    public void print(Education education) {
        Iterator<Person> iterator = this.employees.iterator();
        while(iterator.hasNext()) {
            Person employee = iterator.next();
            if (employee.getEducation() == education) {
                System.out.println(employee);
            }
        }
    }
    
    public void fire(Education education) {
        Iterator<Person> iterator = this.employees.iterator();
        
        while(iterator.hasNext()) {
            Person employee = iterator.next();
            
            if (employee.getEducation() == education) {
                iterator.remove();
            }
        }
    }
}
