package com.JavaTest1.Exam1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MODE_2 implements Exam1_implements{
    @Override
    public void func() {
        Random random = new Random();
        List<Integer> list = Stream.generate(()->random.nextInt(100))
                .limit(50)
                .collect(Collectors.toList());
        LinkedHashMap<Integer,List> map = new LinkedHashMap<>();
        for(int i=0;i<10;i++) {
            map.put(i,new ArrayList<Integer>());
        }
        list.parallelStream()
                .forEach(i->{
            for(int j:map.keySet()){
                if(i/10==j){
                    map.get(j).add(i);
                }
            }
        });
        for(int j:map.keySet()) {
            map.put(j,(ArrayList<Integer>)map.get(j).parallelStream().sorted((a,b)->{
                return (int)a-(int)b;
            }).collect(Collectors.toList()));
        }
        System.out.println(map);
    }
}
