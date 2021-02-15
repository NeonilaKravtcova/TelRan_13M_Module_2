package de.telran;

import de.telran.operation.IStringOperation;
import de.telran.operation.OperationContext;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.mockito.Mockito.mock;

public class HandleRawStringUpperCaseTest {



    public HandleRawStringUpperCaseTest() throws FileNotFoundException {
    }

    final String FILE_INPUT = "input.txt";
    final String FILE_OUTPUT = "output.txt";

    private static final String SEPARATOR = "#";
    private static final String WRONG_FORMAT = "wrong format";
    private static final String WRONG_OPERATION = "wrong operation";

    PrintWriter writer = new PrintWriter(new FileOutputStream(FILE_OUTPUT));
    BlockingQueue<String> queue = new LinkedBlockingQueue<>();


    OperationContext operationContext;
    IStringOperation operation;

    @BeforeEach
    public void init() {
        operationContext = mock(OperationContext.class);
        operation = operationContext.getOperation("upper_case");
    }

    Consumer consumer = new Consumer(queue, writer, operationContext);

    @Test
    public void noSeparatorTest(){
        Assert.assertEquals("hello" + SEPARATOR + WRONG_FORMAT, consumer.handleRawString("hello"));
    }

    @Test
    public void noTextBeforeSeparatorTest(){
        Assert.assertEquals("#upper_case" + SEPARATOR + WRONG_FORMAT, consumer.handleRawString("#upper_case"));
    }

    @Test
    public void noText_NoOperation_SeparatorOnlyTest(){
        Assert.assertEquals("#" + SEPARATOR + WRONG_FORMAT, consumer.handleRawString("#"));
    }

    @Test
    public void emptyLineTest(){
        Assert.assertEquals("" + SEPARATOR + WRONG_FORMAT, consumer.handleRawString(""));
    }

}


