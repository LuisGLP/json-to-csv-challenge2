import org.junit.Test;
import services.ConverterService;
import java.io.IOException;

public class ConverterServiceTest {

    private final ConverterService converter = new ConverterService();

    /**
     * Checks if the list of records are no empty
     */
    @Test(expected = IllegalStateException.class)
    public void testEmptyListWritesHeaders() throws IOException {
        converter.convert("src/test/resources/test.json", "src/test/resources/empty.csv", ",");
    }

    /**
     * Checks if the JSON file has all the keys
     */
    @Test (expected = IllegalStateException.class)
    public void testParseInvalidJson() throws IOException {
        converter.convert("src/test/resources/test.json", "src/test/resources/empty.csv", ",");
    }
}
