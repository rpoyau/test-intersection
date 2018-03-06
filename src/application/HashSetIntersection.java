package application;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class HashSetIntersection<T> implements Intersection<T> {

    /* (non-Javadoc)
     * @see application.Intersection#intersection(java.util.Collection, java.util.Collection)
     */
    @Override
    public Collection<T> intersection(final Collection<T> a, final Collection<T> b) {
        final Collection<T> result = new ArrayList<T>();
        final HashSet<T> seen = new HashSet<T>(a);

        for (T item : b) {
            if (seen.contains(item)) {
                result.add(item);
            }
        }
        return result;
    }

}
