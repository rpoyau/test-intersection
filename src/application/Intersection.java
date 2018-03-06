package application;

import java.util.Collection;

@FunctionalInterface
public interface Intersection<T> {
    
    /**
     * @param a
     * @param b
     * @return collection which contains intersection between a and b
     */
    public Collection<T> intersection(final Collection<T> a, final Collection<T> b);

}
