package io.hultqvist.simplebdd.specifcation;

import static io.hultqvist.simplebdd.utils.Guards.notNull;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SpecificationExecutor {

    public void execute(final Object testInstance, final Specification specification) throws Throwable {
        notNull(testInstance, "Test instance cannot be null");
        notNull(specification, "Specification cannot be null");

        try {
            for (Method given : specification.givens) {
                given.invoke(testInstance);
            }

            for (Method when : specification.whens) {
                when.invoke(testInstance);
            }

            for (Method then : specification.thens) {
                then.invoke(testInstance);
            }
        } catch (InvocationTargetException exception) {
            throw exception.getCause();
        }
    }
}
