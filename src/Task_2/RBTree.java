package Task_2;
// add deletion
@SuppressWarnings("unused")
public class RBTree {
    public static class Node {
        int data;
        Node parent;
        Node left;
        Node right;
        int color;
 
        Node(int data)
        {
            this.data = data;
            this.parent = null;
            this.left = null;
            this.right = null;
            this.color = 0;
        }
    }
	    
	    Node rotateLeft(Node node) {
	        Node x = node.right;
	        Node y = x.left;
	        
	        x.left = node;
	        node.right = y;
	        node.parent = x;
	        
	        if(y!=null) {
	            y.parent = node;
	        }
	        return(x);
	    }
	    
	    Node rotateRight(Node node) {
	        Node x = node.left;
	        Node y = x.right;
	        
	        x.right = node;
	        node.left = y;
	        node.parent = x;
	        
	        if(y!=null) {
	            y.parent = node;
	        }
	        return(x);
	    }
	    
	    int ll = 0;
	    int rr = 0;
	    int lr = 0;
	    int rl = 0;
		public Node root;

		public void add(int data) {
	        if(this.root == null) {
	            this.root = new Node(data);
	            this.root.color = 0;
	        }
	        else
	            this.root = addHelper(this.root, data);
	    }
	    
	    Node addHelper(Node root, int data) {
			int RRConflict = 0;
	         
	        if(root == null) {
	            return(new Node(data));
	        }

	        else if(data < root.data) {
	            root.left = addHelper(root.left, data);
	            root.left.parent = root;
	            if(root != this.root)
	            {
	                if(root.color == 1 && root.left.color == 1)
	                    RRConflict = 1;
	            }
	        }
	        else {
	            root.right = addHelper(root.right, data);
	            root.right.parent = root;
	            if(root != this.root)
	            {
	                if(root.color == 1 && root.right.color == 1)
	                    RRConflict = 1;
	            }
	        }
			return root;
	    }
	    
	    public void printInOrder() {
	        printInOrderHelper(this.root);
	    }
	    
	    void printInOrderHelper(Node node) {
	        if(node!=null) {
	        	printInOrderHelper(node.left);
	            System.out.printf("%d ", node.data);
	            printInOrderHelper(node.right);
	        }
	    }

}
