class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0)
            return true;
        if(s == null)
            return false;
        if(s.length()%2 != 0)
            return false;

        Deque<Character> st = new ArrayDeque<>();
        int i=0;
        while(i < s.length()){
            if(s.charAt(i) == '('){
                st.push(')');
            }
            else if(s.charAt(i) == '{'){
                st.push('}');
            }
            else if(s.charAt(i) == '['){
                st.push(']');
            }
            else if(st.isEmpty() || st.pop() != s.charAt(i)){
                return false;
            }
            i++;
        }

        return st.isEmpty();
    }
}
