package com.omisoft.basic_java.objects.task4;

public class Test {
	/**
	 * Creates a tree with some values and executes all the methods.
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		BinaryTree tree = new BinaryTree();
		tree.addNode(21, "Boss");
		tree.addNode(12, "Office Manager");
		tree.addNode(54, "Secretary");
		tree.addNode(1, "Crew Member");
		tree.addNode(1, "test1");
		tree.addNode(21, "test2");
		tree.addNode(21, "test3");
		tree.addNode(6, "Assistant");
		
		
		//Traversing the tree
		tree.inOrderTraverse(tree.root);
		System.out.println();
		tree.preOrderTraverse(tree.root);
		System.out.println();
		tree.postOrderTraverse(tree.root);
		System.out.println();
		
		System.out.println("Search for key 1:");
		System.out.println(tree.findNode(1));
		System.out.println();
		System.out.println("Search for key 21:");
		System.out.println(tree.findNode(21));
		
		//Getters and Setters:
		System.out.println();
		Node treesetter = new Node(12, "Sales Clerk");
		tree.setRoot(treesetter);
		System.out.println(tree.getRoot());
		System.out.println();
		
		// Comparing two keys with Comparator	
		Compare comparator = new Compare();
		comparator.compare(6, 1);
		
	}

}
