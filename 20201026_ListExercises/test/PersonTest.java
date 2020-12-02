import de.telran.Address;
import de.telran.Person;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonTest {
    @Test
    public void getAddresses() {
        List<Person> personList = new ArrayList<>(Arrays.asList(new Person("Vasya", new Address("Bahnhofstr.", 5)), new Person("Kolya", new Address("Hauptstr.", 12))));
        List<Address> addresses = Person.getAddresses(personList);
        List<Address> expectedAddresses = Arrays.asList(new Address("Bahnhofstr.", 5), new
                Address("Hauptstr.", 12));
        Assert.assertEquals(expectedAddresses, addresses);
        Assert.assertEquals(expectedAddresses.size(), addresses.size());
    }
}
