package tuf;

class DisjointSet{
	
	private int[] rank;
	private int[] size;
	private int[] parent;
	
	public DisjointSet(int n) {
		rank = new int[n+1];
		size = new int[n+1];
		parent = new int[n+1];
		
		for(int i=0; i<n; i++) {
			parent[i] = i;
			size[i] = 1;
			rank[i] = 0;
		}
	}
	
	public int findUltimateParent(int node) {
		if(node == parent[node]) {
			return node;
		}
		return parent[node]= findUltimateParent(parent[node]);
	}
	
	public boolean find(int u, int v) {
		return (findUltimateParent(u) == findUltimateParent(v));
    }

    public void unionByRank(int u, int v) {
        int ultiParentU = findUltimateParent(u);
        int ultiParentV = findUltimateParent(v);
        
        if(ultiParentU == ultiParentV) {
        	return;
        }
        if(rank[ultiParentU] < rank[ultiParentV]) {
        	parent[ultiParentU] = parent[ultiParentV];
        }
        else if (rank[ultiParentV] < rank[ultiParentU]) {
        	parent[ultiParentV] = parent[ultiParentU];
        }
        else {
        	//same rank
        	parent[ultiParentV] = parent[ultiParentU];
        	rank[ultiParentU]++;
        }
    }

    public void unionBySize(int u, int v) {
    	int ultiParentU = findUltimateParent(u);
        int ultiParentV = findUltimateParent(v);
        
        if(ultiParentU == ultiParentV) {
        	return;
        }
        if(size[ultiParentU] < size[ultiParentV]) {
        	parent[ultiParentU] = parent[ultiParentV];
        	size[ultiParentV] += size[ultiParentU];
        }
        else {
        	parent[ultiParentV] = parent[ultiParentU];
        	size[ultiParentU] += size[ultiParentV];
        }
    }
	
}
public class DisjointSetDemo {
	
	 
	public static void main(String[] args) {
		  // Disjoint Data structure
	       DisjointSet ds = new DisjointSet(7);
	       ds.unionBySize(1, 2); // Adding edge between 1 and 2
	       ds.unionBySize(2, 3); // Adding edge between 2 and 3
	       ds.unionBySize(4, 5); // Adding edge between 4 and 5
	       ds.unionBySize(6, 7); // Adding edge between 6 and 7
	       ds.unionBySize(5, 6); // Adding edge between 5 and 6

	       /* Checking if node 3 and node 7 
	       are in the same component */
	       if (ds.find(3, 7))
	           System.out.println("They belong to the same components.");
	       else
	           System.out.println("They do not belong to the same components.");

	       ds.unionBySize(3, 7); // Adding edge between 3 and 7

	       /* Checking again if node 3 and node 7 
	       are in the same component */
	       if (ds.find(3, 7))
	           System.out.println("They belong to the same components.");
	       else
	           System.out.println("They do not belong to the same components.");
	}

}
