package com.craftcoding.dsalgo.microservicpattern.demo.circuitbreak;

import java.util.Random;

public class WeatherService {
    private static final Random random = new Random();

    // Simulates fetching weather data from an external service
    public void fetchWeather() throws Exception {
        Thread.sleep(100); // Simulate network delay
        if (random.nextInt(10) < 3) {  // 30% chance to fail
            throw new Exception("Failed to fetch weather data");
        }
        System.out.println("Weather data fetched successfully");
    }
}
