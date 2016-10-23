package io.hultqvist.simplebdd.utils;

import java.util.Collection;

public class Guards {

    public static void notNull(final Object object, final String message) {
        if (object == null) {
            throw new NullPointerException(message);
        }
    }

    public static void notEmpty(final Collection collection, final String message) {
        if (collection.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }
}
