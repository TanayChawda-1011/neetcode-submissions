class Solution {
    public int maxNumberOfBalloons(String text) {
        char[] freqText = new char[26];
        char[] freqWord = new char[26];

        for(char c : text.toCharArray())
            freqText[c - 'a']++;
    
        for(char c : "balloon".toCharArray())
            freqWord[c - 'a']++;

        int res = Integer.MAX_VALUE;

        for(int i = 0; i < 26; i++) {
            if(freqWord[i] != 0) {
                res = Math.min(res, freqText[i] / freqWord[i]);
            }
        }

        return res;
    }
}