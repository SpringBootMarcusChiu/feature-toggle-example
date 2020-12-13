package com.marcuschiu.Feature.Toggle.Example.feature.toggle.features;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ScheduledPollerFeatureToggle extends AbstractFeatureToggle {

    @Autowired
    public ScheduledPollerFeatureToggle(@Value("${feature-toggle.scheduled-poller.enable:true}") Boolean enabled) {
        this.enabled = enabled;
        this.name = "scheduled poller";
    }

    @Override
    public Boolean toggle() {
        System.out.println(name + ": toggled");
        return super.toggle();
    }
}
