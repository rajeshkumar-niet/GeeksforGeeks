
class Solution {
    
    public int binarysearch(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;
        int result = -1; 
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == k) {
                result = mid; 
                end = mid - 1; 
            } else if (arr[mid] > k) {
                end = mid - 1; 
            } else {
                start = mid + 1; 
            }
        }

        return result; 
    }
    
    int countFreq(int[] arr, int target) {
        // code here
        int found = binarysearch(arr, target);
        if(found == -1){
            return 0;
        } else{
            int count = 0;
            while(arr[found] == target && found < arr.length-1){
                found ++;
                count ++;
            }
            if(arr[arr.length -1]== target) count++;
            return count;
        }
        
    }
}
