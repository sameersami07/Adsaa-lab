import java.util.Arrays;
public class quicksorttime{
    public static void quicksort(int[] arr,int low,int high){
        if(low<high){
            int pivotindex=partition(arr,low,high);
            quicksort(arr,low,pivotindex-1);
            quicksort(arr,pivotindex+1,high);
        }
    }
    private static int partition(int[] arr,int low,int high){
        int pivot=arr[high];
        int i=low-1;
        for(int j=low;j<high;j++){
            if(arr[j]<pivot){
                i++;
                swap(arr,i,j);
            }
            
        }
        swap(arr,i+1,high);
            return i+1;
    }
    private static void swap(int [] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    private static long measuretime(int[] arr){
        long starttime=System.nanoTime();
        quicksort(arr, 0, arr.length-1);
        long endtime=System.nanoTime();
        return(endtime-starttime);

    }
    public static void main(String[] args){
        int[] arr={4,3,2,1};
        System.out.println("Original Array: " + Arrays.toString(arr));
        long timetaken=measuretime(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
        System.out.println("Execution Time: " + timetaken + " nanoseconds");

    }
}   
