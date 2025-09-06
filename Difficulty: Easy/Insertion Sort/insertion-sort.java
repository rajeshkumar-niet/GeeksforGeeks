class Solution {
    // Please change the array in-place
    public void insertionSort(int arr[]) {
        // code here
        int n = arr.length;
		for (int i = 1; i < n; i++) {
			int curr = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > curr) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = curr;
		}
    }
}