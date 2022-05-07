package Task_5_6;

public class Main {
	
	public static void main(String[] args) {
		Graph matrix = new Graph(5);
		
		matrix.addNode(new Node('A'));
		matrix.addNode(new Node('B'));
		matrix.addNode(new Node('C'));
		matrix.addNode(new Node('D'));
		matrix.addNode(new Node('E'));
		
		matrix.addEdge(new Edge(0, 1, 5));
		matrix.addEdge(new Edge(0, 2, 2));
		matrix.addEdge(new Edge(1, 3, 1));
		matrix.addEdge(new Edge(1, 4, 7));
		matrix.addEdge(new Edge(2, 3, 5));
		matrix.addEdge(new Edge(2, 4, 8));
		matrix.addEdge(new Edge(3, 4, 5));
		
		matrix.showMatrix();
		matrix.showAdjacencyList();
				
		matrix.breadthFirstSearch(0);
		matrix.depthFirstSearch(0);
	}
}
