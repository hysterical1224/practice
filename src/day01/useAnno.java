package day01;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/**
 *
 * 类中的字段是指类的成员变量。
 *定义注解可以应用于字段（成员变量）或方法等元素。
 * 当自定义注解应用于字段时，可以为字段添加额外的元数据信息。
 * 这些额外的信息可以在运行时被读取，并根据注解的内容进行相应的处理。
 *
 * 类中某个字段的注解和类的元数据信息注解有以下区别：
 * 位置不同：类中某个字段的注解是针对类中特定字段的，而类的元数据信息注解是针对整个类的。
 * 作用范围不同：类中某个字段的注解只对该字段起作用，而类的元数据信息注解对整个类起作用。
 * 获取方式不同：类中某个字段的注解可以通过反射获取字段对象，再通过字段对象获取注解；
 * 而类的元数据信息注解可以直接通过反射获取类对象，再通过类对象获取注解。
 * 用途不同：类中某个字段的注解可以用于对字段进行标记，从而实现某种功能；
 * 而类的元数据信息注解可以用于对整个类进行标记，如指定类的行为、特性等。
 *
 *
 * */


public class useAnno {
    /**
     * clazz.getAnnotation(Anno.class)是Java反射API中的一种用法，
     * 用于获取指定类或方法上的特定注解。让我们逐步解析这行代码：
     * clazz: 这是一个Class类型的对象，表示一个类的元数据信息。
     * 通过Class对象，我们可以获取类的各种信息，包括类的名称、字段、方法等。
     *
     * Anno.class: 这是一个注解类型的类对象。
     * 在这里，Anno是您定义的注解类的名称，.class是Java中获取类对象的方式。
     * 当您调用clazz.getAnnotation(Anno.class)时，
     * 它会在给定的类（或方法）上搜索名为Anno的注解，并返回找到的注解对象。
     * 如果找不到该注解，则返回null
     *
     *
     * */

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException, NoSuchMethodException {
        Class<MyClass> clazz = MyClass.class;
        Anno ann = clazz.getAnnotation(Anno.class);
        /**
         * 获取使用Anno注解的Class是为了获取类上标注的特定注解的元数据信息。
         * 我们通过clazz.getAnnotation(Anno.class)来获取MyClass类上标注的Anno注解的元数据信息。
         *
         * 通过获取注解的元数据信息，我们可以在运行时动态地获取注解的属性值，
         * 从而根据注解的信息做相应的处理。注解在Java中常常用于在代码中添加一些标记或元数据信息，
         * 以供其他程序或工具在编译时、运行时进行解析和处理。
         *
         * 举个例子，假设Anno注解标注了某个类，而注解中的属性value表示一些配置信息。
         * 通过获取Anno注解的元数据信息，我
         * 们可以根据注解中的配置信息来动态地初始化对象、生成代码或执行特定的逻辑。
         * 注解的使用可以使得代码更具有灵活性和可配置性。
         * */
        System.out.println(ann.value());
        System.out.println(ann.count());


        Field myField = clazz.getDeclaredField("myField");
        Anno ann1 = myField.getAnnotation(Anno.class);
        System.out.println(ann1.value());
        System.out.println(ann1.yahaha);

        Method method = clazz.getDeclaredMethod("myMethod");
        Anno ann2 = method.getAnnotation(Anno.class);
        System.out.println(ann2.value());


    }
    /**
     * 在Java中，类的元数据信息包含了以下内容：
     *
     * 类的名称：类的全限定名，包括包名和类名。
     * 类的修饰符：类的访问修饰符，如public、private、protected等。
     * 父类信息：类继承的父类。
     * 接口信息：类实现的接口。
     * 成员变量：类中定义的字段（属性）信息，包括字段名称、类型、访问修饰符等。
     * 成员方法：类中定义的方法信息，包括方法名称、参数列表、返回类型、访问修饰符等。
     * 构造方法：类中定义的构造方法信息，包括参数列表、访问修饰符等。
     * 注解：类上标注的注解信息，包括注解的名称和属性值。
     * 类加载器：加载类的ClassLoader对象，用于加载类的字节码文件到内存中。
     * 其他元数据：还可能包括泛型信息、内部类信息等。
     * 通过Java的反射API，可以获取类的元数据信息，从而在运行时动态地了解和操作类的结构和特性。
     * 这使得Java具有很强的灵活性和可扩展性，
     * 可以在运行时根据类的元数据信息进行动态的代码生成、对象实例化、方法调用等操作。
     *
     * */
}
