import services.ConfigPropertiesService;
import services.ConverterService;

import java.io.IOException;

/**
 * Entry point of the application.
 * <p>
 * This class initializes the conversion process from a JSON file to a CSV file.
 * It accepts input and output file paths (and an optional delimiter) as configuration file arguments.
 * If no arguments are provided, it falls back to default paths.
 * </p>
 *
 * <h2>Usage</h2>
 * <pre>
 * # src/main/resources/config.properties
 * input.path=src/main/resources/cities.json
 * output.path=src/main/resources/output.csv
 * delimiter=;
 * </pre>
 *
 * @author Luis
 * @version 0.1
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String inputURL = "src/main/resources/cities.json";
        String outputURL = "src/main/resources/output3.csv";
        ConfigPropertiesService config = new ConfigPropertiesService("config.properties");

        String inputPath = config.get("input.path", inputURL);
        String outputPath = config.get("output.path", outputURL);
        String delimiter = config.get("delimiter", ",");

        ConverterService converter = new ConverterService();
        converter.convert(inputPath, outputPath, delimiter);

        System.out.println("✅ Converted JSON → " + outputPath);
    }
}
