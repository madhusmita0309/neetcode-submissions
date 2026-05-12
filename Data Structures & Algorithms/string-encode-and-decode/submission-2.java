class Solution {

    public String encode(List<String> strs) {
        String result =""; int i=0;
        while(i < strs.size()){
            result = result + strs.get(i).length() + "#" + strs.get(i);
            i++;
        }

        return result;
    }

    public List<String> decode(String str) {
        int start = 0; int end=0;
        List<String> result = new ArrayList();
        while(start < str.length()){
            end = start;
            while(str.charAt(end) != '#'){
                end++;
            }
            int len = Integer.valueOf(str.substring(start, end));
            result.add(str.substring(end+1, end+1+len));
            start = end+1+len;
        }

        return result;
    }
}
