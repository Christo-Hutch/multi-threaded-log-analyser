package main.java.com.loganlyser.model;

/**
 * Represents the severity level of a log entry.
 * Levels are ordered by increasing severity.
 */
public enum LogLevel{
    DEBUG(1),
    INFO(2),
    WARN(3),
    ERROR(4),
    FATAL(5);

    private final int priority;

    LogLevel(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return this.priority;
    }
}