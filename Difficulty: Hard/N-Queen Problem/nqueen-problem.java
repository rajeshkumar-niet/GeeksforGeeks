//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public boolean isSafe(int row, int col, int[] board) {
        // Check if row is safe for the queen in column `col`
        for (int prevCol = 0; prevCol < col; prevCol++) {
            int prevRow = board[prevCol];
            // Check if two queens are in the same row or diagonal
            if (prevRow == row || Math.abs(prevRow - row) == Math.abs(prevCol - col)) {
                return false;
            }
        }
        return true;
    }

    public void solveNQueens(int n, int col, int[] board, ArrayList<ArrayList<Integer>> result) {
        // Base case: If all queens are placed
        if (col == n) {
            ArrayList<Integer> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                solution.add(board[i] + 1); // Convert to 1-based index
            }
            result.add(solution);
            return;
        }
        
        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board)) {
                board[col] = row;  // Place queen
                solveNQueens(n, col + 1, board, result);  // Recur for next column
                board[col] = -1;  // Backtrack
            }
        }
    }

    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int[] board = new int[n];  // Array to store row positions of queens (index is column)
        Arrays.fill(board, -1);  // Initialize with -1 (no queen placed)
        solveNQueens(n, 0, board, result);  // Start solving from column 0
        return result;
    }
}