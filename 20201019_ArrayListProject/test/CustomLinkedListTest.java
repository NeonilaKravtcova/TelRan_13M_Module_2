import de.telran.CustomArrayList;
import de.telran.CustomLinkedList;
import de.telran.CustomList;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CustomLinkedListTest {

    //CustomLinkedList<Integer> list = new CustomLinkedList<>();
    // Соблюдаем приниципы SOLID
    //Поэтому лучше создать объект через общий интерфейс, а не так, как написано выше
    private CustomList<Integer> list = new CustomLinkedList<>();
    private CustomList<String> listString = new CustomLinkedList<>();

    @Test
    public void testSizeZero(){
        Assert.assertEquals(0, list.size());
    }

    @Test
    public void testSizeNotZero(){
/*        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3);*/
        //list.add(1);
        //list.add(2);
        //list.add(3);
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        Assert.assertEquals(10, list.size());
    }

    @Test
    public void testAddElementValue(){
        listString.add("test");
        String str = listString.get(0);
        Assert.assertEquals("test", str);
    }

    @Test
    public void testGet(){
        for (int i = 0; i < 10; i++) {
            list.add(i * 2);
        }
        int index = (int) (Math.random() * 10);
        int value = list.get(index);
        //System.out.println("index = " + index + ", expected value = " + value);
        Assert.assertEquals(index * 2, value);
    }

    @Test
    public void testRemoveById(){
        for (int i = 0; i < 10; i++) {
            listString.add("0" + i);
        }
        String strToDelete = listString.removeById(3);
        Assert.assertEquals("03", strToDelete);
    }

    @Test
    public void testRemove(){
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        int numberToDelete = list.get((int) (Math.random() * 10));
        Assert.assertTrue(list.remove(numberToDelete));
    }
}
