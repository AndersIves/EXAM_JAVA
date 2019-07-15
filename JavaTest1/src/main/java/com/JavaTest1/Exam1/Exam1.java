package com.JavaTest1.Exam1;

public class Exam1{
    // 随机生成50个小于100的整数，放入List中
    // 将List中的数据除以10，以结果的整数值作为key放入Map中，得到如{1=>[11,10,12],2=>[21,24,23]}的Map
    // 再将Map中key对应的数组进行排序，得到如{1=>[10,11,12],2=>[21,23,24]}
    // 排序不能使用List.sort()方法。必须自己写排序方法。
    // 使用工厂模式，创建一个接口类和两个实现类（4分）
    // 创建一个工厂，生成基于给定信息的实体类的对象。（2分）
    // 在main函数中，通过上面的工厂获取到唯一的类。（2分）
    // 两个实现类分别使用java 8的Stream和其他方式（4分）
    // 实现功能（3分）
    public static void main(String[] args) {
        //外部迭代
        Exam1_implements e1 = Factory.create(Factory.MOD_1);
        e1.func();
        //Stream
        Exam1_implements e2 = Factory.create(Factory.MOD_2);
        e2.func();
    }
}
