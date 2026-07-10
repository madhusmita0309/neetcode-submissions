class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length > n - 1)
            return false;
        
        HashMap<Integer, List<Integer>> adjList = new HashMap();
        for(int i=0; i<n; i++){
            adjList.put(i, new ArrayList());
        }

        Set<Integer> visited = new HashSet();
   

        for(int[] edge : edges){
            int node = edge[1]; int pre = edge[0];
            adjList.get(pre).add(node);
            adjList.get(node).add(pre);
        }

        
        if(!dfs(0, -1, adjList, visited))
            return false;
        

        return visited.size() == n;
    }

    public boolean dfs(int node, int parent, HashMap<Integer, List<Integer>> adjList, Set<Integer> visited){

        
        if(visited.contains(node))
            return true;


        visited.add(node);
        for(int pre: adjList.get(node)){
            if(pre == node)
                continue;
            if(!dfs(pre, node, adjList, visited))
                return false;
        }

        
        

        return true;

    }
}
