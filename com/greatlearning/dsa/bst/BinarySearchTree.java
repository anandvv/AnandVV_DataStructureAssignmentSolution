package com.greatlearning.dsa.bst;

public class BinarySearchTree {

	public Node root;
	
	Node prevNode = null;
	Node headNode = null;

	public void generateRightSkewedTree(Node root){

		if(root == null){
			return;
		}

		generateRightSkewedTree(root.left);

		Node rightNode = root.right;

		if(headNode == null){
			headNode = root;
			headNode.left = null;			
			prevNode = root;
		}else {
			prevNode.right = root;			
			prevNode.left = null;
			prevNode = root;
		}

		generateRightSkewedTree (rightNode);
	}

	public void Display () {

		if(headNode == null)
		{
			return;
		}

		System.out.print(headNode.data + " ");
		headNode = headNode.right;
		Display();

	}	
}