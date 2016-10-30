package io.hultqvist.simplebdd.integration.junit4;

import io.hultqvist.simplebdd.specifcation.Specification;
import io.hultqvist.simplebdd.specifcation.SpecificationExecutor;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.FrameworkMethod;

import java.lang.reflect.Method;

import static io.hultqvist.simplebdd.utils.Guards.notNull;

class SimpleBDDFrameworkMethod extends FrameworkMethod {

    private final Specification specification;
    private RunNotifier notifier;

    SimpleBDDFrameworkMethod(final Specification specification) {
        super(noopMethod());
        notNull(specification, "Specification cannot be null");

        this.specification = specification;
    }

    private static Method noopMethod() {
        try {
            return NoopMethod.class.getMethod("scenario");
        } catch (Exception ex) {
            throw new IllegalStateException("Missing method 'method'");
        }
    }

    @Override
    public Object invokeExplosively(final Object target, final Object... params) throws Throwable {
        new SpecificationExecutor().execute(target, specification);
        return null;
    }

    void setNotifier(final RunNotifier notifier) {
        notNull(notifier, "Run notifier cannot be null");

        this.notifier = notifier;
    }
}
