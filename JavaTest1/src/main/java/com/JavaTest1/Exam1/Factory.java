package com.JavaTest1.Exam1;

public class Factory {
    public static final int MOD_1=1;
    public static final int MOD_2=2;

    public static Exam1_implements create(int mode){
        switch (mode){
            case MOD_1:
                return new MODE_1();
            case MOD_2:
                return new MODE_2();
            default:
                return null;
        }
    }
}
