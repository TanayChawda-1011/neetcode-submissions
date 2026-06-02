class Solution {
    public int[] replaceElements(int[] arr) {
        int curMax = arr[arr.length - 1];
        int rightVal = -1;

        // 2 4 5 3 1 2
        // 2 4 5 2 2 2

        for(int i = arr.length - 2; i >= 0; i--) {
            curMax = Math.max(curMax, rightVal);
            rightVal = arr[i];
            arr[i] = curMax;
        }

        arr[arr.length - 1] = -1;
        return arr;
    }
}