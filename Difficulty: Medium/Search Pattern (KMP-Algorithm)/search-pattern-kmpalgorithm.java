//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s, patt;
            s = sc.next();
            patt = sc.next();

            Solution ob = new Solution();

            ArrayList<Integer> res = ob.search(patt, s);
            if (res.size() == 0)
                System.out.print("[]");
            else {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    public static int[] prefixFunction(String s) {
        int[] lps = new int[s.length()];
        int j = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j))
                j = lps[j - 1];

            if (s.charAt(i) == s.charAt(j)) 
                j++;

            lps[i] = j;
        }
        return lps;
    }
    
    ArrayList<Integer> search(String pat, String txt) {
        // your code here
        ArrayList<Integer> list = new ArrayList<>();
        int[] lps = prefixFunction(pat);

        int i = 0;
        int j = 0;
        while (i < txt.length()) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            } else {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }

            if (j == pat.length()) {
                list.add(i - j);
                j = lps[j - 1];
            }
        }
        return list;
    }
}