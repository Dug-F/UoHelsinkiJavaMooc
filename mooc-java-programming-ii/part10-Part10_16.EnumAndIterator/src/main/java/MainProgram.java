
public class MainProgram {

    public static void main(String[] args) {
        // test your classes here
        Employees university = new Employees();
        university.add(new Person("Petrus", Education.PHD));
        university.add(new Person("Arto", Education.HS));
        university.add(new Person("Elina", Education.PHD));

        university.print();

        university.fire(Education.HS);

        System.out.println("==");

        university.print();
        
//        Employees tt = new Employees();
//        Person person = new Person("Arto", education("PHD"));
//        Employees.add(tt, person, v);
//        print(tt, education("PHD"), v);
    }
}
