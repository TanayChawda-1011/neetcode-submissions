class Solution {
    public int maxTurbulenceSize(int[] arr) {
        String prev = "";
        int l = 0;
        int length = 1;

        for(int r = 1; r < arr.length; r++) {
            if(arr[r - 1] > arr[r] && !">".equals(prev)) {
                length = Math.max(length, r - l + 1);
                prev = ">";
            } else if(arr[r - 1] < arr[r] && !"<".equals(prev)) {
                length = Math.max(length, r - l + 1);
                prev = "<";
            } else {
                l = arr[r - 1] == arr[r] ? r : r - 1;
            }
        }

        return length;
    }
}