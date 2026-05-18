package main.java.com.loganlyser.model;

import java.time.LocalDateTime;

/**
 * An immutable representation of a single network log event within the system.
 * 
 * @param id        The unique identifier for the event.
 * @param timestamp The exact date and time the event occured.
 * @param level     The severity level of the event.
 * @param message   The description text associated with the log.
 * @param ipAddress The ip address of the where the event occured.
 * @see IdentifiableLog The interface for log event records.
 */
public record NetworkLogEntry(
        String id,
        LocalDateTime timestamp,
        LogLevel level,
        String message,
        String ipAddress) implements IdentifiableLog {

    @Override
    public String getFormattedEntry() {
        return String.format("(%s) -NETWORK- [%s] %s: %s (IP Address: %s)", id, timestamp, level, message, ipAddress);
    }

    @Override
    public String getMetaData() {
        return ipAddress;
    }
}