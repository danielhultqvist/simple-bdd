package io.hultqvist.simplebdd.specifcation;

import static io.hultqvist.simplebdd.utils.Guards.notEmpty;

import io.hultqvist.simplebdd.api.annotations.Given;
import io.hultqvist.simplebdd.api.annotations.Then;
import io.hultqvist.simplebdd.api.annotations.When;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Specification {
    public final List<Method> givens;
    public final List<Method> whens;
    public final List<Method> thens;

    public Specification(final List<Method> givens,
                         final List<Method> whens,
                         final List<Method> thens) {
        notEmpty(givens, "Test is missing given methods");
        notEmpty(whens, "Test is missing when methods");
        notEmpty(thens, "Test is missing then methods");

        this.givens = sort(givens, givenSorter());
        this.whens = sort(whens, whenSorter());
        this.thens = sort(thens, thenSorter());
    }

    private List<Method> sort(final List<Method> unsortedMethods, final Comparator<Method> methodComparator) {
        final List<Method> methods = new ArrayList<Method>(unsortedMethods);
        Collections.sort(methods, methodComparator);
        return Collections.unmodifiableList(methods);
    }

    private Comparator<Method> givenSorter() {
        return new Comparator<Method>() {
            public int compare(final Method o1, final Method o2) {
                return Double.compare(o1.getAnnotation(Given.class).priority(),
                                      o2.getAnnotation(Given.class).priority());
            }
        };
    }

    private Comparator<Method> whenSorter() {
        return new Comparator<Method>() {
            public int compare(final Method o1, final Method o2) {
                return Double.compare(o1.getAnnotation(When.class).priority(),
                                      o2.getAnnotation(When.class).priority());
            }
        };
    }

    private Comparator<Method> thenSorter() {
        return new Comparator<Method>() {
            public int compare(final Method o1, final Method o2) {
                return Double.compare(o1.getAnnotation(Then.class).priority(),
                                      o2.getAnnotation(Then.class).priority());
            }
        };
    }
}
