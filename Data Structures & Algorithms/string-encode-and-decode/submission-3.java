class Solution {

    public String encode(List<String> strs) {
        String s  = "";
        for(String w: strs){
            s = s + w.length()+"#"+w;
        }

        return s;
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList();
        int i = 0; int start =0; int end=0;
        while(i < str.length()){
            start = i; end = i;
            while(str.charAt(end) != '#'){
                end++;
            }
            int len = Integer.valueOf(str.substring(start,end));
            // System.out.println("len:"+str.substring(start,end));
            // System.out.println("word:"+str.substring(end+1, end+1+len));
            result.add(str.substring(end+1, end+1+len));
            i = end+len+1;
        }

        return result;
    }
}
