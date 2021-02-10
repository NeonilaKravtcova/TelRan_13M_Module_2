package de.telran;

public class ArrayIntegerList implements IntegerList {

    static final int INITIAL_CAPACITY = 16;

    private int size;
    //private int[] source;//чтобы сделать тест для increaseCapacity, можно снять private с source
    public static int[] source;

    public ArrayIntegerList() {
        source = new int[INITIAL_CAPACITY];//создаём место, где будет лежать наш список
    }

    @Override
    public void addLast(int element) {
        if (size == source.length){
            increaseCapacity();
        }
        //source[size++] = element; - то же самое, что и ниже
        source[size] = element;
        size++;
    }

    void increaseCapacity(){
        int newCapacity = source.length * 2;//мы не рассматриваем случай,
                                            // когда длина может перевалить через int, то есть 2(31) - 1
        int[] newSource = new int[newCapacity];
        System.arraycopy(source, 0, newSource, 0, source.length);//быстро копирует содержимое
                                            // одного массива в другой, так как он написан на C
        source = newSource;
    }

    @Override
    public int get(int index) {
        //первым делом проверяем, что индекс у нас корректный
        if (index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        return source[index];
    }

    @Override
    public void set(int index, int value) {
        if (index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        source[index] = value;
    }

    @Override
    public int removeById(int index) {
        if (index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        int valueToDelete = source[index];
        for (int i = index; i < source.length - 1; i++) {
            source[i] = source[i + 1];
        }
        size--;
        return valueToDelete;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        if (size == 0){
            throw new NullPointerException();
        }
        if (size == 1) {
            source[0] = 0;
        } else {
            for (int i = 0; i < source.length; i++) {
                source[i] = 0;
            }
        }
        size = 0;
    }
}
