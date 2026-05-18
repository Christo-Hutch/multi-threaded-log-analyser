package main.java.com.loganlyser.model;

import java.time.LocalDateTime;

/**
 * An immutable representation of a single system log event within the system.
 * 
 * @param id        The unique identifier for the event.
 * @param timestamp The exact date and time the event occured.
 * @param level     The severity level of the event.
 * @param message   The description text associated with the log.
 * @see IdentifiableLog The interface for log event records.
 */
public record SystemLogEntry(
        String id,
        LocalDateTime timestamp,
        LogLevel level,
        String message) implements IdentifiableLog {

    @Override
    public String getFormattedEntry(){
        return String.format("(%s) -SYSTEM- [%s] %s: %s", id, timestamp, level, message);
    }
}