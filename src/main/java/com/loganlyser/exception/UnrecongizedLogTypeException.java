package main.java.com.loganlyser.exception;

/**
 * Thrown when LogFileReader encounters a line with an unacceptable log type.
 */
public class UnrecongizedLogTypeException extends Exception {
    private final String rawData;
    private final int lineNumber;

    public UnrecongizedLogTypeException(String message, int lineNumber, String rawData, Throwable cause) {
        super(message, cause);
        this.lineNumber = lineNumber;
        this.rawData = rawData;
    }

    public String getRawData(){
        return this.rawData;
    }

    public int getLineNumber(){
        return this.lineNumber;
    }
}