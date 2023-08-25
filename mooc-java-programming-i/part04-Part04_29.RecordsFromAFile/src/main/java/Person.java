/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Doug
 */
public class Person {
    private String name;
    private int age;
    
    public Person (String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String toString() {
        return this.name + ", age: " + this.getAgeString();
        
    }
    
    public String getAgeString() {
        if (this.age == 1) {
            return this.age + " year";
        }
        return this.age + " years";
    }
}
