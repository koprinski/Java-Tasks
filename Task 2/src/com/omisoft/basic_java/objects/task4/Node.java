package com.omisoft.basic_java.objects.task4;

/**
 * Creates a node with two elements
 * @author bkoprinski
 *
 */
public class Node {
	 int key;
	 String name;
	 
	 Node leftChild;
	 Node rightChild;
	 Node root;
	 /**
	  * Initialize constructor
	  * @param key
	  * @param name
	  */
	 Node(int key, String name)
	 {
		 this.key=key;
		 this.name=name;
	 }
	 /**
	  * Prints the name and the key
	  */
	 public String toString()
	 {
		 return name + " has a key " + key;
	 }
	 /**
	  * Sets the root key
	  * @param a - root
	  */
	 public void setRoot(Node a) {
		 root = a;
	 }
	 /**
	  * Gets the root key
	  * @return root
	  */
	 public Node getRoot()
	 {
		 return root;
	 }
}
