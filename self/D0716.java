import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class D0716 {
    
    public static void main(String[] args) throws InterruptedException {
        // TestProcessor.process(NeedTest.class);

        // MyThread thread = new MyThread();
        // thread.start();

        // LiftOff off = new LiftOff();
        // off.run();
        // System.out.println("AAA");

        ExecutorService exec = Executors.newCachedThreadPool();
        // ExecutorService exec = Executors.newFixedThreadPool(3);
        for(int i=0; i<5; i++)
            exec.execute(new LiftOff());
        // Thread.sleep(500);
        System.out.println("Hello ");
        exec.shutdown();
    }
    
}

class LiftOff implements Runnable {
    private static int taskCount = 0;
    private final int id = taskCount++;
    @Override
    public void run() {
        for(int i=0; i<10; i++)
            System.out.println("["+id+"]("+Thread.currentThread().getId()+") " + i);
        System.out.println("["+id+"] QAQ");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for(int i=10; i<20; i++) 
            System.out.println(i);
    }
}

class NeedTest {
    @Test
    public void run() {
        System.out.println("I'm running my Test...");
    }
}

/**
 * 模拟JUnit实现单元测试
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Test {}

/**
 * @Test注解处理器
 */
class TestProcessor {
    public static void process(Class cl) {
        try {
            Object obj = cl.newInstance();
            for(Method method: cl.getDeclaredMethods()) {
                // System.out.println("--> "+method.getName());
                Annotation[] anns = method.getDeclaredAnnotations();
                if(anns.length < 1)
                    continue;
                if(anns[0] instanceof Test) {
                    System.out.println("==== [Testing]: " + method.getName() + " ====");
                    try {
                        method.invoke(obj);
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }

            System.out.println("==== you have passed this test. ====");
        } catch(InstantiationException|IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}