package com.marcuschiu.Feature.Toggle.Example.rest;

import com.marcuschiu.Feature.Toggle.Example.feature.toggle.FeatureService;
import com.marcuschiu.Feature.Toggle.Example.feature.toggle.annotation.FeatureToggle;
import com.marcuschiu.Feature.Toggle.Example.feature.toggle.annotation.FeatureToggleAspect;
import com.marcuschiu.Feature.Toggle.Example.feature.toggle.features.RestApiFeature;
import com.marcuschiu.Feature.Toggle.Example.feature.toggle.features.ScheduledPollerFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeatureToggleRestController {

    @Autowired
    FeatureService featureService;

    @FeatureToggle(RestApiFeature.class)
    @GetMapping("/")
    public String main() {
        return "hello world";
    }

    @GetMapping("/toggle-scheduled-poller")
    public void toggleScheduledPoller() {
        featureService.toggleFeature(ScheduledPollerFeature.class);
    }

    @GetMapping("/toggle-rest-api")
    public void toggleRestApi() {
        featureService.toggleFeature(RestApiFeature.class);
    }
}
