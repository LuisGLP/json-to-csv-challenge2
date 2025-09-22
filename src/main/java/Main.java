import services.ConverterService;

import java.io.IOException;

/**
 * Entry point of the application.
 * <p>
 * This class initializes the conversion process from a JSON file to a CSV file.
 * It accepts input and output file paths (and an optional delimiter) as command-line arguments.
 * If no arguments are provided, it falls back to default paths.
 * </p>
 *
 * <h2>Usage</h2>
 * <pre>
 *     java -jar json2csv.jar input.json output.csv ";"
 * </pre>
 *
 * <p>Arguments:</p>
 * <ul>
 *   <li><b>args[0]</b> - Path to the input JSON file (required)</li>
 *   <li><b>args[1]</b> - Path to the output CSV file (required)</li>
 *   <li><b>args[2]</b> - Delimiter to use in the CSV file (optional, default = ",")</li>
 * </ul>
 *
 * @author Luis
 * @version 0.1
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String inputPath;
        String outputPath;
        String delimiter;

        System.out.println("Usage: java -jar json2csv.jar <input.json> <output.csv>");

        if (args.length < 2) {
            inputPath = "src/main/resources/cities.json";
            outputPath = "src/main/resources/output3.csv";
            delimiter = ",";

            System.out.println("⚠ No arguments provided, using default paths:");
            System.out.println("Input JSON: " + inputPath);
            System.out.println("Output CSV: " + outputPath);
        } else {
            inputPath = args[0];
            outputPath = args[1];
            delimiter = args[2];
        }

        ConverterService converter = new ConverterService();
        converter.convert(inputPath, outputPath,delimiter);
        System.out.println("Converted JSON: " + outputPath);
        System.out.println("Converted CSV: " + outputPath);
    }
}
