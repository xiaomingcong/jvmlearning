package jvmLearning.chapter06;

public class TestClass {

    public static int  t = 2;

    private int m;

    public int inc(){
        ClassLoader classLoader = java.lang.Thread.currentThread().getContextClassLoader();
        return m + 1;
    }
}
