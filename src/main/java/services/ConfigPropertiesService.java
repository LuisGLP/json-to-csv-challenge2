package services;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Service class responsible for loading a Config Properties file.
 * <p>
 *     This class uses the properties of the file to load de input/output path and delimiter.
 * </p>
 *
 * @author Luis
 * @version 0.1
 */

public class ConfigPropertiesService {
    private Properties properties = new Properties();

    /**
     * Method to load the config.properties file
     * @param fileName Path of the file
     * @throws IOException
     */
    public ConfigPropertiesService(String fileName) throws IOException {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(fileName)) {
            if (input == null) {
                throw new IOException("⚠ Config file not found: " + fileName);
            }
            properties.load(input);
        }
    }

    /**
     * Returns the value of the keys.
     *
     * @param key Key of the value.
     * @param defaultValue Default value if not exist the value of the key.
     * @return Return the value.
     */
    public String get(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}
