package day01;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 注解默认的保留策略是RetentionPolicy.CLASS，这意味着注解在编译时会被保留在.class文件中，
 * 但在运行时是不可获取的。如果我们希望在运行时通过反射来获取注解的元数据信息，
 * 就需要将注解的保留策略设置为RetentionPolicy.RUNTIME。
 *
 * 在上述代码中，如果Anno注解没有显式指定保留策略，那么默认情况下它的保留策略是CLASS，
 * 这会导致在运行时无法通过clazz.getAnnotation(Anno.class)来获取MyClass类上的Anno注解，
 * 从而会抛出NullPointerException。
 *
 * 为了使得注解在运行时可以被获取到，我们需要在定义Anno注解时，
 * 使用@Retention元注解并将其保留策略设置为RetentionPolicy.RUNTIME，
 * 即@Retention(RetentionPolicy.RUNTIME)。这样一来，注解的元数据信息将会在运行时保留，
 * 并且我们就可以在运行时通过反射来获取类上标注的Anno注解及其属性值。
 *
 *
 * */

@Retention(RetentionPolicy.RUNTIME)
public @interface Anno2 {
    /**
     * public @interface name {}是Java中定义自定义注解的语法格式。
     * 在这里，name表示自定义注解的名称，可以根据需要自定义合适的名称。
     * 自定义注解使用@interface关键字来定义，其实质是一种特殊的接口类型。
     * 注解可以包含成员变量和方法，成员变量用来存储注解的配置信息，
     * 而方法用于指定注解的行为。
     * 自定义注解的成员变量可以设置默认值，
     * 这样在使用注解时可以选择是否指定该成员变量的值。
     * */
    String value() default "value";
    int count() default 0;
    int yahaha = 12;
    //属性的返回值类型有下列取值
    //基本数据类型
    //头string
    //枚举
    //注解头
    //以上类型的数组

}
