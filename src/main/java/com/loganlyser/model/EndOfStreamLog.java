package main.java.com.loganlyser.model;

import java.time.LocalDateTime;

public record EndOfStreamLog() implements IdentifiableLog{
    @Override public String id() {return "EOF";}
    @Override public LocalDateTime timestamp() {return LocalDateTime.now();}
    @Override public LogLevel level() {return LogLevel.INFO;}
    @Override public String message() {return "End of Stream reached";}
}