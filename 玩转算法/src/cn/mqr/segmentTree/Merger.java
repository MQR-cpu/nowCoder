package cn.mqr.segmentTree;

public interface Merger<E> {
    E merger(E a, E b);
}
