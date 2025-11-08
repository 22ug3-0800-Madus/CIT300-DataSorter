
public class SortResult {
    public final int[] sorted;
    public final long timeNs;
    public final long steps;

    public SortResult(int[] sorted, long timeNs, long steps) {
        this.sorted = sorted;
        this.timeNs = timeNs;
        this.steps = steps;
    }

    public double timeMs() {
        return timeNs / 1_000_000.0;
    }
}
