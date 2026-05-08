package main.java.com.loganlyser.exception;

/**
 * Base exception for all issues within the Log Analysis System.
 */
public class LogAnalysisException extends Exception {
    public LogAnalysisException(String message){
        super(message);
    }

    public LogAnalysisException(String message, Throwable cause){
        super(message, cause);
    }
}
