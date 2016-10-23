package io.hultqvist.simplebdd.specifcation;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import io.hultqvist.simplebdd.api.annotations.Given;
import io.hultqvist.simplebdd.api.annotations.Then;
import io.hultqvist.simplebdd.api.annotations.When;
import org.junit.Test;

public class SpecificationTest {

  @Test
  public void should_sort_givens() {
    final Specification specification = SpecificationExtractor.createSpecification(Givens.class);

    assertThat(specification.givens.size(), is(3));
    assertThat(specification.givens.get(0).getAnnotation(Given.class).priority(), is(1));
    assertThat(specification.givens.get(1).getAnnotation(Given.class).priority(), is(2));
    assertThat(specification.givens.get(2).getAnnotation(Given.class).priority(), is(3));
  }

  @Test
  public void should_sort_whens() {
    final Specification specification = SpecificationExtractor.createSpecification(Whens.class);

    assertThat(specification.whens.size(), is(3));
    assertThat(specification.whens.get(0).getAnnotation(When.class).priority(), is(1));
    assertThat(specification.whens.get(1).getAnnotation(When.class).priority(), is(2));
    assertThat(specification.whens.get(2).getAnnotation(When.class).priority(), is(3));
  }

  @Test
  public void should_sort_thens() {
    final Specification specification = SpecificationExtractor.createSpecification(Thens.class);

    assertThat(specification.thens.size(), is(3));
    assertThat(specification.thens.get(0).getAnnotation(Then.class).priority(), is(1));
    assertThat(specification.thens.get(1).getAnnotation(Then.class).priority(), is(2));
    assertThat(specification.thens.get(2).getAnnotation(Then.class).priority(), is(3));
  }

  private static class Givens {

    @Given(value = "Second", priority = 2)
    public void secondGiven() { }

    @Given(value = "Third", priority = 3)
    public void thirdGiven() { }

    @Given(value = "First", priority = 1)
    public void firstGiven() { }

    @When("dummy")
    public void dummyWhen() { }

    @Then("dummy")
    public void dummyThen() { }
  }

  private static class Whens {

    @Given("dummy")
    public void dummyGiven() { }

    @When(value = "Second", priority = 2)
    public void secondWhen() { }

    @When(value = "Third", priority = 3)
    public void thirdWhen() { }

    @When(value = "First", priority = 1)
    public void firstWhen() { }

    @Then("dummy")
    public void dummyThen() { }
  }

  private static class Thens {

    @Given("dummy")
    public void dummyGiven() { }

    @When("dummy")
    public void dummyWhen() { }

    @Then(value = "Second", priority = 2)
    public void secondWhen() { }

    @Then(value = "Third", priority = 3)
    public void thirdWhen() { }

    @Then(value = "First", priority = 1)
    public void firstWhen() { }
  }
}