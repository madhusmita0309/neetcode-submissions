class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0; int right =0;
        int maxLen = 0;
        HashSet<Character> charSeen = new HashSet<>();

        while(right < s.length()){
            while(charSeen.contains(s.charAt(right))){
                charSeen.remove(s.charAt(left));
                left++;
            }
            
            charSeen.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left+1);
            right++;
        }
        return maxLen;

    }
}
