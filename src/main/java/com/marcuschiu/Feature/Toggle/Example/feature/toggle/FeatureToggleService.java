package com.marcuschiu.Feature.Toggle.Example.feature.toggle;

import com.marcuschiu.Feature.Toggle.Example.feature.toggle.features.AbstractFeatureToggle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeatureToggleService {

    private final List<AbstractFeatureToggle> features;

    @Autowired
    public FeatureToggleService(List<AbstractFeatureToggle> features) {
        this.features = features;
    }

    public Boolean isActive(Class<? extends AbstractFeatureToggle> _class) {
        for (AbstractFeatureToggle feature : features) {
            if (feature.getClass().equals(_class)) {
                return feature.isActive();
            }
        }
        return null;
    }

    public Boolean toggleFeature(Class<? extends AbstractFeatureToggle> _class) {
        for (AbstractFeatureToggle feature : features) {
            if (feature.getClass().equals(_class)) {
                return feature.toggle();
            }
        }
        return null;
    }

    public Boolean toggleFeature(String name) {
        for (AbstractFeatureToggle feature : features) {
            if (feature.getName().equals(name)) {
                return feature.toggle();
            }
        }
        return null;
    }

    public List<AbstractFeatureToggle> getFeatureToggles() {
        return features;
    }
}
