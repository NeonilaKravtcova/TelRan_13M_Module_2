package de.telran;

public class CustomArrayList<E> implements CustomList<E> {

    private Object[] source;
    private int size;
    private static final int DEFAULT_CAPACITY = 5;

    public CustomArrayList(){
        source = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E o) {
        if (size == source.length){
            Object[] newSource = new Object[size + DEFAULT_CAPACITY];
            System.arraycopy(source, 0, newSource, 0, source.length);
            source = newSource;
        }
        source[size++] = o;//size++;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        return (E)source[index];//Компилятор будет пытаться вернуть данные типа Object, а мы в конструкторе
                                // прописали, что у нас

    }

    @Override
    public E removeById(int index) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Object o = (E)source[index];
        System.arraycopy(source, index + 1, source, index, size - index - 1);
        size--;
        return (E)o;
    }

    @Override
    public boolean remove(E e) {
        for (int i = 0; i < size; i++) {
            if (source[i].equals(e)){
                System.arraycopy(source, i + 1, source, i, size - i - 1);
                source[size--] = null;
                return true;
            }
        }
        return false;
    }

    //ДЗ - добавить метод возврата индекса по элементу
    //public int indexOf(E o){}

    public int indexOf(E o){
        for (int i = 0; i < size; i++) {
            if (source[i].equals(o)){
                return i;
            }
        }
        return -1;
    }
}
