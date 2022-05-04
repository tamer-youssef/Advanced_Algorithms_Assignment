package Task_2;
// log(n)
public class Main {
	
	public static void main(String[] args) {
		RBTree tree = new RBTree();
		int[] arr = {30, 15, 45, 35, 60, 55};
		
        for(int i = 0; i < arr.length;i++)
        {
            tree.add(arr[i]);
            System.out.println("");
            tree.printInOrder();
            
//          tree.deleteNode(45);
        }
	}
}


