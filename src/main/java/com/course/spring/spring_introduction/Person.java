package com.course.spring.spring_introduction;

import org.springframework.beans.factory.annotation.Value;

//@Component("personBean")
public class Person {

    //    @Autowired
//    @Qualifier("dog")
    private Pet pet;
    @Value("${person.surname}")
    private String surname;

    @Value("${person.age}")
    private int age;

//    @Autowired
//    public Person(@Qualifier("catBean") Pet pet) {
//        System.out.println("Person bean is created");
//        this.pet = pet;
//    }

    public Person(Pet pet) {
        System.out.println("Person bean is created");
        this.pet = pet;
    }

    public Person() {
        System.out.println("Person bean is created");
    }

    //pet -> setPet
//    @Autowired
//    @Qualifier("dog")
    public void setPet(Pet pet) {
        System.out.println("Class Person: set pet");
        this.pet = pet;
    }

    public String getSurname() {
        System.out.println("Class Person: set surename");
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        System.out.println("Class Person: set age");
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void callYourPet() {
        System.out.println("Hello my lovely Pet");
        pet.say();
    }
}
