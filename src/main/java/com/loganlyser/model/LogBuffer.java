package main.java.com.loganlyser.model;

import java.util.LinkedList;
import java.util.Queue;

public class LogBuffer<T extends IdentifiableLog> {
    private Queue<T> queue = new LinkedList<>();

    public void addLog(T log) {
        queue.add(log);
    }

    public T nextLog() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
