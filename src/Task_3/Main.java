package Task_3;
import java.util.Scanner;
// nlog(n)
public class Main {
	public static void main(String[] args) {
		
		// taking user input
		System.out.println("How many numbers are in your array?"); 
		
		Scanner sc = new Scanner(System.in);  
		int[] arr = new int[sc.nextInt()];
		
		int n = arr.length;
		sc.nextLine();
		
		System.out.println("\nEnter the numbers in, separated by pressing Enter:"); 
		
		for (int i = 0; i < arr.length; i++) {  
			arr[i] = sc.nextInt();
		}
        
        // sorting the user input 
        ArraySorter S1 = new ArraySorter();
        S1.sort(arr);
  
        System.out.println("\nSorted array: ");
        
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
        sc.close();
	}
}
