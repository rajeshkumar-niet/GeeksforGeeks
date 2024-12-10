//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.findPermutation(S);
            for (int i = 0; i < ans.size(); i++) {
                out.print(ans.get(i) + " ");
            }
            out.println();

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    
    public void find(String s,TreeSet<String> result,String a){
        
        if(s.length()==0){
            result.add(a);
            return;
        }
        
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            String newString=s.substring(0,i)+s.substring(i+1);
            find(newString,result,a+ch);
    
        }
    }
    
    public List<String> findPermutation(String s) {
        // Code here
        TreeSet<String> result=new TreeSet<>();
        find(s,result,"");
        return new ArrayList<>(result);
        
    }
}