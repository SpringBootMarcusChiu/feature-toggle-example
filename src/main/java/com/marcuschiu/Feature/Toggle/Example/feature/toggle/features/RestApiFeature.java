package com.marcuschiu.Feature.Toggle.Example.feature.toggle.features;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RestApiFeature implements FeatureToggleI {

    @Override
    public Boolean get() {
        return restApiEnabled;
    }

    @Value("${feature.toggle.rest.api.enabled:true}")
    private boolean restApiEnabled;

    @Override
    public Boolean toggle() {
        restApiEnabled = !restApiEnabled;
        return restApiEnabled;
    }
}
