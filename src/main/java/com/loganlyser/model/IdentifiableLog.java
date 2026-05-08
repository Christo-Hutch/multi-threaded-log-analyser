package main.java.com.loganlyser.model;

import java.time.LocalDateTime;

/**
 * A common contract for all log types in the system.
 */
public interface IdentifiableLog extends Comparable<IdentifiableLog> {
    String id();
    LocalDateTime timestamp();
    LogLevel level();
    String message();
    
    /**
     * Accesses the unique instance variable.
     * 
     * @return A uniquely define instance variable within subclasses.
     */
    default String getMetaData() {
        return "N/A";
    }

    default String getFormattedEntry() {
        return String.format("(%s)[%s] %s: %s (Meta: %s)", id(), timestamp(), level(), message(), getMetaData());
    }

    /**
     * Compares the log levels with the instance log and parsed log.
     * 
     * @param other The parsed log
     * @return The value 0 if instance == parsed; a value less than 0 if 
     *  instance < parsed; and a value greater than 0 if instance > parsed.
     */
    @Override
    default int compareTo(IdentifiableLog other) {
        return Integer.compare(this.level().getPriority(), other.level().getPriority());
    }
}