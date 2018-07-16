import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class D0716 {
    
    public static void main(String[] args) {
        TestProcessor.process(NeedTest.class);
    }
    
}


class NeedTest {
    @Test
    public void run() {
        System.out.println("I'm running my Test...");
    }
}

/**
 * ģ��JUnitʵ�ֵ�Ԫ����
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Test {}

/**
 * @Testע�⴦����
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