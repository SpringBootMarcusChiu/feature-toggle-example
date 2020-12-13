package com.marcuschiu.Feature.Toggle.Example.rest;

import com.marcuschiu.Feature.Toggle.Example.feature.toggle.FeatureToggleService;
import com.marcuschiu.Feature.Toggle.Example.feature.toggle.features.AbstractFeatureToggle;
import com.marcuschiu.Feature.Toggle.Example.feature.toggle.features.ScheduledPollerFeatureToggle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/feature")
public class FeatureToggleRestController {

    @Autowired
    FeatureToggleService featureToggleService;

    @GetMapping("/list")
    public List<AbstractFeatureToggle> getFeatureToggles() {
        return featureToggleService.getFeatureToggles();
    }

    @GetMapping("/toggle/{name}")
    public Boolean toggleFeature(@PathVariable(value="name") String name) {
        return featureToggleService.toggleFeature(name);
    }
}
