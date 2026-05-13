package main.java.com.loganlyser.processor;

import main.java.com.loganlyser.buffer.LogBuffer;
import main.java.com.loganlyser.model.EndOfStreamLog;
import main.java.com.loganlyser.model.IdentifiableLog;

public class LogProcessor<T extends IdentifiableLog> implements Runnable{
    private final LogBuffer<IdentifiableLog> buffer;

    public LogProcessor(LogBuffer<IdentifiableLog> buffer) {
        this.buffer = buffer;
    }

    public void process(IdentifiableLog log) {
        System.out.println("Processing: " + log.getFormattedEntry());
    }

    @Override
    public void run() {
        try {
            while (true) {
                IdentifiableLog log = buffer.nextLog();

                if (log instanceof EndOfStreamLog) {
                    System.out.println("Processor: End of stream reached. Shutting down...");
                    break;
                }

                process(log);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Processor interrupted: " + e.getMessage());
        }
    }
}