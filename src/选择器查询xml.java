import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class 选择器查询xml {

    public static void main(String[] args) throws IOException {
        //Elements select(String cssQuery) 是 Jsoup 库中的一个方法，用于根据给定的 CSS 选择器查询语法选择匹配的元素集合。
        // 这个方法会返回一个 Elements 对象，其中包含了符合选择器条件的所有 DOM 元素。
        //
        //Elements: 这是 Jsoup 库中的一个类，代表了一组 DOM 元素。它类似于 Java 中的 List，但专门用于存储和操作 HTML 或 XML 元素。
        //
        //select(String cssQuery): 这是 Elements 类的方法之一。
        // 它接收一个字符串参数 cssQuery，这个参数是一个 CSS 选择器字符串，用于指定需要选择的元素。
        // 方法会根据选择器规则在 HTML 或 XML 文档中定位匹配的元素，并将它们存储在 Elements 对象中。


        //dom.select("p") 使用 CSS 选择器 "p" 选择了所有 <p> 元素，并将它们存储在 Elements 对象中。
        // 然后，通过遍历 Elements 对象，我们可以访问每个选中元素的文本内容。




        //        快捷查询方式：
        //		1. selector:选择器
        //			* 使用的方法：Elements select(String cssQuery)
        //				* 语法：参考Selector类中定义的语法
        //		2. XPath：XPath即为XML路径语言，它是一种用来确定XML（标准通用标记语言的子集）文档中某部分位置的语言
        //			* 使用Jsoup的Xpath需要额外导入jar包。
        //			* 查询w3cshool参考手册，使用xpath的语法完成查询
        //			* 代码：
        //				//1.获取student.xml的path
        //		        String path = JsoupDemo6.class.getClassLoader().getResource("student.xml").getPath();
        //		        //2.获取Document对象

        String path = 解析xml.class.getClassLoader().getResource("student.xml").getPath();
        System.out.println("yahahha\n"+ path);
        Document dom = Jsoup.parse(new File(path),"utf-8");

        Elements stu = dom.select("student[number=\"0001\"]>age");
//        >: 这是子元素选择器，它指定了要选择的 "student" 元素的直接子元素。
        System.out.println(stu);
//

    }
}
