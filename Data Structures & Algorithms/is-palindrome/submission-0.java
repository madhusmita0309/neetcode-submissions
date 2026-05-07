class Solution {
    public boolean isPalindrome(String s) {
        
        StringBuilder str = new StringBuilder();
        for(char c: s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                
                str.append(Character.toLowerCase(c));
            }
        }

        System.out.println(str);

        int i = 0; int n = str.length()-1; 
        while(i < n){ 
            if(str.charAt(i) != str.charAt(n))
                return false;
            
            i++; n--;
        }
        return true;
    }
}
