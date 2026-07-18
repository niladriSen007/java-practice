package concurrency.semaphore;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class Connection {
    private final int id;

    public Connection(int id) {
        this.id = id;
    }

    public void execute(String query) {
        System.out.println("Connection " + id + " executing: " + query);
    }
}

class ConnectionPool {
    private final Queue<Connection> connections;
    private final Semaphore semaphore;

    public ConnectionPool(int poolSize) {
        // Fair ordering ensures threads get connections in request order
        // This prevents starvation under high load
        connections = new LinkedList<>();
        semaphore = new Semaphore(poolSize, true);

        // Pre-create all connections at startup
        // This makes acquisition fast (just grab from queue)
        for (int i = 0; i < poolSize; i++) {
            connections.add(new Connection(i));
        }
    }

    public Connection acquireConnection() throws InterruptedException {
        // First, acquire a permit (blocks if all connections in use)
        semaphore.acquire();
        // Then grab a connection from the pool
        // We must synchronize pool access since multiple threads touch it
        synchronized (connections) {
            return connections.poll();
        }
    }

    public Connection tryAcquireConnection(long timeOut, TimeUnit unit) throws InterruptedException {
        // Try to get a permit within the timeout
        if (semaphore.tryAcquire(timeOut, unit)) {
            synchronized (connections) {
                return connections.poll();
            }
        }
        return null;
    }

    public void release(Connection connection) {
        // Return connection to the pool first
        synchronized (connections) {
            connections.offer(connection);
        }
        // Then release the permit, allowing another thread to proceed
        semaphore.release();
    }

    public int availableConnections() {
        return semaphore.availablePermits();
    }
}


public class ConnectionPoolDemo {
    public static void main(String[] args) throws InterruptedException {
        // Create a pool with only 3 connections
        ConnectionPool pool = new ConnectionPool(3);

        // But we'll have 10 threads trying to use it simultaneously
        ExecutorService executor = Executors.newFixedThreadPool(10);


        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            executor.submit(() -> {
                try {
                    // This will block for tasks 4-10 until earlier tasks release
                    Connection conn = pool.acquireConnection();
                    try {
                        conn.execute("SELECT * FROM users WHERE id = " + taskId);
                        Thread.sleep(1000);  // Simulate query execution time
                    } finally {
                        pool.release(conn);  // Always release!
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
    }
}
