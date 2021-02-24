import de.telran.TwoStreams;
import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

public class TwoStreamsTest {

    TwoStreams streams = new TwoStreams();

    IntStream stream1 = IntStream.iterate(0, i -> i + 2).limit(50);
    IntStream stream2 = IntStream.iterate(1, i -> i + 2).limit(50);

    @Test
    public void merge_test(){
        IntStream res = IntStream.of(30, 45, 60, 75, 90);
        Assert.assertEquals(res, streams.merge(stream1, stream2));
    }
}
