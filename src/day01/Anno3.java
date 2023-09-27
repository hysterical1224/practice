package day01;

import java.lang.annotation.*;

/**
 * @Retention: 用于指定注解的保留策略，即注解在代码运行时期间是否可用。
 * 可选的保留策略有RetentionPolicy.SOURCE、RetentionPolicy.CLASS和RetentionPolicy.RUNTIME。
 * 其中，RetentionPolicy.SOURCE表示注解仅在源代码中可用，
 * 不会被编译器保留；RetentionPolicy.CLASS表示注解在编译时会被保留，
 * 但不会被加载到JVM中；RetentionPolicy.RUNTIME表示注解在运行时会被保留，
 * 并可以通过反射获取。
 *
 * @Target: 用于指定注解的作用目标，即注解可以用于哪些程序元素上。
 * 可选的作用目标有
 * ElementType.TYPE、作用于类上
 * ElementType.FIELD、
 * ElementType.METHOD、
 * ElementType.PARAMETER、
 * ElementType.CONSTRUCTOR、
 * ElementType.LOCAL_VARIABLE等。
 *
 * @Documented: 用于指定注解是否包含在JavaDoc中。
 *
 * @Inherited: 用于指定注解是否可以被继承。
 *
 * @Repeatable: 用于指定注解是否可重复使用。
 *
 *
 * */

@Target(value = {ElementType.TYPE})
public @interface Anno3 {
    //@Target 是 Java 元注解之一，用于指定自定义注解可以应用的目标元素。
    // 通过 @Target 可以限定自定义注解的使用范围，
    // 避免将注解错误地应用于不允许的地方。


}
