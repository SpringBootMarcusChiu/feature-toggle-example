package com.marcuschiu.Feature.Toggle.Example.feature.toggle.annotation;

import com.marcuschiu.Feature.Toggle.Example.feature.toggle.FeatureService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class FeatureToggleAspect {

    @Autowired
    FeatureService featureService;

    @Around("@annotation(FeatureToggle)")
    public Object featureToggle(ProceedingJoinPoint joinPoint) throws Throwable {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        FeatureToggle ft = method.getAnnotation(FeatureToggle.class);
        Boolean isEnabled = (Boolean)featureService.get(ft.value());

        if (isEnabled) {
            return joinPoint.proceed();
        } else {
            return null;
        }
    }
}
