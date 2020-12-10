package com.marcuschiu.Feature.Toggle.Example.feature.toggle;

import com.marcuschiu.Feature.Toggle.Example.feature.toggle.features.FTI;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FeatureToggle {
    public Class<? extends FTI> value();
}
