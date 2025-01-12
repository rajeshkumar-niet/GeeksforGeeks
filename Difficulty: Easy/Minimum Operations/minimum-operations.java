//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperation(n));
                
System.out.println("~");
}
        }
}    
// } Driver Code Ends


//User function Template for Java


class Solution
{
    static int solve(int n, int x){
        if(n == 0){
            return x;
        }
        if(n%2==0){
            n /= 2;
        }else{
            n -= 1;
        }
        return solve(n, x+1);
    }
    public int minOperation(int n)
    {
        if( n <= 1) return n;
        //code here.
        return solve(n, 0) ;
          
    }
}