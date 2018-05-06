package com.test.algo;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//InvocationHandler==Dynamic implementation interface
public class Utils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static int closestToZero(int[] ints) {
	    int num = ints[0];
	    int absNum = Math.abs(num);
	    for(int i = 1; i < ints.length; ++i) {
	        int newAbs = Math.abs(ints[i]);
	        if(newAbs < absNum) {
	            absNum = newAbs;
	            num = ints[i];
	        }
	    }
	    return num;
	}
	 /**
     * Checks that the given string is​​​​​​​‌​‌​​‌‌‌‌​​‌‌​​​‌‌‌‌‌​‌​ correct.
     */
	static boolean check(String str) {
	if (str.isEmpty())
        return true;
    Stack<Character> stack = new Stack<Character>();
    for (int i = 0; i < str.length(); i++)
    {
        char current = str.charAt(i);
        if (current == '{' || current == '(' || current == '[')
        {
            stack.push(current);
        }
        if (current == '}' || current == ')' || current == ']')
        {
            if (stack.isEmpty())
                return false;
            char last = stack.peek();
            if (current == '}' && last == '{' || current == ')' && last == '(' || current == ']' && last == '[')
                stack.pop();
            else 
                return false;
        }
    }
    return stack.isEmpty();	
	}
	 /** @return the largest number of the given​​​​​​​‌​‌​‌​​​​​​‌​‌‌‌‌​​‌‌‌‌‌ array */
	static int findLargest(int[] numbers) {
	int lg=numbers[0];
    	if(numbers.length==1){
    	    return numbers[0];
    	}else{
    	    int i=0;
    	    while(i<numbers.length){
    	        if(numbers[i]>lg){
    	            lg=numbers[i];
    	        }i++;
    	    }
    	}
	return lg;	
	}
	//Calcul du pi
	double Euler_D(int n) { // factorisé
	  double pi=0.0;
	   for (int i=n-1; i>0; --i) pi = 2.0 + pi*i/(2*i+1);
	  return pi;
	} // Pi = 2 + (1/3)*(2 + (2/5)*(2 + (3/7)*(2 + (4/9)*(2 + (5/11)*(2 + ...)))))
	
	//checks whether an int is prime or not.
	boolean isPrime(int n) {
	    //check if n is a multiple of 2
	    if (n%2==0) return false;
	    //if not, then just check the odds
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
	public static void magicStone(String[] args) { 
        int n = Integer.parseInt(args[0]);
        if (n % 2 == 0) throw new RuntimeException("n must be odd");

        int[][] magic = new int[n][n];

        int row = n-1;
        int col = n/2;
        magic[row][col] = 1;

        for (int i = 2; i <= n*n; i++) {
            if (magic[(row + 1) % n][(col + 1) % n] == 0) {
                row = (row + 1) % n;
                col = (col + 1) % n;
            }
            else {
                row = (row - 1 + n) % n;
                // don't change col
            }
            magic[row][col] = i;
        }

        // print results
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (magic[i][j] < 10)  System.out.print(" ");  // for alignment
                if (magic[i][j] < 100) System.out.print(" ");  // for alignment
                System.out.print(magic[i][j] + " ");
            }
            System.out.println();
        }

    }
}
//if(i+j==1 || i==1 || j==1){
// return true;	
//}
 
