package main.java.com.loganlyser;

/* Project Imports */
import main.java.com.loganlyser.model.*;
import main.java.com.loganlyser.processor.*;
import main.java.com.loganlyser.buffer.*;
import main.java.com.loganlyser.util.*;

public class Main {
    public static void main(String[] args){
        LogBuffer<IdentifiableLog> buffer = new LogBuffer<>(100);
        LogFileReader myFileReader = new LogFileReader("src/main/resources/log.txt", buffer);
        LogProcessor<IdentifiableLog> myProcessor = new LogProcessor<>(buffer);
        Thread producerThread = new Thread(myFileReader);
        Thread consumerThread = new Thread(myProcessor);

        producerThread.start();
        consumerThread.start();

        try {
            consumerThread.join();
            producerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}