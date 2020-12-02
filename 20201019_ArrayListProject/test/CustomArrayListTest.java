import de.telran.CustomArrayList;
import org.junit.Assert;
import org.junit.Test;

public class CustomArrayListTest {
    @Test
    public void testSizeZero(){
        CustomArrayList al = new CustomArrayList();
        Assert.assertEquals(0, al.size());
    }

    @Test
    public void testSizeNotZero(){
        int[] array = {1, 2, 3, 4};
        CustomArrayList<Integer> nums = new CustomArrayList<>();
        for (int a : array) {
            nums.add(a);
        }
        Assert.assertEquals(4, nums.size());
    }

    @Test
    public void testCorrectSizeChanged(){
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        CustomArrayList<Integer> nums = new CustomArrayList<>();
        for (int a : array) {
            nums.add(a);
        }
        Assert.assertEquals(7, nums.size());
    }

    @Test
    public void testAddCorrectOrder(){
        int[] array = {1, 4, 3, 2};
        CustomArrayList<Integer> nums = new CustomArrayList<>();
        for (int a : array) {
            nums.add(a);
        }
        for (int i = 0; i < array.length; i++) {
            Assert.assertEquals(array[i], nums.get(i).intValue());
        }
    }

    @Test
    public void testRemoveByIndex(){
        int[] array = {1, 2, 3, 4, 5};
        CustomArrayList<Integer> nums = new CustomArrayList<>();
        for (int a : array) {
            nums.add(a);
        }
        int actualDeleteNumber = nums.removeById(2);//3
        int[] expected = {1, 2, 4, 5};
        Assert.assertEquals(3, actualDeleteNumber);
        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(expected[i], nums.get(i).intValue());
        }
        Assert.assertEquals(4, nums.size());
    }

    //Write test above with String

    @Test
    public void testRemoveStringByIndex(){
        String[] array = {"We", "make", "Array", "List", "project"};
        CustomArrayList<String> input = new CustomArrayList<>();
        for (String s : array) {
            input.add(s);
        }
        String stringToDelete = input.removeById(2);//"Array"
        String[] expected = {"We", "make", "List", "project"};
        Assert.assertEquals("Array", stringToDelete);
        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(expected[i], input.get(i));
        }
        Assert.assertEquals(4, input.size());
    }

    @Test
    public void testRemoveByElement(){
        String[] input = {"aa", "bb", "cc", "dd"};
        CustomArrayList<String> listString = new CustomArrayList<>();
        //В новый listString нам нужно добавить элементы из массива
        for (String s : input) {
            listString.add(s);
        }
        boolean isRemoved = listString.remove("aa");
        boolean isNotRemoved = listString.remove("ff");
        Assert.assertTrue(isRemoved);
        Assert.assertFalse(isNotRemoved);

        String[] expected = {"bb", "cc", "dd"};
        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(expected[i], listString.get(i));
        }
        Assert.assertEquals(3, listString.size());
    }

    @Test
    public void testIndexOfInt(){
        int[] array = {1, 7, 3, 5, 8};
        CustomArrayList<Integer> input = new CustomArrayList<>();
        for (int i : array) {
            input.add(i);
        }
        int elementToFind = 5;
        int expectedIndexOfElementToFind = 3;
        for (int i = 0; i < array.length; i++) {
            Assert.assertEquals(expectedIndexOfElementToFind, input.indexOf(elementToFind));
        }
        Assert.assertEquals(5, elementToFind);
    }

    @Test
    public void testIndexOfString(){
        String[] array = {"We", "make", "Array", "List", "project"};
        CustomArrayList<String> input = new CustomArrayList<>();
        for (String s : array) {
            input.add(s);
        }
        String elementToFind = "project";
        int expectedIndexOfElementToFind = 4;
        for (int i = 0; i < array.length; i++) {
            Assert.assertEquals(expectedIndexOfElementToFind, input.indexOf(elementToFind));
        }
        Assert.assertEquals("project", elementToFind);
    }
}

