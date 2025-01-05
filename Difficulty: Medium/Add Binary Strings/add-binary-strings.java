//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a, b;
            a = sc.next();
            b = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.addBinary(a, b));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String addBinary(String s1, String s2) {
        // code here
        boolean isCarry = false;
        int n1 = s1.length()-1;
        int n2 = s2.length()-1;
        StringBuilder str =new StringBuilder() ;
        while(n1 >= 0 && n2 >= 0){
            if(isCarry){
                if(s1.charAt(n1)=='0' && s2.charAt(n2) == '0'){
                    str.insert(0, '1');
                    isCarry = false;
                } else if(s1.charAt(n1)=='1' && s2.charAt(n2) == '1'){
                    str.insert(0, '1');
                }else{
                    str.insert(0, '0');
                }
            } else{
                if(s1.charAt(n1)=='0' && s2.charAt(n2) == '0'){
                    str.insert(0, '0');
                } else if(s1.charAt(n1)=='1' && s2.charAt(n2) == '1'){
                    str.insert(0, '0');
                    isCarry = true;
                } else{
                    str.insert(0, '1');
                }
            }
            n1--;
            n2--;
        }
        while(n1>=0){
            if(isCarry){
                if(s1.charAt(n1)=='0'){
                    str.insert(0, '1');
                    isCarry = false;
                }else{
                    str.insert(0, '0');
                }
            }else{
                str.insert(0, s1.charAt(n1));
            }
            n1--;
        }
        while(n2>=0){
            if(isCarry){
                if(s2.charAt(n2)=='0'){
                    str.insert(0, '1');
                    isCarry = false;
                }else{
                    str.insert(0, '0');
                }
            }else{
                str.insert(0, s2.charAt(n2));
            }
            n2--;
        }
        
        if(isCarry){
            str.insert(0, '1');
        }
        
        while(str.charAt(0) == '0'){
            str.delete(0,1);
        }
        
        return str.toString();
    }
}