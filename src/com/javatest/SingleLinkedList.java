package com.javatest;


import java.util.HashMap;
import java.util.Map;

class ListNode{

    int data;
    ListNode next;
    ListNode(){

    }
    ListNode(int data){
        this.data=data;
        this.next=null;
    }

}

public class SingleLinkedList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node = insertNode(node,2);
        node = insertNode(node,3);
        node = insertNode(node,4);
        node = insertNode(node,5);
        node = createCycle(node);
        node = detectCycle(node);
        System.out.println(node.next.next.next.next.next);
    }

    static ListNode insertNode(ListNode node, int data){
        if(node==null){
            return new ListNode(data);
        }
        else{
            node.next = insertNode(node.next,data);
            return node;
        }
    }

    static ListNode createCycle(ListNode head){
         ListNode lnode = head;
         while(lnode.next!=null){
             lnode = lnode.next;
         }
            lnode.next = head;
            return head;
    }

    static ListNode detectCycle(ListNode node){
        Map<ListNode,Boolean> map = new HashMap<>();
        boolean isDetected=false;
        ListNode temp = new ListNode();
        ListNode headRef = node;
        while(isDetected==false && node.next!=null){
            if(map.size()==0){
                map.put(node,true);
            }
            else if(map.get(node)==null){
                map.put(node,true);
            }
            else if(map.get(node)==true){
                isDetected=true;
                temp.next=null;
            }
            else{
                map.put(node,true);
            }
            temp=node;
            node=node.next;
        }
        return headRef;
    }
}
