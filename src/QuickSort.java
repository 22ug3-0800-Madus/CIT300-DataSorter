public class QuickSort {

    private static long steps;

    public static SortResult sort(int[] arr) {
        int[] a = arr.clone();
        steps = 0;
        long start = System.nanoTime();
        quickSort(a, 0, a.length - 1);
        long time = System.nanoTime() - start;
        return new SortResult(a, time, steps);
    }

    private static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int p = partition(a, low, high);
            quickSort(a, low, p - 1);
            quickSort(a, p + 1, high);
        }
    }

    private static int partition(int[] a, int low, int high) {
        int pivot = a[high];
        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            steps++;
            if (a[j] <= pivot) {
                i++;
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                steps += 3;
            }
        }
        int tmp = a[i + 1];
        a[i + 1] = a[high];
        a[high] = tmp;
        steps += 3;
        return i + 1;
    }
}