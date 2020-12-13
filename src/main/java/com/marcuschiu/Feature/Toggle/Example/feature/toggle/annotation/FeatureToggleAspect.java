package com.marcuschiu.Feature.Toggle.Example.feature.toggle.annotation;

import com.marcuschiu.Feature.Toggle.Example.feature.toggle.FeatureToggleService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FeatureToggleAspect {

    @Autowired
    FeatureToggleService featureToggleService;

    @Around(value="@annotation(featureToggle)")
    public Object featureToggle(ProceedingJoinPoint joinPoint, FeatureToggle featureToggle) throws Throwable {
        Boolean isEnabled = featureToggleService.isActive(featureToggle.feature());
        if (isEnabled) {
            return joinPoint.proceed();
        } else {
            return null;
        }
    }
}
