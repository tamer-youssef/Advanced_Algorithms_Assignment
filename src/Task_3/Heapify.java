package Task_3;

public class Heapify {
    public static void heapify(int arr[], int n, int root)
    {
        int max = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;
        int temp;
  
        if (left < n && arr[left] > arr[max])
        	max = left;

        if (right < n && arr[right] > arr[max])
        	max = right;

        if (max != root)
        {
            temp = arr[root];
            arr[root] = arr[max];
            arr[max] = temp;
  
            heapify(arr, n, max);
        }
    }
}

