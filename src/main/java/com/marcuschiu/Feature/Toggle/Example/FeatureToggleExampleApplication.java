package com.marcuschiu.Feature.Toggle.Example;

import com.marcuschiu.Feature.Toggle.Example.feature.toggle.annotation.FeatureToggle;

import com.marcuschiu.Feature.Toggle.Example.feature.toggle.features.ScheduledPollerFeatureToggle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@SpringBootApplication
public class FeatureToggleExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeatureToggleExampleApplication.class, args);
    }

    @FeatureToggle(feature = ScheduledPollerFeatureToggle.class)
    @Scheduled(cron = "*/1 * * * * *")
    public void schedule1() {
        System.out.println("Hello, World! " + System.currentTimeMillis() / 1000);
    }
}
