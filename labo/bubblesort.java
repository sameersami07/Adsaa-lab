import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        // Create Scanner object for user input
        Scanner sc = new Scanner(System.in);
        
        // Ask for the number of elements in the array
        System.out.println("Enter the number of elements:");
        int n = sc.nextInt();
        
        // Initialize the array
        System.out.println("Enter the " + n + " elements:");
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        
        // Call the bubbleSort function to sort the array
        bubbleSort(A);
        
        // Print the sorted array
        System.out.println("Sorted array:");
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
    }

    // Optimized Bubble Sort method with early exit if no swaps are made
    static void bubbleSort(int[] A) {
        int n = A.length;
        
        // Outer loop for multiple passes
        for (int i = 0; i <= n - 2; i++) {
            boolean swapped = false;
            
            // Inner loop for comparing adjacent elements
            for (int j = 0; j <= n - 2 - i; j++) {
                // Swap if the current element is greater than the next element
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                    swapped = true; // Set swapped flag to true when a swap occurs
                }
            }
            
            // If no elements were swapped in the inner loop, the array is already sorted
            if (!swapped) {
                break;
            }
        }
    }
}
