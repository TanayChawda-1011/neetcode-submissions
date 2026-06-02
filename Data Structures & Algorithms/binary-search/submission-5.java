class Solution {
    public int binarySearch(int[] nums, int l, int h, int x) {
        if(l <= h) {
            int mid = l + (h - l) / 2;

            if(nums[mid] == x)
                return mid;
            else if(nums[mid] < x)
                return binarySearch(nums, mid + 1, h, x);
            else
                return binarySearch(nums, l, mid - 1, x);
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }
}
