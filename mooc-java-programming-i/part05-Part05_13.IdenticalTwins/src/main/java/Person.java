
import java.util.Objects;

public class Person {

    private String name;
    private SimpleDate birthday;
    private int height;
    private int weight;

    public Person(String name, SimpleDate birthday, int height, int weight) {
        this.name = name;
        this.birthday = birthday;
        this.height = height;
        this.weight = weight;
    }

    // implement an equals method here for checking the equality of objects
    public boolean equals(Object compare) {
        if (this == compare) {
            return true;
        }
        
        if (!(compare instanceof Person)) {
            return false;
        }
        
        Person comparePerson = (Person) compare;
        
        if (this.name.equals(comparePerson.name) &&
            this.birthday.equals(comparePerson.birthday) &&
            this.height == comparePerson.height &&
            this.weight == comparePerson.weight) {
            return true;
        }
        return false;
    }
}
