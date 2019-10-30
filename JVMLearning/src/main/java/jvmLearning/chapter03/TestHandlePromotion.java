package jvmLearning.chapter03;

/**
 * 空间分配担保
 * 在发生Minor GC之前，虚拟机会先检查老年代最大可用的连续空间是否大于新生代所有对象的总空间，如果这个条件成立，那么Minor GC可以确保是安全的。
 * 如果不成立，则虚拟机会查看HandlerPromotionFailure设置值是否允许担保失败。如果允许那么会继续检查老年代最大可用的连续空间是否大于历次晋升到老年代的对象的平均大小，
 * 如果大于，将尝试进行一次Minor GC，尽管这次Minor GC是有风险的；如果小于，或者HandlerPromotionFailure设置不允许，那么这时要改为进行一次Full GC
 *
 * JDK1.6 UPDATE24 之后的规则变为只要老年代的连续空间大于新生代对象总大小或者历次晋升的平均大小就会进行Minor GC，否则将进行Full GC
 * VM args: -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:-HandlePromotionFailure -XX:+UseSerialGC
 */
public class TestHandlePromotion {
    private static final int _MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1,allocation2,allocation3,allocation4,allocation5,allocation6,allocation7;
        allocation1 = new byte[2 * _MB];
        allocation2 = new byte[2 * _MB];
        allocation3 = new byte[2 * _MB];
        allocation1 = null;
        allocation4 = new byte[2 * _MB];
        allocation5 = new byte[2 * _MB];
        allocation6 = new byte[2 * _MB];
        allocation4 = null;
        allocation5 = null;
        allocation6 = null;
        allocation7 = new byte[2 * _MB];

    }
}
