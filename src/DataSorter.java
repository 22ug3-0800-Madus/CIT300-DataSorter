
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DataSorter {

    private static int[] currentData = new int[0];
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            printMenu();
            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1: enterNumbersManually(); break;
                case 2: generateRandomNumbers(); break;
                case 3: performBubble(); break;
                case 4: performMerge(); break;
                case 5: performQuick(); break;
                case 6: compareAll(); break;
                case 7: exit = true; System.out.println("Exiting. Goodbye!"); break;
                default: System.out.println("Invalid choice. Try again.");
            }
            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println("--- Data Sorter: Sorting Algorithm Comparison Tool ---");
        System.out.println("1. Enter numbers manually");
        System.out.println("2. Generate random numbers");
        System.out.println("3. Perform Bubble Sort");
        System.out.println("4. Perform Merge Sort");
        System.out.println("5. Perform Quick Sort");
        System.out.println("6. Compare all algorithms (show performance table)");
        System.out.println("7. Exit");
    }

    private static void enterNumbersManually() {
        System.out.println("Enter numbers separated by spaces (e.g. 5 3 9 1):");
        String line = scanner.nextLine().trim();
        if (line.isEmpty()) {
            System.out.println("No numbers entered.");
            return;
        }
        try {
            String[] parts = line.split("\\s+");
            int[] arr = new int[parts.length];
            for (int i = 0; i < parts.length; i++) arr[i] = Integer.parseInt(parts[i]);
            currentData = arr;
            System.out.println("Data saved: " + Arrays.toString(currentData));
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter integers separated by spaces.");
        }
    }

    private static void generateRandomNumbers() {
        int n = readInt("How many numbers to generate? ");
        if (n <= 0) {
            System.out.println("Number must be positive.");
            return;
        }
        int min = readInt("Minimum value (inclusive)? ");
        int max = readInt("Maximum value (inclusive)? ");
        if (max < min) {
            System.out.println("Max must be >= min.");
            return;
        }
        Random rnd = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = rnd.nextInt(max - min + 1) + min;
        currentData = arr;
        System.out.println("Random data generated: " + Arrays.toString(currentData));
    }

    private static void performBubble() {
        if (!hasData()) return;
        SortResult res = BubbleSort.sort(currentData);
        System.out.println("Bubble Sort result: " + Arrays.toString(res.sorted));
        System.out.printf("Time: %.4f ms, Steps: %d%n", res.timeMs(), res.steps);
    }

    private static void performMerge() {
        if (!hasData()) return;
        SortResult res = MergeSort.sort(currentData);
        System.out.println("Merge Sort result: " + Arrays.toString(res.sorted));
        System.out.printf("Time: %.4f ms, Steps: %d%n", res.timeMs(), res.steps);
    }

    private static void performQuick() {
        if (!hasData()) return;
        SortResult res = QuickSort.sort(currentData);
        System.out.println("Quick Sort result: " + Arrays.toString(res.sorted));
        System.out.printf("Time: %.4f ms, Steps: %d%n", res.timeMs(), res.steps);
    }

    private static void compareAll() {
        if (!hasData()) return;
        SortResult b = BubbleSort.sort(currentData);
        SortResult m = MergeSort.sort(currentData);
        SortResult q = QuickSort.sort(currentData);

        System.out.println("Comparison table:");
        System.out.printf("%-12s | %-10s | %-12s%n", "Algorithm", "Time (ms)", "Steps");
        System.out.println("-----------------------------------------");
        System.out.printf("%-12s | %-10.4f | %-12d%n", "Bubble", b.timeMs(), b.steps);
        System.out.printf("%-12s | %-10.4f | %-12d%n", "Merge", m.timeMs(), m.steps);
        System.out.printf("%-12s | %-10.4f | %-12d%n", "Quick", q.timeMs(), q.steps);
    }

    private static boolean hasData() {
        if (currentData.length == 0) {
            System.out.println("No data available. Use option 1 or 2 first.");
            return false;
        }
        return true;
    }

    private static int readInt(String prompt) {
        System.out.print(prompt);
        String line = scanner.nextLine();
        while (true) {
            try {
                return Integer.parseInt(line.trim());
            } catch (Exception e) {
                System.out.print("Invalid input. " + prompt);
                line = scanner.nextLine();
            }
        }
    }
}
