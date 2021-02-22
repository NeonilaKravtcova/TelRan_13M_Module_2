import de.telran.Numbers;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumbersTest {

    Numbers number = new Numbers();

    List<Integer> primeNumbers = new ArrayList(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,
            53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163,
            167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251));

    List<Integer> nonPrimeNumbers = new ArrayList(Arrays.asList(1, 4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 22,
            24, 25, 26, 27, 28, 30, 32, 33, 34, 35, 36, 38, 39, 40, 42, 44, 45, 46, 48, 49, 50, 51, 52, 54, 55, 56));


    @Test
    public void isPrime_test() {
        for (Integer i : primeNumbers) {
            Assert.assertTrue(number.isPrime(i));
        }
    }

    @Test
    public void isNotPrime_test() {
        for (Integer i : nonPrimeNumbers) {
            Assert.assertFalse(number.isPrime(i));
        }
    }
}
