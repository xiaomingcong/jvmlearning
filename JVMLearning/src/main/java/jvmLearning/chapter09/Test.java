package jvmLearning.chapter09;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Test {
    public static void main(String[] args) throws IOException {
        String userDir=System.getProperty("user.dir");

        System.out.println(System.getProperty("user.dir"));
        InputStream is = new FileInputStream(userDir+"/target/classes/jvmLearning/chapter09/TestClass.class");
        byte[] b = new byte[is.available()];
        is.read(b);
        is.close();
        System.out.println(JavaClassExcuter.execute(b));
    }
}
