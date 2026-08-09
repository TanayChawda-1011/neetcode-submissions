class Solution {
    public int appendCharacters(String s, String t) {
        int p1 = 0, p2 = 0;
        int sLen = s.length(), tLen = t.length();

        while(p1 < sLen && p2 < tLen) {
            if(s.charAt(p1) == t.charAt(p2))
                p2++;
            p1++;
        }

        return tLen - p2;
    }
}