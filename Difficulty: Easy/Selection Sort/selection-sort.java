class Solution {
    void selectionSort(int[] arr) {
        // code here
        int n = arr.length;
		for (int i = 0; i < n; i++) {
			int smallestIndex = i;
			for (int j = i; j < n; j++) {
				if (arr[j] < arr[smallestIndex]) {
					smallestIndex = j;
				}
			}
			int temp = arr[smallestIndex];
			arr[smallestIndex] = arr[i];
			arr[i] = temp;
		}
    }
}