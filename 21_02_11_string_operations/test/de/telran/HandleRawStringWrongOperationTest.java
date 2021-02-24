package de.telran;

import de.telran.operation.OperationContext;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.mockito.Mockito.mock;

public class HandleRawStringWrongOperationTest {

    public HandleRawStringWrongOperationTest() throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    }

    final String FILE_INPUT = "input.txt";
    final String FILE_OUTPUT = "output.txt";

    private static final String SEPARATOR = "#";
    private static final String WRONG_OPERATION = "wrong operation";

    PrintWriter writer = new PrintWriter(new FileOutputStream(FILE_OUTPUT));
    BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    List<String> operationPaths = new ConfigReader("config.props").getOperationPaths();

    //OperationContext operationContext = new OperationContext(operationByName);
    OperationContext operationContext = new OperationContext(operationPaths);

    Consumer consumer = new Consumer(queue, writer, operationContext);

    @Test
    public void wrongOperationNameTest(){
        Assert.assertEquals("hello#opper_case" + SEPARATOR + WRONG_OPERATION, consumer.handleRawString("hello#opper_case"));
    }
}


