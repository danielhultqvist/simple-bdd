package io.hultqvist.simplebdd.specifcation;

import io.hultqvist.simplebdd.api.annotations.Given;
import io.hultqvist.simplebdd.api.annotations.Then;
import io.hultqvist.simplebdd.api.annotations.When;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SpecificationExtractorTest {

    @Test
    public void should_extract_given() {
        final Specification specification = SpecificationExtractor.createSpecification(ExampleTest.class);

        assertEquals(1, specification.givens.size());
        assertTrue(specification.givens.get(0).isAnnotationPresent(Given.class));
    }

    @Test
    public void should_extract_when() {
        final Specification specification = SpecificationExtractor.createSpecification(ExampleTest.class);

        assertEquals(1, specification.whens.size());
        assertTrue(specification.whens.get(0).isAnnotationPresent(When.class));
    }

    @Test
    public void should_extract_then() {
        final Specification specification = SpecificationExtractor.createSpecification(ExampleTest.class);

        assertEquals(1, specification.thens.size());
        assertTrue(specification.thens.get(0).isAnnotationPresent(Then.class));
    }

    private static class ExampleTest {
        @Given("Given some fixtures")
        public void given_some_fixtures() {
        }

        @When("When doing something")
        public void when_doing_something() {
        }

        @Then("Then something is asserted")
        public void then_something_is_asserted() {
        }
    }
}