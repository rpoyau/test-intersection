package application;

import java.time.Duration;
import java.time.Instant;
import java.util.Collection;
import java.util.function.IntFunction;

public class IntersectionTester<T> {

    private int aSize;
    private int bSize;

    private Boolean hashListA = Boolean.FALSE;

    private IntFunction<Collection<T>> generateCollection;

    private Intersection<T> intersection;

    public int getaSize() {
        return aSize;
    }

    public void setaSize(int aSize) {
        this.aSize = aSize;
    }

    public int getbSize() {
        return bSize;
    }

    public void setbSize(int bSize) {
        this.bSize = bSize;
    }

    public IntFunction<Collection<T>> getGenerateCollection() {
        return generateCollection;
    }

    public void setGenerateCollection(final IntFunction<Collection<T>> generateCollection) {
        this.generateCollection = generateCollection;
    }

    public Intersection<T> getIntersection() {
        return intersection;
    }

    public void setIntersection(final Intersection<T> intersection) {
        this.intersection = intersection;
    }

    public IntersectionTestResult run() {
        Collection<T> listToHash = null;
        Collection<T> listToIterateOVer = null;

        if (hashListA) {
            listToHash = generateCollection.apply(getaSize());
            listToIterateOVer = generateCollection.apply(getbSize());
        } else {
            listToHash = generateCollection.apply(getbSize());
            listToIterateOVer = generateCollection.apply(getaSize());
        }

        final Instant start = Instant.now();
        final Collection<T> intersected = intersection.intersection(listToHash, listToIterateOVer);
        final Instant end = Instant.now();
        final long duration = Duration.between(start, end).toNanos();

        return new IntersectionTestResult(duration, intersected.size());

    }

    public Boolean getHashListA() {
        return hashListA;
    }

    public void setHashListA(Boolean hashListA) {
        this.hashListA = hashListA;
    }

}
