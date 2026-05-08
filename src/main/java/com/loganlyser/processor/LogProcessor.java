package main.java.com.loganlyser.processor;

import main.java.com.loganlyser.model.IdentifiableLog;

public class LogProcessor<T extends IdentifiableLog> {
    public void process(T log) {
        System.out.println("ID: " + log.id());
        System.out.println("Timestamp: " + log.timestamp());
        System.out.println("Level: " + log.level());
        System.out.println("Message: " + log.message());
        System.out.println("MetaData: " + log.getMetaData());
    }
}