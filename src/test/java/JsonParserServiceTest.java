import org.junit.Test;
import services.JsonParserService;

import java.io.IOException;


public class JsonParserServiceTest {

    private final JsonParserService parser = new JsonParserService();

    /**
     * Checks if the file exists
     */
    @Test(expected = IOException.class)
    public void testFileNotFound() throws IOException {
        parser.parseJson("test.json");
    }

    /**
     * Checks if the JSON file has all the keys
     */
    @Test (expected = IllegalStateException.class)
    public void testParseInvalidJson() throws IOException {
        parser.parseJson("src/test/resources/test.json");
    }
}
