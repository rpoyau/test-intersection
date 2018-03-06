package application;

import java.util.concurrent.TimeUnit;

public class IntersectionTestResult {
    
    private long duration;
    private int size;
    public IntersectionTestResult(final long duration, final int size) {
        super();
        this.duration = duration;
        this.size = size;
    }
    
    public String getFormattedDuration() {
        if (duration < 1000) {
            return String.format("%dns", duration);
        } else if (duration < 1000000) {
            return String.format("%dμs", TimeUnit.NANOSECONDS.toMicros(duration));
        } else {
            return String.format("%dms", TimeUnit.NANOSECONDS.toMillis(duration));
        }
    }

    public long getDuration() {
        return duration;
    }

    public int getSize() {
        return size;
    }
}
