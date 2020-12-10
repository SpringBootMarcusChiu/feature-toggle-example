package com.marcuschiu.Feature.Toggle.Example.rest;

import com.marcuschiu.Feature.Toggle.Example.feature.toggle.FeatureToggle;
import com.marcuschiu.Feature.Toggle.Example.feature.toggle.FeatureToggleAspect;
import com.marcuschiu.Feature.Toggle.Example.feature.toggle.features.RestApiFT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeatureToggleRestController {

    @Autowired
    FeatureToggleAspect featureToggleAspect;

    @FeatureToggle(RestApiFT.class)
    @GetMapping("/")
    public String main() {
        return "hello world";
    }

    @GetMapping("/toggle-scheduled-poller")
    public void toggleScheduledPoller() {
        featureToggleAspect.toggleScheduledPollerEnabled();
    }

    @GetMapping("/toggle-rest-api")
    public void toggleRestApi() {
        featureToggleAspect.toggleRestApiEnabled();
    }
}
