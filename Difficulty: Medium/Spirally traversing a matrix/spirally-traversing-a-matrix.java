//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int matrix[][] = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Solution {
    public ArrayList<Integer> spirallyTraverse(int mat[][]) {
        int top = 0, left = 0;
        int down = mat.length - 1, right = mat[0].length - 1;
        ArrayList<Integer> list = new ArrayList<>();

        while (top <= down && left <= right) {
            // Traverse left to right
            for (int i = left; i <= right; i++) {
                list.add(mat[top][i]);
            }
            top++;

            // Traverse top to down
            for (int i = top; i <= down; i++) {
                list.add(mat[i][right]);
            }
            right--;

            // Traverse right to left (if valid)
            if (top <= down) {
                for (int i = right; i >= left; i--) {
                    list.add(mat[down][i]);
                }
                down--;
            }

            // Traverse down to top (if valid)
            if (left <= right) {
                for (int i = down; i >= top; i--) {
                    list.add(mat[i][left]);
                }
                left++;
            }
        }

        return list;
    }
}
