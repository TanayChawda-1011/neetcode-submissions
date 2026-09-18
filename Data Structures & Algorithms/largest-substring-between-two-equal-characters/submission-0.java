class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] start = new int[26];
        int[] end = new int[26];
        int res = -1;

        Arrays.fill(start, -1);

        int n = s.length();

        for(int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';

            if(start[c] == -1)
                start[c] = i;
            
            end[c] = i;
        }

        for(int c = 0; c < 26; c++) {
            if(start[c] == -1)  continue;

            res = Math.max(res, end[c] - start[c] - 1);
        }

        return res;
    }
}