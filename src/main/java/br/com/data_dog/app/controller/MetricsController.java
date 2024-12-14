package br.com.data_dog.app.controller;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetricsController {

    private final MeterRegistry meterRegistry;

    public MetricsController(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @GetMapping("/increment")
    public String incrementCounter() {
        meterRegistry.counter("test.counter").increment();
        return "Counter incremented!";
    }
}
