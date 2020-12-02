package cn.mqr.array;

public class Array<E> {

    private E[] arr;
    private int size;

    /**
     * 制定容量构造方法
     * @param capacity
     */
    public Array(int capacity) {
        arr = (E[]) new Object[capacity];
        size = 0;
    }

    public Array(E[] data) {
        arr = (E[]) new Object[data.length];
        for (int i = 0; i < data.length; i++) {
            arr[i] = data[i];
        }
        size = data.length;
    }
    /**
     * 默认构造方法
     */
    public Array() {
        this(10);
    }

    /**
     * 返回容积
     * @return
     */
    public int getCapacity() {
        return arr.length;
    }

    /**
     * 返回元素个数
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 数组是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    public void swap(int a, int b) {
        if (a < 0 || b < 0 || a >= size || b >= size) {
            throw new IllegalArgumentException("index isn't illegal");
        }
        E tep = arr[a];
        arr[a] = arr[b];
        arr[b] = tep;
    }

    /**
     * 获取元素值
     * @param index
     * @return
     */
    public E get(int index) {

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index isn't illegal");
        }

        return arr[index];
    }

    public E removeFirst() {
        return remove(0);
    }

    /**
     * 设置值
     *
     * @param index
     * @param e
     */


    public void set(int index,E e) {

        if (index < 0 || index <= size) {
            throw new IllegalArgumentException("index isn't illegal");
        }

        arr[index] = e;
    }
    /**
     * 向末尾添加元素
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 是否包含元素e
     * @param e
     * @return
     */
    public boolean contains(E e) {

        for (int i = 0; i < size - 1; i++) {
            if (arr[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 删除索引元素
     * @param index
     * @return
     */
    public E remove(int index) {

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove is failed");
        }


        for (int i = index+1; i < size; ++i) {
            arr[i-1] = arr[i];
        }
        size--;
        arr[size] = null;//对象数组会有引用问题 垃圾回收

        //防止复杂度振荡  避免bug
        if (size == arr.length / 4 && arr.length / 2 != 0) {
            resize((arr.length / 2));
        }

        return arr[index];
    }

    public E getFirst() {
        return get(0);
    }
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 删除最后的元素
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除元素 e
     * @param e
     * @return
     */
    public boolean removeElement(E e) {

        if (find(e) != -1) {
            remove(find(e));
            return true;
        }
        return false;
    }
    /**
     * 寻找元素e 没有返回-1
     * @param e
     * @return
     */
    public int find(E e) {

        for (int i = 0; i < size; i++) {
            if (arr[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }
    /**
     * 向头部添加元素
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 向指定索引添加元素
     * @param index
     * @param e
     */
    public void add(int index, E e) {

        if (size == arr.length) {
            resize(2*(arr.length));
        }

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add is failed . Array is full");
        }

        for (int i = size - 1; i >= index; --i) {
            arr[i+1] = arr[i];
        }
        arr[index] = e;
        size++;
    }

    /**
     * 扩容操作
     * @param capacity
     */
    private void resize(int capacity) {

        E[] data = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            data[i] = arr[i];
        }

        arr = data;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array : size = %d , capacity = %d\n", size, arr.length));
        res.append("[");

        for (int i = 0; i < size; ++i) {
            res.append(arr[i]);

            if (i != size - 1) {
                res.append(",");
            }
        }

        res.append("]");
        return res.toString();
    }
}
