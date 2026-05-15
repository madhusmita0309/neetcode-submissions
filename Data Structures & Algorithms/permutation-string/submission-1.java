class Solution {
    public static boolean matchArray(int[] s1Char, int[] s2Char){
        for(int i=0; i < s1Char.length; i++){
            if(s1Char[i] != s2Char[i]){
                return false;
            }
                
        }

        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
            return false;

        int[] s1Char = new int[26];
        

        for(int i=0; i<s1.length(); i++){
            s1Char[s1.charAt(i) - 'a']++;
        }

        for(int i=0; i <= s2.length() - s1.length(); i++){
            int s2Char[] = new int[26];
            for(int j=0; j < s1.length(); j++){
                s2Char[s2.charAt(i+j) - 'a']++;
            }
            if(matchArray(s1Char, s2Char)){  
                return true;
            }
                
        }

        return false;    
    }
}
