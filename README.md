# simple-bdd

#### TL;DR
Java BDD test framework with **3** required annotations only + runner, **no** additional text/html/md files needed whatsoever.
Runs on JUnit 4 and >= Java 6.

#### Why (short, long at end)
Keep everything about your scenario in one place - your source code. Easy to maintain, no magic and still fulfills most use cases.
Do you really need all that fancy advanced support/features that other frameworks provides?

#### What/How
This library consists of **3** required annotations and a test runner. The three annotations represents the Gherkin annotation
* `@Given`
* `@When`
* `@Then`

These annotations are put on your test methods and will be executed by the simple-bdd runner. The test class is annotated `@RunWith(SimpleBDDRunner.class)` which executes the methods in the correct order.

#### Example
Clone repository and run (this is needed until available on Maven Central)
```sh
./mvnw install
```

In your project where you want to use simple-bdd, add the dependency
```xml
<dependency>
	<groupId>io.hultqvist</groupId>
	<artifactId>simple-bdd</artifactId>
	<version>1.0-SNAPSHOT</version>
	<scope>test</scope>
</dependency>
```

Create a test with the required annotations (below). It is possible to have multiple of each of annotation (@Given/@When/@Then). The run order is always Given -> When -> Then. If ordering is required between multiple of the same type, it is possible to add the optional priority value, where lower goes first.
```java
@RunWith(SimpleBDDRunner.class)
public class CheckoutBasketScenario_1 {

  @Given("Given two products with price $10")
  public void given() {
    ...
  }

  @When("When calculating total amount")
  public void when() {
    ...
  }

  @Then("Then the total price is $20")
  public void then() {
    assertEquals(...);
  }
}
```
The test result is completely assert (i.e. exception) based, all methods should return void (it does not matter if it returns something, but it wont be used). The test is now executable and can be run by Maven (`./mvwn verify`) or be your editor.

#### Why (long version)
Modern projects often utilize behaviour driven design (BDD), a test practise where the business creates the tests together with the developers. 
There are several available Java frameworks that supports these types of tests, for example:
* *Concordion*
* *JBehave*
* *Cucumber*
* *etc.*

For most frameworks, the tests consists of *at least* two parts, a fixture/description file (html/md/txt...) and Java source file.
The description file contains the actual scenario written in text. The contents of the file is then mapped to the Java source
code file which runs the test.
 
In practise, this can be overkill. Quite often, you write the scenario on a piece of paper with your business analyst, put in code and receive a generated report file which serves as live documention. So is all that advanced support unnecessary? Do you want to keep everything in code, and also keep it really simple? If you think so, this might be the right micro bdd framework for you.