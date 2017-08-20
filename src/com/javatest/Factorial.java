package com.javatest;


import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Factorial {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
        for(int k=1;k<=testCases;k++){
            int number = sc.nextInt();
            map.put(k,calculateScore(number));
        }

        int large = Integer.MIN_VALUE;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(large<entry.getValue()){
                large=entry.getValue();
            }

        }

        int secondlargest = Integer.MIN_VALUE;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(secondlargest<entry.getValue() && entry.getValue()!=large){
                secondlargest=entry.getValue();
            }

        }

        int smallIndex = Integer.MAX_VALUE;
        int bigIndex = Integer.MAX_VALUE;

        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(smallIndex>entry.getKey() && entry.getValue()==secondlargest){
                smallIndex=entry.getKey();
            }
            if(bigIndex>entry.getKey() && entry.getValue()==large){
                bigIndex=entry.getKey();
            }
        }

        System.out.println(bigIndex+" "+large);
        System.out.println(smallIndex+" "+secondlargest);

    }





    static int calculateScore(int number){
        int[] res = new int[300];
        res[0]=1;
        int res_size=1;

        for(int x=2;x<=number;x++){
            res_size = multiply(x,res,res_size);
        }
        int sum=0;
        int count=0;
        for(int i=res_size-1;i>=0;i--){
            sum=sum+res[i];
            if(res[i]==0){
                count++;
            }
        }
        return sum-count;
    }



    static int multiply(int x, int[] res, int res_size){
            int carry=0;
            for(int i=0;i<res_size;i++){
                int prod = res[i]*x+carry;
                res[i]=prod%10;
                carry = prod/10;
            }
            while(carry>0){
                res[res_size]=carry%10;
                carry=carry/10;
                res_size++;
            }
            return res_size;
    }




}
