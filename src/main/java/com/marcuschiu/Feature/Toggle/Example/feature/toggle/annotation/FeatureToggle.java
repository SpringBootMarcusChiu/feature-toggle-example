package com.marcuschiu.Feature.Toggle.Example.feature.toggle.annotation;

import com.marcuschiu.Feature.Toggle.Example.feature.toggle.features.AbstractFeatureToggle;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FeatureToggle {
    public Class<? extends AbstractFeatureToggle> feature();
}
