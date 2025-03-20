import java.util.ArrayList;
import java.util.Collections;

public class MinHeap {
    private ArrayList<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    // Insert a value into the heap
    public void add(int val) {
        heap.add(val);
        heapifyUp(heap.size() - 1);
    }

    // Remove a value from the heap
    public void remove(int val) {
        int index = heap.indexOf(val);
        if (index == -1) {
            System.out.println("Element not found: " + val);
            return;
        }
        Collections.swap(heap, index, heap.size() - 1);
        heap.remove(heap.size() - 1);
        if (index < heap.size()) {
            heapifyDown(index);
        }
    }

    // Heapify upwards (restore min-heap after insert)
    private void heapifyUp(int i) {
        int parent = (i - 1) / 2;
        while (i > 0 && heap.get(i) < heap.get(parent)) {
            Collections.swap(heap, i, parent);
            i = parent;
            parent = (i - 1) / 2;
        }
    }

    // Heapify downwards (restore min-heap after removal)
    private void heapifyDown(int i) {
        int left = 2 * i + 1, right = 2 * i + 2, smallest = i;
        if (left < heap.size() && heap.get(left) < heap.get(smallest)) smallest = left;
        if (right < heap.size() && heap.get(right) < heap.get(smallest)) smallest = right;
        if (smallest != i) {
            Collections.swap(heap, i, smallest);
            heapifyDown(smallest);
        }
    }

    // Display heap
    public void show() {
        System.out.println("Heap: " + heap);
    }

    public static void main(String[] args) {
        MinHeap h = new MinHeap();
        int[] values = {10, 20, 15, 40, 50, 100, 25};

        for (int v : values) h.add(v);

        System.out.println("Initial Min Heap:");
        h.show();

        h.remove(15);
        System.out.println("After removing 15:");
        h.show();
    }
}
