package day01;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class reflect {
    /**
     * 将需要创建的对象的全类名和需要执行的方法定义在配置文件中
     * 在程序中加载读取配置文件
     * 使用反射技术来加载类文件进内存
     * 创建对象
     *
     * */
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        ClassLoader cl = reflect.class.getClassLoader();
        //加载配置文件
        InputStream resource = cl.getResourceAsStream("day01/pro.properties");
        properties.load(resource);
        /**
         * 在给定的代码中，reflect.class.getClassLoader() 得到的是应用程序类加载器，
         * 这是因为 reflect 类是我们自己写的代码。然后通过应用程序类加载器，
         * 可以加载配置文件 pro.properties 并读取其中的数据。
         *
         * 需要注意的是，如果配置文件 pro.properties 不在类路径下，或者不存在，
         * 可能会导致 resource 为 null，进而引发空指针异常。
         * 因此在实际使用中，需要确保配置文件的正确路径和存在性，以避免出现异常。
         *
         * */

        //获取配置文件中搞的数据
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");

        Class<?> aClass = Class.forName(className);
        Object o = aClass.newInstance();
        Method method = aClass.getMethod(methodName,int.class,int.class);
        Object invoke = method.invoke(o, 2, 3);
        System.out.println(invoke);

    }
}
