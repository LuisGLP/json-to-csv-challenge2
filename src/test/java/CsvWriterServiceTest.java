import models.CityRecord;
import org.junit.Test;
import services.CsvWriterService;
import java.io.IOException;
import java.util.Arrays;

public class CsvWriterServiceTest {

    private final CsvWriterService writer = new CsvWriterService();

    /**
     * Checks if the list of records are no empty
     */
    @Test(expected = IllegalArgumentException.class)
    public void testEmptyListWritesHeaders() throws IOException {
        String outputPath = "src/test/resources/empty.csv";
        writer.writerToCsv(Arrays.asList(), outputPath, ",");
    }
}
