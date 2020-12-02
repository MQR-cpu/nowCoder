package cn.mqr.stack;

import jdk.nashorn.api.tree.ForInLoopTree;

public class main {

    public static void main(String[] args) {

        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        System.out.println(stack);

        stack.push(100);
        System.out.println(stack);

        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack);

        System.out.println(stack.getCapacity());
    }

}
