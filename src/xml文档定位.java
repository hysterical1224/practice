import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class xml文档定位 {

    //XPath（XML Path Language）是一种用于在 XML 文档中定位和选择节点的语言。
    // 它类似于在文件系统中使用路径来定位文件一样，在 XML 中使用 XPath 可以定位和选择 XML 文档中的特定元素和属性。
    //XPath 提供了一种灵活的方式来导航和查询 XML 结构。它使用路径表达式来描述节点的位置和关系，从而允许你从根节点开始，通过不同的路径在 XML 树中导航到所需的节点。
    //以下是一些 XPath 表达式的示例，以帮助理解它的工作原理：
    //
    //  /bookstore: 选择文档的根元素 "bookstore"。
    //  /bookstore/book: 选择根元素下的所有 "book" 元素。
    // /bookstore/book[1]: 选择第一个 "book" 元素。
    // /bookstore/book[@category='fantasy']: 选择具有 "category" 属性值为 "fantasy" 的所有 "book" 元素。

//    在 XPath 表达式中，@ 符号用于引用节点的属性。当你想选择具有特定属性值的元素时，需要使用 @ 符号来标识属性。



    // //title: 选择文档中的所有 "title" 元素，不论它们在哪个层次。
    // /bookstore/book/title/text(): 选择所有 "book" 元素下的 "title" 元素的文本内容。

    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        String path = 解析xml.class.getClassLoader().getResource("student.xml").getPath();
        System.out.println("yahahha\n"+ path);
        Document dom = Jsoup.parse(new File(path),"utf-8");
        JXDocument jxd = new JXDocument(dom);
        //document 是 jsoup 库中的一个类，用于表示 HTML 或 XML 文档的整个内容。它提供了许多方法来解析、查询和操作文档的元素和内容。
        //
        //JXDocument 是 jsoup-xpath 库中的一个类，它实际上是对 jsoup 的扩展，用于在文档中使用 XPath 表达式进行元素选择和查询。
        // jsoup-xpath 扩展使得在 jsoup 文档中使用更灵活和强大的 XPath 查询变得可能。
        List<JXNode> jxNodes = jxd.selN("//student");

        //selN() 方法会根据给定的 XPath 表达式执行查询，然后返回一个包含所有匹配元素的列表。
        // 如果没有匹配的元素，列表将为空。如果有匹配的元素，列表将包含这些匹配的元素。
        // 这样，你可以使用 selN() 方法来在文档中查找符合特定条件的元素集合。
        for (JXNode jxNode:jxNodes) {
            System.out.println(jxNode);
            System.out.println("----------");
        }

        List<JXNode> jxNode4 = jxd.selN("//student[@number='0001']");
        for (JXNode jxNode:jxNode4) {
            System.out.println(jxNode);
            System.out.println("+++++++++++++++++++++++");
        }

    }
}
