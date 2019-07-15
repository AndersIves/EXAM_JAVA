package com.JavaTest1.Exam1;

import java.util.*;

public class MODE_1 implements Exam1_implements{
    @Override
    public void func() {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<50;i++){
            list.add(random.nextInt(100));
        }
        LinkedHashMap<Integer,List> map = new LinkedHashMap<>();
        for(int i=0;i<10;i++) {
            map.put(i,new ArrayList<Integer>());
        }
        for(int i:list){
            for(int j:map.keySet()){
                if(i/10==j){
                    map.get(j).add(i);
                }
            }
        }
        for(int i:map.keySet()){
            sort(map.get(i));
        }
        System.out.println(map);
    }
    private void sort(List<Integer> list){
        for (int j=list.size();j>0;j--){
            for(int i=0;i<j-1;i++){
                if(list.get(i)>list.get(i+1)){
                    int temp = list.get(i);
                    list.set(i,list.get(i+1));
                    list.set(i+1,temp);
                }
            }
        }
    }
}
