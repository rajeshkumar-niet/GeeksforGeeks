class Solution {
    public int findMin(int[] arr) {
        // complete the function here
        int result = arr[0];
        for(int i= 0; i < arr.length - 1; i++){
            if(arr[i] > arr[i+1]){
                result = arr[i + 1];
                break;
            }
        }
        return result;
    }
}
