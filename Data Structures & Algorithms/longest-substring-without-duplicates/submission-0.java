class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n <= 1)  return n;

        int res = 0;
        int l = 0;
        char[] sChar = s.toCharArray();
        // int[] freq = new int[26];
        Map<Character, Integer> map = new HashMap<>();

        for(int r = 0; r < n; r++) {
            map.put(sChar[r], map.getOrDefault(sChar[r], 0) + 1);
            
            while(map.get(sChar[r]) > 1) {
                map.put(sChar[l], map.get(sChar[l]) - 1);
                l++;
            }

            res = Math.max(res, r - l + 1);
        }


        return res;
    }
}