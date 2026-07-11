class Solution {
    public int[] parent;
    public int[] rank;
    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];
        Arrays.fill(rank, 1);
        int comp = n;
        for(int i=0; i<n; i++){
            parent[i] = i;
        }

        for(int[] e : edges){
            int e1 = e[0]; int e2 = e[1];
            comp = comp - union(e1, e2);
        }

        return comp;
    }

    public int union(int e1, int e2){
        int p1 = find(e1); int p2 = find(e2); // find parent of both e1, e2 nodes

        if(p1 == p2)
            return 0; // same parent so cannot be merged or no union
        
        if(rank[p1] > rank[p2]){
            rank[p1] +=  rank[p2];
            parent[p2] = p1;
        }else{
            rank[p2] += rank[p1]; 
            parent[p1] = p2;
        }

        return 1; // becoz union 
    }

    public int find(int e1){
        int resultP = e1; // by default each node is parent of itself

        while(resultP != parent[resultP]){
            parent[resultP]= parent[parent[resultP]]; // path compression
            resultP = parent[resultP];
        }
       
       return resultP;
    }
}
