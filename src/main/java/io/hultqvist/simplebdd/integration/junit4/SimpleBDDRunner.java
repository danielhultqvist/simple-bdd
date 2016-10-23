package io.hultqvist.simplebdd.integration.junit4;

import io.hultqvist.simplebdd.specifcation.Specification;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

import java.util.ArrayList;
import java.util.List;

import static io.hultqvist.simplebdd.specifcation.SpecificationExtractor.createSpecification;

public class SimpleBDDRunner extends BlockJUnit4ClassRunner {

    private final Specification specification;

    public SimpleBDDRunner(final Class<?> fixtureClass) throws InitializationError {
        super(fixtureClass);

        try {
            Object test = super.createTest();
            specification = createSpecification(test.getClass());
        } catch (Exception exception) {
            throw new InitializationError(exception);
        }
    }

    @Override
    protected List<FrameworkMethod> getChildren() {
        final ArrayList<FrameworkMethod> frameworkMethods = new ArrayList<FrameworkMethod>();
        frameworkMethods.add(new SimpleBDDFrameworkMethod(specification));
        return frameworkMethods;
    }

    @Override
    protected void runChild(final FrameworkMethod method, final RunNotifier notifier) {
        ((SimpleBDDFrameworkMethod) method).setNotifier(notifier);
        super.runChild(method, notifier);
    }

    @Override
    @Deprecated
    protected void validateInstanceMethods(List<Throwable> errors) {
        // Ignore missing @Test annotated methods, we don't need that.
    }
}
