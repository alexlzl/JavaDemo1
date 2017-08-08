package com.test.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestIterator {
    private String[]  data= {"a","b","c","d","e"};
    private static List<String> list=new ArrayList<>();
    public static void main(String[] args){
        for(int i=0;i<5;i++){
            list.add(i+"");
        }
        Iterator iterator=list.iterator();
        while (iterator.hasNext()){
            if(iterator.next().equals("0")){
                iterator.remove();
                System.out.println(iterator.next());
            }
        }
        System.out.println(list.toString());
    }
}
