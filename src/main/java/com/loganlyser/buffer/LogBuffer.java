package main.java.com.loganlyser.buffer;

import java.util.LinkedList;
import java.util.Queue;

import main.java.com.loganlyser.model.IdentifiableLog;

/**
 * Custom queue class for all IdentifiableLog objects.
 */
public class LogBuffer<T extends IdentifiableLog> {
    private Queue<T> queue = new LinkedList<>();

    public void addLog(T log) {
        queue.add(log);
    }

    /**
     * Retrieves and removes the head of queue.
     * 
     * @return An object under the IdentifiableLog interface contract.
     */
    public T nextLog() {
        return queue.poll();
    }

    /**
     * @return True if queue contains no elements
     */
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}