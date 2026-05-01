package main.java.com.loganlyser.model;

import java.time.LocalDateTime;

/**
 * An immutable representation of a single log event within the system.
 * 
 * @param timestamp The exact date and time the event occured.
 * @param level     The severity level of the event.
 * @param message   The description text associated with the log.
 * @see IdentifiableLog The interface for log event records.
 */
public record LogEntry(LocalDateTime timestamp, LogLevel level, String message) implements IdentifiableLog {
    public LogEntry {
        if (timestamp == null || level == null || message == null) {
            throw new IllegalArgumentException("LogEntry components cannot be null");
        }
    }
}