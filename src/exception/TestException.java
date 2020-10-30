package exception;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;



public class TestException {
    public static void main(String[] args) {
        method1();
    }

    private static void method1() {
        try{
            method2();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private static void method2() throws FileNotFoundException {
        File f = new File("c:/LOL.exe");
        System.out.println("打开lol");
        new FileInputStream(f);
        System.out.println("打开了");
    }
}
