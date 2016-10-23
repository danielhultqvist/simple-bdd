package io.hultqvist.simplebdd.integration.junit4;

import io.hultqvist.simplebdd.api.annotations.Given;
import io.hultqvist.simplebdd.api.annotations.Then;
import io.hultqvist.simplebdd.api.annotations.When;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/*
  Look at EventIntegrationTest to see in order
 */
@RunWith(SimpleBDDRunner.class)
public class ExecutionIntegrationOutOfOrderTest {

    private List<String> executions = new ArrayList<String>();

    @Then("Then something is asserted")
    public void then_something_is_asserted() {
        assertEquals(3, executions.size());
        executions.add("THEN");
    }

    @Before
    public void before() {
        assertEquals(0, executions.size());
        executions.add("BEFORE");
    }

    @When("When doing something")
    public void when_doing_something() {
        assertEquals(2, executions.size());
        executions.add("WHEN");
    }

    @After
    public void after() {
        assertEquals(4, executions.size());
    }

    @Given("Given some fixtures")
    public void given_some_fixtures() {
        assertEquals(1, executions.size());
        executions.add("GIVEN");
    }
}
