package main.java.com.loganlyser.util;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;

import main.java.com.loganlyser.model.*;
import main.java.com.loganlyser.buffer.LogBuffer;
import main.java.com.loganlyser.exception.UnrecongizedLogTypeException;

/**
 * A class for reading from log files and abstracting the data.
 */
public class LogFileReader implements Runnable{
    private final String filePath;
    private final LogBuffer<IdentifiableLog> buffer;

    public LogFileReader(String filePath, LogBuffer<IdentifiableLog> buffer) {
        this.filePath = filePath;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            readLogsFromFile();
        } catch (IOException e) {
            System.err.println("Critical I/O Error: " + e.getMessage());
        } finally {
            buffer.addLog(new EndOfStreamLog());
        }
    }

    /**
     * Scans and records all valid logs within parsed file.
     * 
     * @param filePath
     * @param buffer
     * @return A LogBuffer containing all valid logs from log file.
     * @throws IOException
     */
    public LogBuffer<IdentifiableLog> readLogsFromFile() throws IOException {
        Path path = Paths.get(filePath);
        int lineNumberCounter = 0;

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                IdentifiableLog log = switch (parts[0]) {
                    case "NET" -> new NetworkLogEntry(parts[1], LocalDateTime.parse(parts[2]), LogLevel.valueOf(parts[3]), parts[4], parts[5]);

                    case "SYS" -> new SystemLogEntry(parts[1], LocalDateTime.parse(parts[2]), LogLevel.valueOf(parts[3]), parts[4]);

                    case "APP" -> new ApplicationLogEntry(parts[1], LocalDateTime.parse(parts[2]), LogLevel.valueOf(parts[3]), parts[4], parts[5]);

                    case "AUTH" -> new AuthenticationLogEntry(parts[1], LocalDateTime.parse(parts[2]), LogLevel.valueOf(parts[3]), parts[4], parts[5]);

                    case "DB" -> new DatabaseLogEntry(parts[1], LocalDateTime.parse(parts[2]), LogLevel.valueOf(parts[3]), parts[4], parts[5]);

                    case "SEC" -> new SecurityLogEntry(parts[1], LocalDateTime.parse(parts[2]), LogLevel.valueOf(parts[3]), parts[4], parts[5]);

                    default -> throw new UnrecongizedLogTypeException("Unknown Log Type: " + parts[0], lineNumberCounter, line, null);
                };

                buffer.addLog(log);

                lineNumberCounter++;
            }

            buffer.addLog(new EndOfStreamLog());

        } catch (UnrecongizedLogTypeException e){
            System.out.println("Skipping unknown entry: " + e.getMessage());
        } catch (Exception e){
            System.out.println("Unexpected error at line " + lineNumberCounter + ": " + e.getMessage());
        }
        return buffer;
    }
}
