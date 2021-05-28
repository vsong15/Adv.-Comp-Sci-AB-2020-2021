

import java.util.*;
import java.lang.*;

public class PrimeNumberCalculator{
 
   static int max = 100005;
 
   static Vector<Integer> primeNumber = new Vector<>();
 
   static void sieveOfEratosthenes()
   {
   
      // Create a boolean array "prime[0..n]" and
      // initialize all entries it as true. A value
      // in prime[i] will finally be false if i is
      // Not a prime, else true.
      boolean prime[] = new boolean[max + 1];
      for (int i = 0; i <= max; i++)
         prime[i] = true;
   
      for (int p = 2; p * p <= max; p++) {
      
         // If prime[p] is not changed, then it is a
         // prime
         if (prime[p] == true) {
         
            // Update all multiples of p
            for (int i = p * p; i <= max; i += p)
               prime[i] = false;
         }
      }
   
      // Print all prime numbers
      for (int i = 2; i <= max; i++) {
      
         if (prime[i] == true)
            primeNumber.add(i);
      }
   }
 
   static int upper_bound(Integer arr[], int low, int high,
                          int X)
   {
      // Base Case
      if (low > high)
         return low;
   
      // Find the middle index
      int mid = low + (high - low) / 2;
   
      // If arr[mid] is less than
      // or equal to X search in
      // right subarray
      if (arr[mid] <= X) {
         return upper_bound(arr, mid + 1, high, X);
      }
   
      // If arr[mid] is greater than X
      // then search in left subarray
      return upper_bound(arr, low, mid - 1, X);
   }
 
   public static int closetPrime(int number)
   {
   
      // We will handle it (for number = 1) explicitly
      // as the lower/left number of 1 can give us
      // negative index which will cost Runtime Error.
      if (number == 1)
         return 2;
      else {
      
         // calling seive of eratosthenes to
         // fill the array into prime numbers
         sieveOfEratosthenes();
      
         Integer[] arr = primeNumber.toArray(
            new Integer[primeNumber.size()]);
         // searching the index
         int index
            = upper_bound(arr, 0, arr.length, number);
      
         if (arr[index] == number
            || arr[index - 1] == number)
            return number;
         else if (Math.abs(arr[index] - number)
                 < Math.abs(arr[index - 1] - number))
            return arr[index];
         else
            return arr[index - 1];
      }
   }
}




