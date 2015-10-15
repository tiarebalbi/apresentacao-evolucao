package com.tiarebalbi.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
@EnableHystrixDashboard
public class CircuitMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(CircuitMonitorApplication.class, args);
    }

    @RequestMapping("/")
    public String home() {
        return "forward:/hystrix/index.html";
    }
}
