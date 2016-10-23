package io.hultqvist.simplebdd.specifcation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static io.hultqvist.simplebdd.utils.Guards.notNull;

public class SpecificationExecutor {

    public void execute(final Object testInstance, final Specification specification) throws Throwable {
        notNull(testInstance, "Test instance cannot be null");
        notNull(specification, "Specification cannot be null");

        try {
            for (Method given : specification.givens) {
                // already sorted according to priority?
                given.invoke(testInstance);
            }

            for (Method when : specification.whens) {
                // already sorted according to priority?
                when.invoke(testInstance);
            }

            for (Method then : specification.thens) {
                // already sorted according to priority?
                then.invoke(testInstance);
            }
        } catch (InvocationTargetException exception) {
            throw exception.getCause();
        }
    }
}
