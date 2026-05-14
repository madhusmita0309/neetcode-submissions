class Solution {

    public static int findMaxFreqCharsInWindow(int[] freqchars){
        int maxChars = 0;
        for(int i=0; i<freqchars.length; i++){
            maxChars = Math.max(maxChars, freqchars[i]);
        }
        return maxChars;
    }
    public int characterReplacement(String s, int k) {
        int left=0; int right=0;
        int[] freqchars = new int[26];
        int maxLen = 0;
        while(right < s.length()){
            freqchars[s.charAt(right) - 'A']++;
            while(right-left+1 - findMaxFreqCharsInWindow(freqchars) > k){
                freqchars[s.charAt(left) - 'A']--;
                left++;
            }
            
            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }

        return maxLen;

    }
}
