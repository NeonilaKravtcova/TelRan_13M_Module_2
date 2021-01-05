package de.telran;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.assertEquals;

public class StackMaxTest {

    StackMax deque = new StackMax();

    @Test
    public void findMaxAndLastEltOfEmptyStack_catchEDE(){
        assertEquals(0, deque.size());
        assertThrows(EmptyDequeException.class, () -> deque.getLast());
        assertThrows(EmptyDequeException.class, () -> deque.getMax());
        assertThrows(EmptyDequeException.class, () -> deque.removeLast());
    }

    @Test
    public void addOneEltToEmptyDeque_testSizeAndLastAndMaxElt(){
        deque.addLast(5);
        assertEquals(1, deque.size());
        assertEquals( 5, deque.getLast());
        assertEquals( 5, deque.getMax());
        assertEquals(5, deque.removeLast());
    }


    @Test
    public void addSomeEltsToEmptyDequeRemoveSomeElts_testMaxElt(){
        for (int i = 1; i < 5; i++) {
            deque.addLast(i * 2);
        }
        assertEquals(8, deque.getMax());
        deque.addLast(10);
        assertEquals(10, deque.getMax());
        deque.removeLast();
        deque.removeLast();
        deque.removeLast();
        assertEquals(4, deque.getMax());
    }

    @Test
    public void addAndRemoveSomeElts_testMaxElt(){
        for (int i = 4; i >= 0; i--) {
            deque.addLast(i * 2);
        }
        assertEquals(8, deque.getMax());
        deque.removeLast();
        deque.removeLast();
        assertEquals(8, deque.getMax());
    }

}
