package com.marcuschiu.Feature.Toggle.Example.feature.toggle.features;

public abstract class AbstractFeatureToggle {
    String name;
    Boolean enabled;

    public Boolean toggle() {
        enabled = !enabled;
        return enabled;
    }

    public Boolean isActive() {
        return enabled;
    }

    public String getName() {
        return name;
    }
}
