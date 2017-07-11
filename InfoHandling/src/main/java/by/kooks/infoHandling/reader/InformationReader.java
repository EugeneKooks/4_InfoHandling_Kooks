package by.kooks.infoHandling.reader;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class InformationReader {
    private static final Logger LOGGER = LogManager.getLogger(InformationReader.class);

    private InformationReader() {
    }

    public static String readFile(String path) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
        } catch (IOException e) {
            LOGGER.log(Level.FATAL, "Incorrect file", e);
            throw new RuntimeException("Incorrect file", e);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String line : lines) {
            stringBuilder.append(line).append("\n");
        }
        return stringBuilder.toString();
    }
}
