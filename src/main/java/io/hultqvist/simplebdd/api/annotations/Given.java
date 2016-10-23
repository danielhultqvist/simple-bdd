package io.hultqvist.simplebdd.api.annotations;

import java.lang.annotation.*;

/**
 * This annotation should be used for the active part <b>When</b> in the Gherkin format Given-When-Then.
 * Methods annotated with <b>@Given</b> will run before <b>@When</b> and before <b>@Then</b>
 *
 * @author Daniel Hultqvist
 * @since 1.0
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Given {
    String value();

    int priority() default 0;
}
