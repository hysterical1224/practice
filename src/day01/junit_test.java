package day01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class junit_test {
    /**
     * 注解支持：JUnit 使用注解来标记测试方法和测试类，简化测试代码的编写和维护。
     * 断言：JUnit 提供了一组断言方法，用于验证测试的预期结果和实际结果是否一致。如果断言失败，测试将被标记为失败。
     * 测试运行器：JUnit 提供了多个测试运行器，用于控制测试的执行顺序和方式。
     * 参数化测试：JUnit 支持参数化测试，允许多次运行同一个测试方法，但使用不同的输入参数进行测试。
     * 异常测试：JUnit 允许测试方法捕获和验证预期的异常情况。
     * 扩展性：JUnit 提供了丰富的扩展点和插件机制，允许用户定制和扩展测试框架的功能。
     *
     *
     *
     * */
    @Before
    public void init(){
        //修饰的方法会在测试方法之前被自动执行
        System.out.println("初始化一下！");
    }

    @After
    public void close(){
        //修饰的方法会在测试方法执行之后自动被执行
        System.out.println("Game Over!");
    }

    @Test
    public void addTest(){
        calculator calculator = new calculator();
        int result = calculator.add(1, 2);
        System.out.println(result);

        Assert.assertEquals(3,result);

    }
    /**
     * 常用的方法：
     * @Test：用于标记测试方法，JUnit 会执行带有 @Test 注解的方法，并验证测试结果。
     * assertEquals(expected, actual)：断言方法，用于验证预期结果和实际结果是否相等。
     * assertTrue(boolean condition)：断言方法，用于验证条件是否为 true。
     * assertFalse(boolean condition)：断言方法，用于验证条件是否为 false。
     * assertNull(Object object)：断言方法，用于验证对象是否为 null。
     * assertNotNull(Object object)：断言方法，用于验证对象是否不为 null。
     * assertSame(expected, actual)：断言方法，用于验证两个对象引用是否指向同一个对象。
     * assertNotSame(expected, actual)：断言方法，用于验证两个对象引用是否指向不同的对象。
     * assertArrayEquals(expected, actual)：断言方法，用于验证两个数组是否相等。
     * fail(String message)：用于在测试方法中显式地标记测试失败，可以在测试逻辑中手动调用。
     * */

}
