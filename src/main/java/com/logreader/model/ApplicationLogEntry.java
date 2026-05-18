package main.java.com.loganlyser.model;

import java.time.LocalDateTime;

/**
 * An immutable representation of a single application log event within the system.
 * 
 * @param id        The unique identifier for the event.
 * @param timestamp The exact date and time the event occured.
 * @param level     The severity level of the event.
 * @param message   The description text associated with the log.
 * @param appName   The name of the application/class where the event occured.
 * @see IdentifiableLog The interface for log event records.
 */
public record ApplicationLogEntry(
        String id,
        LocalDateTime timestamp,
        LogLevel level,
        String message,
        String appName) implements IdentifiableLog {

    @Override
    public String getFormattedEntry() {
        return String.format("(%s) -NETWORK- [%s] %s: %s (Application: %s)", id, timestamp, level, message, appName);
    }

    @Override
    public String getMetaData() {
        return appName;
    }
}
