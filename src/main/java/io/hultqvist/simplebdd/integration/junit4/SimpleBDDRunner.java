package io.hultqvist.simplebdd.integration.junit4;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

public class SimpleBDDRunner extends BlockJUnit4ClassRunner {

    private final Class<?> fixtureClass;

    public SimpleBDDRunner(Class<?> fixtureClass) throws InitializationError {
        super(fixtureClass);
        this.fixtureClass = fixtureClass;

        try {
            super.createTest();
        } catch (Exception exception) {
            throw new InitializationError(exception);
        }

        System.out.println("Running Simple BDD Runner");
    }
}
