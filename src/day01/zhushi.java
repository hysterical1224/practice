package day01;

public class zhushi {
    /**
     * @version 1.0
     * @since 2023-07-26
     * */


    /**
     * 注释：用文字描述程序的，给程序员看
     * 注解：说明程序的，给计算机看的
     *
     * 注解可以用于不同的用途，例如：
     * 提供编译器静态检查：可以使用注解来进行编译时的静态检查，帮助发现潜在的问题和错误。
     * 自动生成代码：通过注解处理器，可以根据注解信息生成额外的代码，如生成日志、序列化代码等。
     * 运行时的行为：某些框架或库在运行时可以根据注解信息来动态地调整行为，如Spring框架中的依赖注入。
     * 文档生成：注解可以用于生成文档或API文档，提供更加丰富和准确的文档信息。
     *
     * 在上面的例子中，我们使用了@version注解来标记类的版本信息，
     * since 注解标记类的引入时间，而在方法中使用了@param注解标记方法参数的说明，
     * return 注解标记返回值的说明，@throws注解标记方法抛出异常的说明。
     * 当我们使用Javadoc工具来生成API文档时，这些Javadoc注解就会被提取出来，
     * 生成相应的文档内容。
     *
     *
     * @param x 第一个参数
     * @param x 第一个参数
     * @return 返回x和y的和
     * @throws IllegalArgumentException 当x和y为负数时抛出异常
     *
     * */
    public int add(int x, int y) throws IllegalArgumentException {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("参数不能为负数");
        }
        return x + y;
    }


}
