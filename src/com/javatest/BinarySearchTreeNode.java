package com.javatest;

/**
 * Created by Rahul Raj on 8/2/2017.
 */
public class BinarySearchTreeNode {
    int data;
    BinarySearchTreeNode left;
    BinarySearchTreeNode right;
    BinarySearchTreeNode(){}
    BinarySearchTreeNode(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }

    static BinarySearchTreeNode insertNode(BinarySearchTreeNode binarySearchTreeNode, int data){
        if(binarySearchTreeNode!=null){
            if(binarySearchTreeNode.data<data){
                binarySearchTreeNode.right=insertNode(binarySearchTreeNode.right,data);
            }
            else if(binarySearchTreeNode.data>data){
                binarySearchTreeNode.left=insertNode(binarySearchTreeNode.left,data);
            }
            return binarySearchTreeNode;
        }
        else{
            return new BinarySearchTreeNode(data);
        }

    }

    public static void main(String[] args) {
      BinarySearchTreeNode node = new BinarySearchTreeNode(12);
      node=insertNode(node,10);
        node=insertNode(node,11);
        node=insertNode(node,9);
        System.out.println(node.data);
      System.out.println(node.left.data);
        System.out.println(node.left.right.data);
        System.out.println(node.left.left.data);

    }
}
