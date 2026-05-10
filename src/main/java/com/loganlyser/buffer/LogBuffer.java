package main.java.com.loganlyser.buffer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import main.java.com.loganlyser.model.IdentifiableLog;

/**
 * Custom queue class for all IdentifiableLog objects.
 */
public class LogBuffer<T extends IdentifiableLog> {
    private final BlockingQueue<T> queue;

    public LogBuffer(int capacity) {
        this.queue = new ArrayBlockingQueue<>(capacity);
    }

    public void addLog(T log) {
        try {
            queue.put(log);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } 
    }

    /**
     * Retrieves and removes the head of queue.
     * 
     * @return An object under the IdentifiableLog interface contract.
     */
    public T nextLog() throws InterruptedException{
        return queue.take();
    }

    /**
     * @return True if queue contains no elements
     */
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}