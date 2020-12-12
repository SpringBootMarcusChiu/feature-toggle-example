package com.marcuschiu.Feature.Toggle.Example.feature.toggle;

import com.marcuschiu.Feature.Toggle.Example.feature.toggle.features.FeatureI;
import com.marcuschiu.Feature.Toggle.Example.feature.toggle.features.FeatureToggleI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeatureService {

    List<FeatureI> features;

    @Autowired
    public FeatureService(List<FeatureI> features) {
        this.features = features;
    }

    public Object get(Class<? extends FeatureI> _class) {
        for (FeatureI feature : features) {
            if (feature.getClass().equals(_class)) {
                return feature.get();
            }
        }
        return null;
    }

    public Boolean toggleFeature(Class<? extends FeatureToggleI> _class) {
        for (FeatureI feature : features) {
            if (feature.getClass().equals(_class)) {
                return ((FeatureToggleI)feature).toggle();
            }
        }
        return null;
    }
}
