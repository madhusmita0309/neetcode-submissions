class Solution {
    Map<Character, Set<Character>> adj; // adj list for graph
    Map<Character, Boolean> visited; // true: in the current path + visited (visited + cycle / visiting); false: not in the visiting path/ no cycle, but visited once
    // if char is absent in visited => its never been visited
    List<Character> result; // build string in reverse order after dfs
    
    public String foreignDictionary(String[] words) {
        adj = new HashMap<>();
        visited = new HashMap<>();
        result = new ArrayList();

        for(String w : words){
            for(char c : w.toCharArray()){
                adj.computeIfAbsent(c, k -> new HashSet<>());
                
            }
        }

        for(int i=0; i < words.length-1; i++){
            String w1 = words[i]; String w2 = words[i+1];
            int minLen = Math.min(w1.length(), w2.length());
            if(w1.length() > w2.length() && w1.substring(0, minLen).equals(w2.substring(0, minLen))){
                return ""; // contradictory order found
            }

            for(int j=0; j<minLen; j++){
                if(w1.charAt(j) != w2.charAt(j)){
                    adj.get(w1.charAt(j)).add(w2.charAt(j)); // add node at differing node
                    break;
                }
            }
        }

        // for all chars dfs
        for(char c : adj.keySet()){
            if(dfs(c))
                return "";
        }

        // reverse order as we have added char is reverse
        Collections.reverse(result);
        // build string
        StringBuilder sb = new StringBuilder();
        for(char c : result){
            sb.append(c);
        }

        return sb.toString();

    }

    public boolean dfs(char c){
        if(visited.containsKey(c))
            return visited.get(c); 

        visited.put(c, true); // in path + visiting
        for(char nei : adj.get(c)){
            if(dfs(nei))
                return true;
        }

        visited.put(c, false); // visited once but not in current path /cycle
        result.add(c); // valid char 
        return false;
    }
}
