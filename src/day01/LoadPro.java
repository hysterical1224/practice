package day01;


import java.lang.reflect.Method;

@Pro(className = "day01.Demo1",methodName = "show")
public class LoadPro {

    public static void main(String[] args) throws Exception, IllegalAccessException {
        Class<LoadPro> loadProClass = LoadPro.class;
        Pro annotation = loadProClass.getAnnotation(Pro.class);
        String className = annotation.className();
        String methodName = annotation.methodName();
        System.out.println(methodName);
        System.out.println(className);

        Class<?> loadPro = Class.forName(className);
        Object o = loadPro.newInstance();
        Method method = loadPro.getMethod(methodName);

        method.invoke(o);


    }
}
