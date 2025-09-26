# JSON to CSV Converter
A simple Java project that converts JSON data into CSV fromat using:
- org.json for JSON parsing.
- Apache Commons CSV for CSV writing
- Junit 4.13.2 for testing

  ## Build and Run
  1. Clone the project
     git clone https://github.com/LuisGLP/json-to-csv-challenge2
     cd json-to-csv-challenge2
  2. Build the project
     mvn clean install
  3. Run the program
     You can run the Main class from IntelliJ IDEA or via Maven:
     mvn exec:java -Dexec.mainClass="com.example.converter.Main"
# Runnign test
Run all tests with:
mvn test

# Example usage
Update the config.properties to add the path of input json and output csv withe the delimiter
# src/main/resources/config.properties
input.path=src/main/resources/cities.json
output.path=src/main/resources/output.csv
delimiter=;

