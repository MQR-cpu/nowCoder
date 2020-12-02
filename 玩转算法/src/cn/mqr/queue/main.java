package cn.mqr.queue;

public class main {

    public static void main(String[] args) {

        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 12; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue);

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue);
        System.out.println(queue.getSize());
        queue.enqueue(777);
        System.out.println(queue);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.dequeue();
        System.out.println(queue);
        queue.enqueue(121);
        System.out.println(queue);

    }
}
