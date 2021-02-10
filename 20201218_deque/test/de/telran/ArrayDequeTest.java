package de.telran;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.assertEquals;

public class ArrayDequeTest {

    OurDeque<Integer> deque = new OurLimitedArrayDeque<>(8);

    @Test
    public void addOneEltAsFirstToEmptyDeque_testSizeAndFirstAndLastElt(){
        deque.addFirst(5);
        assertEquals((Integer) 5, deque.getFirst());
        assertEquals((Integer) 5, deque.getLast());
        assertEquals(1, deque.size());
    }

    @Test
    public void addFiveEltsToEmptyDeque_testSizeAndFirstAndLastElts(){
        for (int i = 0; i < 5; i++) {
            deque.addFirst(i);
        }
        assertEquals(5, deque.size());
        assertEquals((Integer) 4, deque.getFirst());
        assertEquals((Integer) 0, deque.getLast());
    }

    @Test
    public void addNineEltsToEmptyDequeu_catchDOE(){
        for (int i = 0; i < 8; i++) {
            deque.addFirst(i);
        }
        assertThrows(DequeOverflowException.class, () -> deque.addLast(8));
    }

    @Test
    public void getEltFromEmptyArray_catchEDE(){
        assertThrows(EmptyDequeException.class, () -> deque.getFirst());
    }

    @Test
    public void addSomeElts_getFirstElt(){
        deque.addLast(5);
        deque.addLast(3);
        deque.addFirst(-2);
        deque.addFirst(8);
        deque.addLast(4);
        assertEquals((Integer) 8, deque.getFirst());
        assertEquals((Integer) 4, deque.getLast());
    }

    @Test
    public void removeEltFromEmptyDequeu_catchEDE(){
        assertThrows(EmptyDequeException.class, () -> deque.removeFirst());
        assertThrows(EmptyDequeException.class, () -> deque.removeLast());
    }

    @Test
    public void addOneEltRemoveElt_testDeletedEltAndDequeuSizeZero(){
        deque.addLast(5);
        assertEquals((Integer) 5, deque.removeFirst());
        deque.addLast(7);
        assertEquals((Integer) 7, deque.removeLast());
        assertEquals(0, deque.size());
    }

}
