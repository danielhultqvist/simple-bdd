package io.hultqvist.simplebdd.integration.junit4;

import static io.hultqvist.simplebdd.utils.Guards.notNull;

import io.hultqvist.simplebdd.specifcation.Specification;
import io.hultqvist.simplebdd.specifcation.SpecificationExecutor;
import java.lang.reflect.Method;
import org.junit.runners.model.FrameworkMethod;

class SimpleBDDFrameworkMethod extends FrameworkMethod {

    private final Specification specification;

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
}
