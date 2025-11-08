
public class MergeSort {

    private static long steps;

    public static SortResult sort(int[] arr) {
        int[] a = arr.clone();
        steps = 0;
        long start = System.nanoTime();
        mergeSort(a, 0, a.length - 1);
        long time = System.nanoTime() - start;
        return new SortResult(a, time, steps);
    }

    private static void mergeSort(int[] a, int l, int r) {
        if (l >= r) return;
        int m = l + (r - l) / 2;
        mergeSort(a, l, m);
        mergeSort(a, m + 1, r);
        merge(a, l, m, r);
    }

    private static void merge(int[] a, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) { L[i] = a[l + i]; steps++; } // copy counts
        for (int j = 0; j < n2; j++) { R[j] = a[m + 1 + j]; steps++; }

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            steps++; // comparison between L[i] and R[j]
            if (L[i] <= R[j]) {
                a[k++] = L[i++];
                steps++; // assignment
            } else {
                a[k++] = R[j++];
                steps++; // assignment
            }
        }
        while (i < n1) {
            a[k++] = L[i++]; steps++;
        }
        while (j < n2) {
            a[k++] = R[j++]; steps++;
        }
    }
}
