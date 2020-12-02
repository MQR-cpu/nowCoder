package cn.mqr.array;

public class main {

    public static void main(String[] args) {

        Array<Integer> array = new Array<>();

        for (int i = 0; i < 4; i++) {
            array.addLast(i);
        }
        array.remove(0);
        System.out.println(array);

    }
}
