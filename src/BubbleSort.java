public class BubbleSort {

    public static SortResult sort(int[] arr) {
        int[] a = arr.clone();
        int n = a.length;
        long steps = 0;
        long start = System.nanoTime();

        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                steps++; 
                if (a[j] > a[j + 1]) {
                    // swap
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    steps += 3;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }

        long time = System.nanoTime() - start;
        return new SortResult(a, time, steps);
    }
}public class BubbleSort {
    
}
