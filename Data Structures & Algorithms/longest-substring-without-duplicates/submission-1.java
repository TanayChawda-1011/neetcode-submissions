class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n <= 1)  return n;

        int res = 0;
        int l = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(int r = 0; r < n; r++) {
            char c = s.charAt(r); 
            
            if(map.containsKey(c))
                l = Math.max(l, map.get(c) + 1);

            map.put(c, r);

            res = Math.max(res, r - l + 1);
        }


        return res;
    }
}