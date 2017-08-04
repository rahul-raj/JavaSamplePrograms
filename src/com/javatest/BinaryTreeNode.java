package com.javatest;
import java.util.*;
/**
 * Created by Rahul Raj on 7/31/2017.
 */
public class BinaryTreeNode {

    int data;
    BinaryTreeNode left;
    BinaryTreeNode right;
    BinaryTreeNode(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }

    static BinaryTreeNode insertNode(BinaryTreeNode binaryTreeNode, String str, int data){

                    if(binaryTreeNode !=null && str.length()>1){
                        if(str.charAt(0)=='L'){
                            binaryTreeNode.left=insertNode(binaryTreeNode.left,str.substring(1,str.length()),data);
                        }
                        else if(str.charAt(0)=='R'){
                            binaryTreeNode.right=insertNode(binaryTreeNode.right,str.substring(1,str.length()),data);
                        }
                    }

                    else if(binaryTreeNode !=null && str!=null){
                        if(str.charAt(0)=='L'){
                            binaryTreeNode.left=insertNode(binaryTreeNode.left,null,data);
                        }
                        else if(str.charAt(0)=='R'){
                            binaryTreeNode.right=insertNode(binaryTreeNode.right,null,data);
                        }
                    }
                    else{
                            return new BinaryTreeNode(data);
                    }

                    return binaryTreeNode;
    }

    static BinaryTreeNode removeNode(BinaryTreeNode binaryTreeNode, int data){
        if(binaryTreeNode!=null){
            if(binaryTreeNode.data==data){
                binaryTreeNode=null;
            }
            else{
                binaryTreeNode.left=removeNode(binaryTreeNode.left,data);
                binaryTreeNode.right=removeNode(binaryTreeNode.right,data);
            }
        }
        return binaryTreeNode;
    }

    static void printPreOder(BinaryTreeNode binaryTreeNode){
        if(binaryTreeNode!=null){
            System.out.println(binaryTreeNode.data);
            printPreOder(binaryTreeNode.left);
            printPreOder(binaryTreeNode.right);
        }
    }

    static void printPostOrder(BinaryTreeNode binaryTreeNode){
        if(binaryTreeNode!=null){
            printPostOrder(binaryTreeNode.left);
            printPostOrder(binaryTreeNode.right);
            System.out.println(binaryTreeNode.data);
        }
    }

    static void printInOrder(BinaryTreeNode binaryTreeNode){
        if(binaryTreeNode!=null){
            printInOrder(binaryTreeNode.left);
            System.out.println(binaryTreeNode.data);
            printInOrder(binaryTreeNode.right);
        }
    }

    static int height(BinaryTreeNode binaryTreeNode){
        if(binaryTreeNode==null){
            return 0;
        }
        else{
            return 1+Math.max(height(binaryTreeNode.left),height(binaryTreeNode.right));
        }
    }

    static int diameter(BinaryTreeNode binaryTreeNode){
       if(binaryTreeNode==null){
            return 0;
       }
       else{
           int lHeight=height(binaryTreeNode.left);
           int rHeight=height(binaryTreeNode.right);
           return Math.max(1+lHeight+rHeight, Math.max(diameter(binaryTreeNode.left),diameter(binaryTreeNode.right)));
       }
    }

    public static void main(String args[] ) throws Exception {

        Scanner s = new Scanner(System.in);
        int root = s.nextInt();
        BinaryTreeNode binaryTreeNode = new BinaryTreeNode(root);
        binaryTreeNode =insertNode(binaryTreeNode,"L",2);
        binaryTreeNode =insertNode(binaryTreeNode,"R",3);
        binaryTreeNode =insertNode(binaryTreeNode,"LL",4);
        binaryTreeNode =insertNode(binaryTreeNode,"LR",5);
        binaryTreeNode =insertNode(binaryTreeNode,"RL",6);
        binaryTreeNode =insertNode(binaryTreeNode,"RR",7);
        //System.out.println(binaryTreeNode.right.left.data);
        //System.out.println(binaryTreeNode.right.right.data);
       // printPreOder(binaryTreeNode);
        System.out.println(diameter(binaryTreeNode));
        binaryTreeNode=removeNode(binaryTreeNode,7);
        binaryTreeNode=removeNode(binaryTreeNode,6);
        System.out.println("**********************************");
        System.out.println(diameter(binaryTreeNode));
       // printPreOder(binaryTreeNode);

    }

}
