package io.hultqvist.simplebdd.specifcation;

import static io.hultqvist.simplebdd.utils.Guards.notNull;

import io.hultqvist.simplebdd.api.annotations.Given;
import io.hultqvist.simplebdd.api.annotations.Then;
import io.hultqvist.simplebdd.api.annotations.When;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class SpecificationExtractor {

    /**
     * Extract a specification based on @Given/@When/@Then annotations in target class
     * @param klass Target test class which contains @Given/@When/@Then annotated methods
     * @return Specification containing sorted Given/When/Then methods
     */
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
