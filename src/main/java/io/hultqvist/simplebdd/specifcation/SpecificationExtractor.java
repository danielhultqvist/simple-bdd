package io.hultqvist.simplebdd.specifcation;

import io.hultqvist.simplebdd.api.annotations.Given;
import io.hultqvist.simplebdd.api.annotations.Then;
import io.hultqvist.simplebdd.api.annotations.When;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static io.hultqvist.simplebdd.utils.Guards.notNull;

public class SpecificationExtractor {

    public static Specification createSpecification(final Class klass) {
        notNull(klass, "Class cannot be null");

        final List<Method> givens = extractMethodsWithAnnotation(klass.getMethods(), Given.class);
        final List<Method> whens = extractMethodsWithAnnotation(klass.getMethods(), When.class);
        final List<Method> thens = extractMethodsWithAnnotation(klass.getMethods(), Then.class);
        return new Specification(givens, whens, thens);
    }

    private static List<Method> extractMethodsWithAnnotation(final Method[] methods,
                                                             final Class annotation) {
        final List<Method> matchingMethods = new ArrayList<Method>();
        for (Method method : methods) {
            if (method.isAnnotationPresent(annotation)) {
                matchingMethods.add(method);
            }
        }
        return matchingMethods;
    }
}
