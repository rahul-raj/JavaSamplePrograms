package com.javatest;

/**
 * Created by Rahul Raj on 8/2/2017.
 */
public class BinarySearchTreeNode {
    int data;
    BinarySearchTreeNode left;
    BinarySearchTreeNode right;
    static StringBuilder sc = new StringBuilder("");
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

    static StringBuilder searchNode(BinarySearchTreeNode binarySearchTreeNode,int data){

        if(binarySearchTreeNode!=null){
           if(binarySearchTreeNode.data>data){
             sc=sc.append("L");
             sc=searchNode(binarySearchTreeNode.left,data);
           }
           else if(binarySearchTreeNode.data<data){
               sc=sc.append("R");
               sc=searchNode(binarySearchTreeNode.right,data);
           }
           StringBuilder temp=new StringBuilder(sc);
           sc=new StringBuilder("");
           return temp;
        }
        else
            return new StringBuilder("");
    }

    static int findMirrorNode(BinarySearchTreeNode binarySearchTreeNode, String path){
        int mirrorImage=-1;
        if(binarySearchTreeNode!=null && path == null){
            return binarySearchTreeNode.data;
        }
        else if(binarySearchTreeNode!=null && path.length()==1){
            if(path.charAt(0)=='L'){
                mirrorImage = findMirrorNode(binarySearchTreeNode.right, null);
            }
            else if(path.charAt(0)=='R'){
                mirrorImage = findMirrorNode(binarySearchTreeNode.left, null);
            }
        }
        else if(binarySearchTreeNode!=null && path.length()>1){
            if(path.charAt(0)=='L'){
                mirrorImage= findMirrorNode(binarySearchTreeNode.right, path.substring(1,path.length()));
            }
            else if(path.charAt(0)=='R'){
                mirrorImage= findMirrorNode(binarySearchTreeNode.left, path.substring(1,path.length()));
            }
        }

        return mirrorImage;
    }

    public static void main(String[] args) {
      BinarySearchTreeNode node = new BinarySearchTreeNode(12);
      node=insertNode(node,10);
        node=insertNode(node,11);
        node=insertNode(node,9);
        node=insertNode(node,13);
        System.out.println(findMirrorNode(node,searchNode(node,11).toString()));

    }
}
