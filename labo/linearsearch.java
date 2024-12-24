import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements:");
        int n = sc.nextInt();
        System.out.println("Enter the " + n + " elements:");
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        System.out.println("Enter the element to search:");
        int key = sc.nextInt();
        int result = linearSearch(A, key);
        if (result == -1) {
            System.out.println("Element not found.");
        } else {
            System.out.println("Element found at index " + result + ".");
        }
    }

    static int linearSearch(int[] A, int key) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
