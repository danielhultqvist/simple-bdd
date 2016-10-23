package io.hultqvist.simplebdd.specifcation;

import io.hultqvist.simplebdd.utils.Guards;

import java.lang.reflect.Method;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class Specification {
    public final List<Method> givens;
    public final List<Method> whens;
    public final List<Method> thens;

    public Specification(final List<Method> givens,
                         final List<Method> whens,
                         final List<Method> thens) {
        this.givens = unmodifiableList(givens);
        this.whens = unmodifiableList(whens);
        this.thens = unmodifiableList(thens);

        Guards.notEmpty(givens, "Test is missing given methods");
        Guards.notEmpty(whens, "Test is missing when methods");
        Guards.notEmpty(thens, "Test is missing then methods");
    }
}
