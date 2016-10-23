package io.hultqvist.simplebdd.integration.junit4;

import static io.hultqvist.simplebdd.specifcation.SpecificationExtractor.createSpecification;

import io.hultqvist.simplebdd.specifcation.Specification;
import java.util.ArrayList;
import java.util.List;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

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
    @Deprecated
    protected void validateInstanceMethods(List<Throwable> errors) {
        // Ignore missing @Test annotated methods, we don't need that.
    }
}
