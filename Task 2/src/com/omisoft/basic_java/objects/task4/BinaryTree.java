package com.omisoft.basic_java.objects.task4;
/**
 * Creating a binary tree.
 * A comparator is used to order the items in the tree.
 * 
 * @author bkoprinski
 *
 * @param <T>
 * 			type of the tree.
 */
public class BinaryTree {
	/**
	 * Adds a single element to the tree.
	 * @param key - element
	 * @param name - name of the element
	 */
	Node root;
	public void addNode(int key, String name)
	{
		
		Node newNode = new Node(key, name);
		
		if (root == null)
		{
			root = newNode;
		}
		else
		{
			Node topNode = root;
			Node parent;
			
			while (true)
			{
				parent = topNode;
				
				if (key < parent.key)
				{
					topNode = topNode.leftChild;
					
					
					if(topNode == null)
					{
						parent.leftChild = newNode;
						return;
					}
				}
				else if (key > parent.key)
				{
					topNode = topNode.rightChild;
					
					if(topNode == null)
					{
						parent.rightChild = newNode;
						return;
					}
				}
				else
				{
					return;
				}
				
			}
		}
	}
	/**
	 * Traverse the tree in order.
	 * 
	 * @param topNode - object that keeps the key and the name of the top node
	 */
	public void inOrderTraverse(Node topNode)
	{
		if (topNode != null)
		{
			inOrderTraverse(topNode.leftChild);
			System.out.println(topNode);
			inOrderTraverse(topNode.rightChild);
		}
	}
	/**
	 * Traverse the tree preorder.
	 * 
	 * @param topNode - object that keeps the key and the name of the top node
	 */
	public void preOrderTraverse(Node topNode)
	{
		if (topNode != null)
		{
			System.out.println(topNode);
			preOrderTraverse(topNode.leftChild);
			preOrderTraverse(topNode.rightChild);
		}
	}
	/**
	 * Traverse the tree postorder.
	 * 
	 * @param topNode - object that keeps the key and the name of the top node
	 */
	public void postOrderTraverse(Node topNode)
	{
		if (topNode != null)
		{
			postOrderTraverse(topNode.leftChild);
			postOrderTraverse(topNode.rightChild);
			System.out.println(topNode);
		}
	}
	/**
	 * Method that searches the tree by the given key.
	 * @param key - element of the tree
	 * @return - topNode - the element which you search
	 */
	public Node findNode(int key)
	{
		Node topNode = root;
		
		while (topNode.key != key)
		{
			if (key < topNode.key)
			{
				topNode = topNode.leftChild;
				
			}
			else
			{
				topNode = topNode.rightChild;
			}
			
			if (topNode == null)
			{
				System.out.println("The node is not found!");
				return null;
			}
		}
		return topNode;
	}
	/**
	 * Root getter
	 * @return - root	
	 */
	public Node getRoot() {
		return root;
	}
	/**
	 * Root setter
	 * @param root - sets a root
	 */
	public void setRoot(Node root) {
		this.root = root;
	}
}
