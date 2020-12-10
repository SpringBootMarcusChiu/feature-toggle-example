package com.marcuschiu.Feature.Toggle.Example.feature.toggle;

import com.marcuschiu.Feature.Toggle.Example.feature.toggle.features.RestApiFT;
import com.marcuschiu.Feature.Toggle.Example.feature.toggle.features.ScheduledPollerFT;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class FeatureToggleAspect {

    @Around("@annotation(FeatureToggle)")
    public Object featureToggle(ProceedingJoinPoint joinPoint) throws Throwable {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        FeatureToggle puff = method.getAnnotation(FeatureToggle.class);

        if (puff.value().equals(RestApiFT.class)) {
            if (restApiEnabled) {
                return joinPoint.proceed();
            } else {
                return null;
            }
        }
        else if (puff.value().equals(ScheduledPollerFT.class)) {
            if (scheduledPollerEnabled) {
                return joinPoint.proceed();
            } else {
                return null;
            }
        } else {
            return joinPoint.proceed();
        }
    }

    @Value("${feature.toggle.rest.api.enabled:true}")
    private boolean restApiEnabled;

    @Value("${feature.toggle.scheduled.poller.enabled:true}")
    private boolean scheduledPollerEnabled;

    public void toggleScheduledPollerEnabled() {
        this.scheduledPollerEnabled = !this.scheduledPollerEnabled;
    }

    public void toggleRestApiEnabled() {
        this.restApiEnabled = !this.restApiEnabled;
    }
}
