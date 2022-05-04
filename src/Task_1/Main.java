package Task_1;
// nlog(n)
public class Main {
	
	public static class Node
	{
	    int data;
	    Node right;
	    Node left;
	    
	    public Node(int data) {
			this(data,null,null);	
		}
	  
	    Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
	    }
	}
	
	public static class BTree {
	    Node root;
	    
	    public BTree() {
	    	root = null;
	    }
	    
	    void nodeDupe(Node node) {
	        Node left;
	  
	        if (node == null) {
	            return;
	        }
	  
	        nodeDupe(node.right);
	        nodeDupe(node.left);
	  
	        left = node.left;
	        node.left = new Node(node.data);
	        node.left.left = left;
	    }
	    
		void add(int key) {
			Node current = root, parent = null;
			while (current != null) {
				if (current.data > key) {
					parent = current;
					current = current.left;
				}

				else if (current.data <= key) {
					parent = current;
					current = current.right;
				}
			}

			if (parent == null)
				root = new Node(key);

			else {
				if (parent.data > key)
					parent.left = new Node(key);

				else if (parent.data <= key)
					parent.right = new Node(key);
			}
		}
	    
	    void displayTree() {
			java.util.Stack<Node> globalStack = new java.util.Stack<Node>();
				globalStack.push(root);
			int nBlanks = 32;
			boolean isRowEmpty = false;
				System.out.println("......................................................");
			while(isRowEmpty==false) {
				java.util.Stack<Node> localStack = new java.util.Stack<Node>();
				isRowEmpty = true;
				for(int j=0; j<nBlanks; j++)
					System.out.print(' ');
				while(globalStack.isEmpty()==false) {
					Node temp = globalStack.pop();
					if(temp != null) {
						System.out.print(temp.data);
						localStack.push(temp.left);
						localStack.push(temp.right);
						if(temp.left != null ||temp.right != null)   isRowEmpty = false;
					}
					else {
						System.out.print("--");
						localStack.push(null);
						localStack.push(null);
					}
					for(int j=0; j<nBlanks*2-2; j++)
					System.out.print(' ');
			} // end while globalStack not empty
				System.out.println();
				nBlanks /= 2;
				while(localStack.isEmpty()==false)
					globalStack.push( localStack.pop() );
			} // end while isRowEmpty is false
				System.out.println("......................................................");
		}

	}
	
	public static void main(String[] args) {
		BTree tree = new BTree();

		tree.add(2);
		tree.add(1);
		tree.add(4);
		tree.add(3);

		System.out.println("Inserted tree: ");
		tree.displayTree();
		tree.nodeDupe(tree.root);
		
		System.out.println("\n");
		System.out.println("Duplicated tree: ");
		tree.displayTree();

		}
	}

