package de.telran;

public interface IntegerList {

    //Нет ни одного слова static, то есть все эти методы присущи всем объектам-наследникам этого интерфейса

    /**
     * Adds element to the "this" instance
     * @param element - to add
     */
    void addLast(int element);

    /**
     * Returns element by index
     * It must be in the range between 0 and (size - 1)
     * @param index - index of the element to return
     * @return - returns element by index
     */
    int get(int index);

    /**
     * Sets value to the index place in the "this" instance
     * @param index the place to set
     * @param value the value to set
     */
    void set(int index, int value);

    /**
     * Removes element by index
     * @param index index of the element to remove
     * @return the value of the removed element
     */
    int removeById(int index);

    /**
     *
     * @return
     */
    int size();

    void clear();

}
