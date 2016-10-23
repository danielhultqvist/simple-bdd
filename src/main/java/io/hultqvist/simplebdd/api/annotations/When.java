package io.hultqvist.simplebdd.api.annotations;

import java.lang.annotation.*;

/**
 * This annotation should be used for the active part <b>when</b> in the Gherkin format Given-When-Then.
 * Methods annotated with <b>@When</b> will run after <b>@Given</b> and before <b>@Then</b>
 *
 * @author Daniel Hultqvist
 * @since 1.0
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface When {
    String value();

    int priority() default Integer.MAX_VALUE;
}
