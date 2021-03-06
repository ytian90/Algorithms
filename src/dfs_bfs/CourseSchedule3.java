package dfs_bfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Course Schedule II with DFS
 * @author yutian
 * @since Aug 27, 2015
 */
public class CourseSchedule3 {
	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		Graph obj = new Graph(numCourses, prerequisites);
		return obj.topologicalOrder();
	}
	public static class Graph {
		private int V, E;
		private List<List<Integer>> adj;
		private boolean hasCycle;
		private boolean[] visited, onStack;
		private Stack<Integer> postorder; // modification: add post order
		
		public Graph(int n, int[][] edges) {
			this.V = n;
			this.E = edges.length;
			adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
			for (int i = 0; i < E; i++) {
				int v = edges[i][1]; // prerequired
                int w = edges[i][0]; // wanted
                adj.get(v).add(w);
			}
			visited = new boolean[V];
			onStack = new boolean[V];
			postorder = new Stack<Integer>(); // modification: add post order
		}
		
		public int[] topologicalOrder() {
			for (int i = 0; i < V; i++) {
                if (!visited[i]) dfs(i);
            }
			if (hasCycle) return new int[0]; // modification: return an empty array
			else {
				int[] order = new int[V];
				for (int i = 0; i < V; i++) {
					order[i] = postorder.pop();
				}
				return order;
			}
		}

		private void dfs(int i) {
			visited[i] = true;
			onStack[i]= true;
			for (int j : adj.get(i)) {
				if (hasCycle) return;
				else if (!visited[j]) dfs(j);
				else if (onStack[j]) hasCycle = true;
			}
			postorder.push(i); // modification: record postorder
			onStack[i] = false;
		}
	}
	
	public static void main(String[] args) {
		for (int i: findOrder(2, new int[][]{{1, 0}, {0, 1}}))
			System.out.println(i);
		System.out.println();
		for (int i: findOrder(2, new int[][]{{1, 0}}))
			System.out.println(i);
	}
}
