package io.hultqvist.simplebdd.integration.junit4;

/**
 * This class is used to give the name to the test child being run by JUnit.
 * The method below will determine the name, and must be matched in
 * {@link io.hultqvist.simplebdd.integration.junit4.SimpleBDDRunner#SimpleBDDRunner(Class)}
 */
class NoopMethod {
    @SuppressWarnings("WeakerAccess")
    public void scenario() {
    }
}
