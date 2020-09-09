package de.telran.application;

import de.telran.data.Dog;

public class DogApplication {
    public static void main(String[] args) {
        Dog dog = new Dog();
/*        dog.name = "Bobik";
        dog.age = 5;
        System.out.println(dog.name);
        System.out.println(dog.weight);*/
        System.out.println(dog);//распечатается ссылка на место в памяти, где хранится объект - тут всё пусто

        Dog dog1 = new Dog("Sharik", 3);
/*        System.out.println(dog1.name);

        dog1.name = "Tusik";
        System.out.println(dog1.name);*/
        System.out.println(dog1.getName());
        dog.setName("Bobik");
        dog1.setName("Tuzik");
        System.out.println(dog.getName());
        System.out.println(dog1.getName());
        System.out.println(dog);
        dog.dogVoice();
        Dog.someMethode();//этот метод статичен, он не обращается к объекту класса
    }
}
