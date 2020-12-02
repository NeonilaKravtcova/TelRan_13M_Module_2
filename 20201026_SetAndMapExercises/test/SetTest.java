import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SetTest {

    @Test
    public void removeDuplicates(){
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 3, 4, 5, 6, 7, 2, 4);
        List<Integer> expectedList = new ArrayList<>();
        Collections.addAll(expectedList, 1, 2, 3, 4, 5, 6, 7);
        assertEquals(expectedList, Main.removeDuplicates(list));
    }

    @Test
    public void getDuplicates(){
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 3, 4, 5, 6, 7, 2, 4, 7, 7);
        List<Integer> expectedList = new ArrayList<>();
        Collections.addAll(expectedList, 3, 2, 4, 7, 7);
        assertEquals(expectedList, Main.getDuplicates(list));
    }

}
