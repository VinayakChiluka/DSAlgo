package com.craftcoding.dsalgo.microservicpattern.demo.circuitbreak;

public class CircuitBreaker {
    private int failureThreshold = 3;
    private int failureCount = 0;
    private long timeout = 3000; // 3 seconds
    private long lastAttempt = 0;
    private boolean open = false;
    private int trialCallsAllowed = 1;
    private int trialCallCount = 0;

    public synchronized void call(WeatherService weatherService) throws Exception {
        if (isOpen()) {
            if (System.currentTimeMillis() - lastAttempt > timeout) {
                halfOpen();
                trialCallCount = 0; // Reset trial call count when half-open
            } else {
                throw new Exception("Circuit breaker is open. Call blocked.");
            }
        }
        try {
            weatherService.fetchWeather();
            reset();
        } catch (Exception e) {
            recordFailure();
            if (open && trialCallCount >= trialCallsAllowed) {
                throw new Exception("Trial calls failed. Circuit remains open.");
            } else if (failureCount >= failureThreshold) {
                open();
            }
            throw e;
        }
    }

    private void reset() {
        failureCount = 0;
        open = false;
        System.out.println("Circuit closed: Normal operations resumed.");
    }

    private void open() {
        lastAttempt = System.currentTimeMillis();
        open = true;
        System.out.println("Circuit opened: Blocking calls due to failures.");
    }

    private void halfOpen() {
        open = false;
        System.out.println("Circuit half-open: Testing service with limited requests.");
    }

    private boolean isOpen() {
        return open;
    }

    private void recordFailure() {
        failureCount++;
        trialCallCount++;
    }
}
