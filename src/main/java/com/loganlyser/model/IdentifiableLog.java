package main.java.com.loganlyser.model;

import java.time.LocalDateTime;

/**
 * A common contract for all log types in the system.
 */
public interface IdentifiableLog {
    LocalDateTime timestamp();
    LogLevel level();
    String message();
    
    default String getMetaData() {
        return "N/A";
    }

    default String getFormattedEntry() {
        return String.format("[%s] %s: %s (Meta: %s)", timestamp(), level(), message(), getMetaData());
    }
}