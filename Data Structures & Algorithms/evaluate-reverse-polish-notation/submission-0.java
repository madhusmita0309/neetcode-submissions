class Solution {
    public int evalRPN(String[] tokens) {
       Deque<String> numsStack = new ArrayDeque<>();
       for(int i=0; i < tokens.length; i++){
            if(!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("/") && !tokens[i].equals("*")){
                numsStack.push(tokens[i]);
            }else{
                int nums2 = Integer.valueOf(numsStack.pop());
                int nums1 = Integer.valueOf(numsStack.pop());
                int ans = 0;
                if(tokens[i].equals("+"))
                    ans = nums1 + nums2;
                else if(tokens[i].equals("-"))
                    ans = nums1 - nums2;
                else if(tokens[i].equals("*"))
                    ans = nums1 * nums2;
                else
                    ans = nums1/nums2;
                
                numsStack.push(String.valueOf(ans));
            }
       }

        
       return Integer.valueOf(numsStack.pop()); 
    }
}
