package closestMinMax;

import java.util.Scanner;

public class ClosestMinMax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int size = scanner.nextInt();
        int array[] = new int[size];
        System.out.println("Enter Elements of Array");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();

        // MinMax(array, size, max, min);
        closest(array, size);

    }

    public static void closest(int array[], int size) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        int latestMinIndex = -1;
        int latestMaxIndex = -1;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            if (array[i] == min) {
                latestMinIndex = i;
                if (latestMaxIndex >= 0) {
                    result = Math.min(result, i - latestMaxIndex + 1);
                }
            }
            if (array[i] == max) {
                latestMaxIndex = i;
                if (latestMinIndex >= 0) {
                    result = Math.min(result, i - latestMinIndex + 1);
                }
            }
        }
        // System.out.print(min + " " + max);
        // System.out.println();
        System.out.println(result);
    }
}
