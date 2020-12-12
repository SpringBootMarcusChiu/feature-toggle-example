package com.marcuschiu.Feature.Toggle.Example.feature.toggle.features;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ScheduledPollerFeature implements FeatureToggleI {

    @Override
    public Boolean get() {
        return scheduledPollerEnabled;
    }

    @Value("${feature.toggle.scheduled.poller.enabled:true}")
    private boolean scheduledPollerEnabled;

    @Override
    public Boolean toggle() {
        scheduledPollerEnabled = !scheduledPollerEnabled;
        return scheduledPollerEnabled;
    }
}
