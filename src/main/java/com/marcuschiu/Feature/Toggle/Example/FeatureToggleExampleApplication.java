package com.marcuschiu.Feature.Toggle.Example;
//    @FeatureToggle(ScheduledPollerFT.class)
import com.marcuschiu.Feature.Toggle.Example.feature.toggle.FeatureToggle;
import com.marcuschiu.Feature.Toggle.Example.feature.toggle.features.ScheduledPollerFT;
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

    @Scheduled(cron = "*/1 * * * * *")
    public void schedule1() {
        System.out.println("Hello, World! " + System.currentTimeMillis() / 1000);
    }
}
