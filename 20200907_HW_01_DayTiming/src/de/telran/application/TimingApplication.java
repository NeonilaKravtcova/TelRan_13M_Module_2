package de.telran.application;

import de.telran.data.Time;

import java.util.Scanner;

public class TimingApplication {
    public static void main(String[] args) {
        timeManager();
    }

    public static void timeManager() {
        Time time = new Time(0, 0);
        System.out.println("Текущее время ");
        assert false;
        System.out.print("Введите часы: ");
        assert false;
        time.setHours(new Scanner(System.in).nextInt());
        System.out.print("Введите минуты: ");
        time.setMinutes(new Scanner(System.in).nextInt());

        if (time.getMinutes() == 0){
            System.out.println("Сейчас ровно " + time.getHours() + " часов");
        } else if (time.getMinutes() > 0 && time.getMinutes() < 30) {
            System.out.println(time);
        } else if (time.getMinutes() == 30) {
            System.out.println("Сейчас пол-" + (time.getHours() + 1) + "-го");
        } else {
            System.out.println("Сейчас без " + time.getMinutes() + " минут " + time.getHours() + 1);
        }

        if (time.getHours() >= 22 && time.getHours() <= 23) {
            System.out.println("Вам пора спать!");
        }
        if (time.getHours() >= 0 && time.getHours() <= 3) {
            System.out.println("Срочно идите спать - Вы не выспитесь!");
        }
        if (time.getHours() > 3 && (time.getHours() <= 6)) {
            System.out.println("Скоро рассвет..");
        }

        if (time.getHours() == 7) {
            System.out.println("Пора вставать");
        }

        if (time.getHours() == 8) {
            System.out.println("Вы завтракаете и едете на работу");
        }

        if (time.getHours() > 8 && time.getHours() <= 15) {
            System.out.println("Должно быть, вы на работе");
        }

        if (time.getHours() > 15 && time.getHours() < 22) {
            System.out.println("У вас свободное время");
        }
        System.out.println();
        timeManager();
    }
}
