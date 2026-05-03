package main.java.com.loganlyser.util;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;

import main.java.com.loganlyser.model.*;
import main.java.com.loganlyser.buffer.LogBuffer;
import main.java.com.loganlyser.exception.UnrecongizedLogTypeException;

public class LogFileReader {
    public LogBuffer<IdentifiableLog> readLogsFromFile(String filePath, LogBuffer<IdentifiableLog> buffer) throws IOException, UnrecongizedLogTypeException {
        Path path = Paths.get(filePath);

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            int lineNumberCounter = 0;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                IdentifiableLog log = switch (parts[0]) {
                    case "NET" -> new NetworkLogEntry(parts[1], LocalDateTime.parse(parts[2]), LogLevel.valueOf(parts[3]), parts[4], parts[5]);

                    case "SYS" -> new SystemLogEntry(parts[1], LocalDateTime.parse(parts[2]), LogLevel.valueOf(parts[3]), parts[4]);

                    default -> throw new UnrecongizedLogTypeException("Unknown Log Type: " + parts[0], lineNumberCounter, line, null);
                };

                buffer.addLog(log);

                lineNumberCounter += 1;
            }
        }
        return buffer;
    }
}
