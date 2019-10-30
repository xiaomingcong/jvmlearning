package jvmLearning.chapter03;

public class TestAllocation {
    private static final int _1MB = 1024 * 1024;

    /**
     * 对象优先在Eden分配
     * VM args : -verbose:gc -Xms20M -Xmx20m -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC
     * 因为jdk1。8默认使用parallel Scavenge收集器，这里使用参数指定Serial收集器 对比效果
     */

    public static void main(String[] args) {
        byte[] allocation1,allocation2,allocation3,allocation4,allocation5,allocation6;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];// 出现一次Minor GC
//        System.gc();
//        allocation5 = new byte[4 * _1MB];// 出现一次Minor GC
//        allocation6 = new byte[4 * _1MB];// 出现一次Minor GC

    }
}
