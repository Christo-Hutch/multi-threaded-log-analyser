package main.java.com.loganlyser.model;

import java.time.LocalDateTime;

/**
 * An immutable representation of a single database log event within the system.
 * 
 * @param id        The unique identifier for the event.
 * @param timestamp The exact date and time the event occured.
 * @param level     The severity level of the event.
 * @param message   The description text associated with the log.
 * @param database  The database in which the event occured.
 * @see IdentifiableLog The interface for log event records.
 */
public record DatabaseLogEntry(
        String id,
        LocalDateTime timestamp,
        LogLevel level,
        String message,
        String database) implements IdentifiableLog {

    @Override
    public String getFormattedEntry() {
        return String.format("(%s) -SECURITY- [%s] %s: %s (Database: %s)", id, timestamp, level, message, database);
    }

    @Override
    public String getMetaData() {
        return database;
    }
}