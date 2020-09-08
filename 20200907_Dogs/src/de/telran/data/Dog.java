package de.telran.data;

public class Dog {
    private String name;//мы закрыли все поля через private
    private int age;
    private String breed;
    private double weight;
    private String ownerName;
    private boolean dogStatus;

    public Dog(){};//это пустой конструктор

    public Dog (String name, int age){//это конструктор с инициализацией полей
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public boolean isDogStatus() {
        return dogStatus;
    }

    public void setDogStatus(boolean dogStatus) {
        this.dogStatus = dogStatus;
    }

/*
    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", breed='" + breed + '\'' +
                ", weight=" + weight +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }
*/

    @Override
    public String toString() {// мы можем задать вывод на печать в нужном нам виде
        return "Dog{" +
                name +
                ", age=" + age;
    }

    public void dogVoice(){
        System.out.println("gav-gav");
    }

    public static void someMethode(){//этот мтод никак не связан с созданием экземпляра класса,
        // поэтому мы можем вызвать его в приложении не создавая объект
        System.out.println("Hello!");
    }
}
