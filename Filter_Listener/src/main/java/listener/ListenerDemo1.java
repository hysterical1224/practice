package listener;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@WebListener
public class ListenerDemo1 implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {
//在Java Web应用程序中，Listener（监听器）用于监听特定事件的发生，通常用于执行与这些事件相关的自定义操作。
// Listeners可以用于各种用途，如记录日志、统计信息、资源管理、权限检查等。
// 以下是一些常见的Listener以及它们在Web应用程序中的应用场景：
//
//ServletContextListener：
//
//应用初始化和销毁：当Web应用程序启动和关闭时，可以使用ServletContextListener来执行初始化和销毁操作。
// 例如，你可以在应用程序启动时加载配置文件或创建数据库连接池，在应用程序关闭时释放资源。
//ServletRequestListener 和 ServletRequestAttributeListener：
//
//请求生命周期事件：ServletRequestListener用于监听HTTP请求的创建和销毁事件，而ServletRequestAttributeListener用于监听请求属性的更改。这些监听器可用于记录请求信息、检查用户权限、处理国际化等。
//HttpSessionListener 和 HttpSessionAttributeListener：
//
//会话管理：HttpSessionListener用于监听用户会话的创建和销毁，而HttpSessionAttributeListener用于监听会话属性的更改。这些监听器通常用于跟踪用户在线状态、管理会话数据等。
//ServletContextAttributeListener：
//
//ServletContext属性变化：可以用于监听ServletContext中的属性变化。这对于在应用程序中共享全局数据很有用。
//ServletRequestListener：
//
//请求和会话监控：可以用于监控特定请求或会话的生命周期事件。例如，记录请求处理时间或跟踪会话信息。
//HttpSessionBindingListener 和 HttpSessionActivationListener：
//
//会话中的对象监听：这些监听器用于监听会话中的对象绑定和激活事件。它们通常与会话中的自定义Java对象一起使用，以执行特定的操作，例如在对象绑定或激活时执行某些逻辑。
//AsyncListener：
//
//异步处理：在Servlet 3.0及更高版本中，可以使用AsyncListener来监听异步请求的完成、超时和错误事件。这对于异步处理非常有用。
//这些监听器可以通过在web.xml文件中配置或使用Servlet 3.0的注解来注册。
    public ListenerDemo1() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
//        加载资源文件
//        1.获取ServletContext对象
        ServletContext sc = sce.getServletContext();
//        2.加载资源文件
        String ccl = sc.getInitParameter("contextConfigLocation");
        System.out.println(ccl);

        String realPath = sc.getRealPath(ccl);
        try {
            FileInputStream fis = new FileInputStream(realPath);
            System.out.println(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("ServletContext对象被创建了。。。");






        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is added to a session. */
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is removed from a session. */
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is replaced in a session. */
    }
}
