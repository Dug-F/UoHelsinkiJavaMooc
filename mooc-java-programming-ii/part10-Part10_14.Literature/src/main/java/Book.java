public class Book {
    private String name;
    private int age;

    public Book(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
    
    public String toString() {
        return this.name + " (recommended for " + this.age + " year olds or older)";
    }
}
