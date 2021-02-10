package de.telran;

import java.util.*;

public class Main {
    public static void main(String[] args) {

/*        Map<Auto, String> map = new HashMap<>();
        fillMap(map);

        Auto anotherGreyOpel = new Auto("Grey", "Opel");
        String value = map.get(anotherGreyOpel);
        System.out.println(value);*/

        Map<Auto, String> mapAuto = new HashMap<>();
        Auto auto1 = new Auto("Grey", "Opel");
        Auto auto2 = new Auto("Red", "Mazda");
        Auto auto3 = new Auto("Yellow", "Mercedes");
        Auto auto4 = new Auto("Blue", "Volkswagen");

        mapAuto.put(auto1, "Owner: Olga");

        }

    static void fillMap (Map<Auto, String> map) {
        Auto greyOpel = new Auto("Grey", "Opel");
        map.put(greyOpel, "Value of grey opel");
    }
}

class Auto {
    String make;
    String color;

    public Auto(String make, String color) {
        this.make = make;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Auto)) return false;

        Auto auto = (Auto) o;

/*        if (!make.equals(auto.make)) return false;
        return color.equals(auto.color);*/
        return  Objects.equals(make, auto.make) &&
                Objects.equals(color, auto.color);
    }

    @Override
    public int hashCode() {
/*        int result = make.hashCode();
        result = 31 * result + color.hashCode();
        return result;*/
        return Objects.hash(make, color);
    }
}
