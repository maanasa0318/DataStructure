package neetcodealgo;

import java.util.Arrays;

public class UnionFind {

	public static void main(String[] args) {

		int[][] edges = {{1,2},{1,3},{2,3}};
		int[] res = findRedundantConnection(edges);
		System.out.println(Arrays.toString(res));
	}
	
	public static int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length +1];
        int[] rank = new int[edges.length +1];

        for(int i=0; i<edges.length; i++){
            parent[i] = i;
            rank[i]= 1;
        }

        for(int[] e : edges){
            if(!union(e[0], e[1], parent, rank)){
                return new int[]{e[0], e[1]};
            }
        }
        return new int[]{0,0};
    }

    public static int find(int []par, int n){
        int p = par[n];
        while(p != par[p]){
            p=par[par[p]];
            p=par[p];
        }
        return p;
    }

    private static boolean union(int node1, int node2, int[] parent, int[] rank) {
        int p1=find(parent, node1);
        int p2=find(parent, node2);

        if(p1==p2){
            return false;
        }
        if(rank[p1]>rank[p2]){
            parent[p2] = p1;
            rank[p1] += rank[p2];
        }
        else{
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }
}
