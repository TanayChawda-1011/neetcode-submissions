class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> monotonicStack = new ArrayDeque<>();
        int[] nge = new int[nums2.length];      // nge = NEXT GREATER ELEMENT

        for(int i = 0; i < nums2.length; i++) {
            int ele = nums2[i];
            int greaterEle = -1;
            
            while(!monotonicStack.isEmpty() && ele > nums2[monotonicStack.peek()]) {
                int index = monotonicStack.pop();
                nge[index] = ele;
            }
            monotonicStack.push(i);
            map.put(ele, i);
        }

        int[] res = new int[nums1.length];

        for(int i = 0; i < nums1.length; i++) {
            res[i] = nge[map.get(nums1[i])];
            if(res[i] == 0) res[i] = -1;
        }

        return res;
    }
}