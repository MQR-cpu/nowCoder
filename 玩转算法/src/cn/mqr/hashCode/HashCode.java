package cn.mqr.hashCode;

import java.util.HashMap;

public class HashCode {
    public static void main(String[] args) {

        int a = 100;
        Integer A = (Integer)a;
        System.out.println(A.hashCode());

        double f = 100.0;
        Double F = (Double)f;
        System.out.println(F.hashCode());

        String str = "mqr";
        System.out.println(str.hashCode());

        Student stu = new Student("mqr", 21);
        Student stu2 = new Student("mqr", 21);
        HashMap<Student, Integer> map = new HashMap<>();
        map.put(stu, 1);
        map.put(stu2, 2);
        System.out.println(map.get(stu));
    }
}
