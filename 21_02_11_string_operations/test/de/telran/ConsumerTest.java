package de.telran;

import de.telran.operation.IStringOperation;
import de.telran.operation.OperationContext;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.*;
import java.util.concurrent.BlockingQueue;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ConsumerTest {

    BlockingQueue<String> queue;
    PrintWriter writer;
    OperationContext operationContext;
    IStringOperation operation;
    Consumer consumer;

    @BeforeEach
    public void init() {
        queue = mock(BlockingQueue.class);
        writer = mock(PrintWriter.class);
        operationContext = mock(OperationContext.class);
        operation = mock(IStringOperation.class);
        operation = operationContext.getOperation("upper_case");
        consumer = new Consumer(queue, writer, operationContext);
        consumer = spy(consumer);
    }

    //Consumer consumer = new Consumer(queue, writer, operationContext);

    @Test
    public void handleRawString_regularCase(){
        when(operation.operate("hello")).thenReturn("HeLlO");
        when(operationContext.getOperation("beliberda_operation")).thenReturn(operation);

        String res = consumer.handleRawString("hello#beliberda_operation");
        assertEquals("HeLlO", res);
    }

    @Test
    public void noSeparatorTest(){
        String res = consumer.handleRawString("hello");
        //Assert.assertEquals("hello" + Consumer.SEPARATOR + Consumer.WRONG_FORMAT, consumer.handleRawString("hello"));
        assertEquals("hello" + Consumer.SEPARATOR + Consumer.WRONG_FORMAT, res);
    }

    @Test
    public void noTextBeforeSeparatorTest(){
        assertEquals("#upper_case" + Consumer.SEPARATOR + Consumer.WRONG_FORMAT, consumer.handleRawString("#upper_case"));
    }

    @Test
    public void noText_NoOperation_SeparatorOnlyTest(){
        assertEquals("#" + Consumer.SEPARATOR + Consumer.WRONG_FORMAT, consumer.handleRawString("#"));
    }

    @Test
    public void emptyLineTest(){
        assertEquals("" + Consumer.SEPARATOR + Consumer.WRONG_FORMAT, consumer.handleRawString(""));
    }

}


