package exception_handling;

import java.util.*;

public class ArrayOperations { 

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub b
		Scanner sc=new Scanner(System.in); 
		int [] arr=null;
		try {
            System.out.println("Enter arr length");
            int n = sc.nextInt();
            arr = new int[n]; // Initialize the array after getting the length

            System.out.println("Enter index to retrieve (first attempt):");
            int idx1 = sc.nextInt();

            if (arr == null) { // Correct way to check if the array is null
                throw new NullPointerException("Array is not initialized!");
            }
            if (idx1 < 0 || idx1 >= arr.length) {
                throw new ArrayIndexOutOfBoundsException("Invalid index!");
            }
            System.out.println("Value at index " + idx1 + " (first attempt): " + arr[idx1]);

            System.out.println("Enter array elements:");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println("Enter index to retrieve (second attempt):");
            int idx2 = sc.nextInt();

            if (arr == null) { 
                throw new NullPointerException("Array is not initialized!");
            }
            if (idx2 < 0 || idx2 >= arr.length) {
                throw new ArrayIndexOutOfBoundsException("Invalid index!");
            }
            System.out.println("Value at index " + idx2 + " (second attempt): " + arr[idx2]);

        } catch (NullPointerException e) {
            System.err.println("Array is not initialized! " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Invalid index! " + e.getMessage());
        } finally {
            sc.close();
        }
		

	}

}
