package io.hultqvist.simplebdd.api.annotations;

import java.lang.annotation.*;

/**
 * This annotation should be used for the active part <b>Then</b> in the Gherkin format Given-When-Then.
 * Methods annotated with <b>@Then</b> will run after <b>@Given</b> and after <b>@When</b>
 *
 * @author Daniel Hultqvist
 * @since 1.0
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Then {
    String value();

    int priority() default Integer.MAX_VALUE;
}
