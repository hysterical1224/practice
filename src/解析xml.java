import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class 解析xml {
    public static void main(String[] args) throws IOException {
        /*
        1. Jsoup：工具类，可以解析html或xml文档，返回Document
			* parse：解析html或xml文档，返回Document
				* parse(File in, String charsetName)：解析xml或html文件的。
				* parse(String html)：解析xml或html字符串
				* parse(URL url, int timeoutMillis)：通过网络路径获取指定的html或xml的文档对象
		2. Document：文档对象。代表内存中的dom树
			* 获取Element对象
				* getElementById(String id)：根据id属性值获取唯一的element对象
				* getElementsByTag(String tagName)：根据标签名称获取元素对象集合
				* getElementsByAttribute(String key)：根据属性名称获取元素对象集合
				* getElementsByAttributeValue(String key, String value)：根据对应的属性名和属性值获取元素对象集合
		3. Elements：元素Element对象的集合。可以当做 ArrayList<Element>来使用
		4. Element：元素对象
			1. 获取子元素对象
				* getElementById(String id)：根据id属性值获取唯一的element对象
				* getElementsByTag(String tagName)：根据标签名称获取元素对象集合
				* getElementsByAttribute(String key)：根据属性名称获取元素对象集合
				* getElementsByAttributeValue(String key, String value)：根据对应的属性名和属性值获取元素对象集合

			2. 获取属性值
				* String attr(String key)：根据属性名称获取属性值
			3. 获取文本内容
				* String text():获取文本内容
				* String html():获取标签体的所有内容(包括字标签的字符串内容)
		5. Node：节点对象
			* 是Document和Element的父类
        *
        *
        * */
        String path = 解析xml.class.getClassLoader().getResource("student.xml").getPath();
        System.out.println("yahahha\n"+ path);
        Document dom = Jsoup.parse(new File(path),"utf-8");
        Elements eles = dom.getElementsByTag("name");
        Element element = eles.get(0);
        String name = element.text();
        System.out.println(name);
        //document.getElementById 是在整个文档范围内查找元素，
        // 而 Element.getElementById 是在特定元素内查找子元素。

        Elements students = dom.getElementsByTag("student");
        for (int i=0;i< students.size();i++){
            Elements name1 = students.get(i).getElementsByTag("name");
            System.out.println(name1.html());

        }
        System.out.println(students.get(0).attr("number"));

    }
//    Element.html():
    //这是一个方法，用于获取或设置 HTML 元素的内部 HTML 内容。
    //当调用 Element.html() 时，它返回该元素内部的 HTML 代码，包括标签和文本内容。
    //当你提供一个字符串作为参数给 Element.html() 时，它会将该字符串作为新的 HTML 内容设置到元素内，覆盖原有的内容。


//    Element.text():
    //这是一个方法，用于获取或设置 HTML 元素的内部文本内容。
    //当调用 Element.text() 时，它返回该元素内部的纯文本内容，忽略所有 HTML 标签。
    //当你提供一个字符串作为参数给 Element.text() 时，它会将该字符串作为新的纯文本内容设置到元素内，覆盖原有的内容。
}
