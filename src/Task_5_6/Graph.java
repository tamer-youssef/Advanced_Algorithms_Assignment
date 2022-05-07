package Task_5_6;
import java.util.*;

public class Graph {
	ArrayList<Node> nodes;
	ArrayList<LinkedList<Node>> adjListNode;

	int[][] matrix;
	
	Graph(int size){
		matrix = new int[size][size];
		nodes = new ArrayList<>();
		adjListNode = new ArrayList<>();
	}
	
	public void addNode(Node node) {
		nodes.add(node);
		
		LinkedList<Node> currentList = new LinkedList<>();
		currentList.add(node);
		adjListNode.add(currentList);
	}
	
	public void addEdge(Edge edge) {
		matrix[edge.nodeStart][edge.nodeDestination] = edge.weight;

		LinkedList<Node> nodeList = adjListNode.get(edge.nodeStart);
		Node nodeDst = adjListNode.get(edge.nodeDestination).get(0);	
		nodeList.add(nodeDst);
	}

	public void breadthFirstSearch(int startNode) {
		Queue<Integer> q = new LinkedList<>();
		boolean visited[] = new boolean[matrix.length];
		
		System.out.println("Breadth-first Traversal: ");
		
		q.add(startNode);
		visited[startNode] = true;
		
		while(q.size() != 0) {
			startNode = q.remove();
			System.out.print(nodes.get(startNode).label + " ");
			
			for (int i = 0; i < matrix[startNode].length; i++) {
				if (matrix[startNode][i] != 0 && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
			
		}
		System.out.println("\n");
	}
	
	public void depthFirstSearch(int startNode) {
		boolean[] visited = new boolean[matrix.length];
		System.out.println("Depth-first Traversal: ");
		depthFirstSearchUtil(startNode, visited);
		System.out.println("\n");
	}
	
	private void depthFirstSearchUtil(int startNode, boolean[] visited) {
		if(visited[startNode] == true) {
			return;
		}
		else {
			visited[startNode] = true;
			System.out.print(nodes.get(startNode).label + " ");
		}
		
		for (int i = 0; i < matrix[startNode].length; i++) {
			if (matrix[startNode][i] != 0) {
				depthFirstSearchUtil(i, visited);
			}
		}
		return;
	}

	public void showMatrix() {
		System.out.print("Adjacency Matrix: \n");
		
		System.out.print("  ");
		for (int i = 0; i < matrix.length; i++) {
			System.out.print(nodes.get(i).label + " ");
		}
		System.out.println();
		
		
		for (int i = 0; i < matrix.length; i++) {
			System.out.print(nodes.get(i).label + " ");
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void showAdjacencyList() {
		System.out.print("Adjacency List: \n");
		
		for (LinkedList<Node> currentList : adjListNode) {
			for(Node node : currentList ) {
				System.out.printf(node.label + " -> ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
