package com.craftcoding.dsalgo.microservicpattern.demo.circuitbreak;

public class CircuitBreakerDemo {
    public static void main(String[] args) {
        WeatherService weatherService = new WeatherService();
        CircuitBreaker circuitBreaker = new CircuitBreaker();

        for (int i = 0; i < 10; i++) {
            try {
                circuitBreaker.call(weatherService);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            try {
                Thread.sleep(500); // Wait half a second before the next call
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
