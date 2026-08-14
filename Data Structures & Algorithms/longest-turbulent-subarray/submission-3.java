class Solution {
    public int maxTurbulenceSize(int[] arr) {
        char prev = ' ';
        int l = 0, r = 1;
        int length = 1;

        while(r < arr.length) {
            if(arr[r - 1] > arr[r] && prev != '>') {
                length = Math.max(length, r - l + 1);
                r++;
                prev = '>';
            } else if(arr[r - 1] < arr[r] && prev != '<') {
                length = Math.max(length, r - l + 1);
                r++;
                prev = '<';
            } else {
                r = arr[r - 1] == arr[r] ? r + 1 : r;
                l = r - 1;
                prev = ' ';
            }
        }

        return length;
    }
}