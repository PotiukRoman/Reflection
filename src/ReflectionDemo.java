import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionDemo {

    public static void main(String args[]) throws Exception
    {
        Test testObj = new Test();
        Test testObj1 = new Test();

        Class classObject = testObj.getClass();

        System.out.println("The name of class is " + classObject.getName());

        Constructor constructor = classObject.getConstructor();

        System.out.println("The name of constructor is " + constructor.getName());

        System.out.println("The public methods of class are : ");

        Method[] methods = classObject.getMethods();

        for (Method method : methods)
            System.out.println(method.getName());

        Method methodcall1 = classObject.getDeclaredMethod("method1");

        methodcall1.invoke(testObj);
        methodcall1.invoke(testObj1);

        Field field = classObject.getDeclaredField("s");

        field.setAccessible(true);

        field.set(testObj, "testObj TestStringChanged");
        field.set(testObj1, "testObj1 TestStringChanged");

        methodcall1.invoke(testObj);
        methodcall1.invoke(testObj1);

        Method methodcall2 = classObject.getDeclaredMethod("method2", int.class);

        methodcall2.invoke(testObj, 25);

        Method methodcall3 = classObject.getDeclaredMethod("method3");

        methodcall3.setAccessible(true);

        methodcall3.invoke(testObj);
    }
}
