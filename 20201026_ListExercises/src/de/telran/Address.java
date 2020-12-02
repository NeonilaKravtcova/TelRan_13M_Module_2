package de.telran;

public class Address {
    private String street;
    private int hausNumber;


    public Address (String street, int hausNumber){
        this.street = street;
        this.hausNumber = hausNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address address = (Address) o;

        if (hausNumber != address.hausNumber) return false;
        return street.equals(address.street);
    }

    @Override
    public String toString() {
        return "Address: " + street +
                ", " + hausNumber;
    }
}
