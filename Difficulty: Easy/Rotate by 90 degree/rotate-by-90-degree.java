//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int matrix[][] = new int[n][n];
            // String st[] = read.readLine().trim().split("\\s+");
            int k = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ob.rotateby90(matrix);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) System.out.print(matrix[i][j] + " ");
                System.out.println();
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    static void transpose(int mat[][]) {
        int t;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < i; j++) {
                t = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = t;
            }
        }
    }

    static void swaprows(int mat[][], int i, int j) {
        int[] row = mat[i];
        mat[i] = mat[j];
        mat[j] = row;
    }

    static void rotateby90(int mat[][]) {
        // code here
        transpose(mat);
        int i = 0;
        int j = mat.length - 1;
        while (i < j) {
            swaprows(mat, i, j);
            i++;
            j--;
        }
    }
}