import services.ConverterService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String inputPath;
        String outputPath;
        if (args.length < 2) {
            inputPath = "src/main/resources/cities.json";
            outputPath = "src/main/resources/output2.csv";

            System.out.println("⚠ No arguments provided, using default paths:");
            System.out.println("Input JSON: " + inputPath);
            System.out.println("Output CSV: " + outputPath);
        } else {
            inputPath = args[0];
            outputPath = args[1];
        }

        ConverterService converter = new ConverterService();
        converter.convert(inputPath, outputPath);
        System.out.println("Converted JSON: " + outputPath);
        System.out.println("Converted CSV: " + outputPath);
    }
}
