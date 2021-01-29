package de.telran;

public class Auto {
    String make;
    Colors color;

    public Auto(String make, Colors color) {
        this.make = make;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Auto)) return false;

        Auto auto = (Auto) o;

        if (!make.equals(auto.make)) return false;
        return color.equals(auto.color);
    }

    @Override
    public int hashCode() {
        int result = make.hashCode();
        result = 31 * result + color.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Auto: " +
                make + '\'' +
                ", " + color;
    }
}
