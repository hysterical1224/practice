package com.example.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletCookie", value = "/ServletCookie")
public class ServletCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * Cookie 是存储在用户计算机上的小型文本文件，用于在客户端和服务器之间传递数据。
         * 它通常由服务器在响应 HTTP 请求时通过响应头的 Set-Cookie 字段发送给客户端，
         * 然后客户端会将 Cookie 存储起来，并在后续的请求中通过请求头的 Cookie 字段将其发送回服务器。
         *
         * Cookie 的主要特点包括：
         * 持久性： Cookie 可以设置过期时间，可以是临时性的会话 Cookie，也可以是长期存储的持久性 Cookie。
         * 域名限制： Cookie 可以设置只在特定域名下有效，这样可以实现多个子域名之间共享 Cookie。
         * 大小限制： 每个域名下的 Cookie 数量和总大小都有限制。
         * 安全性： 由于 Cookie 存储在用户的计算机上，因此可以被用户查看和编辑，所以敏感信息应当进行加密和安全处理。
         *
         * Session：
         * Session 是服务器端用来存储用户数据的一种机制。
         * 每个用户会话都有一个唯一的标识符，通常是一个会话 ID。在客户端的请求中，可以通过 Cookie 或者 URL 参数将会话 ID 发送给服务器，
         * 服务器根据这个 ID 来找到对应的会话数据。
         *
         * Session 的主要特点包括：
         * 服务器端存储： 会话数据存储在服务器上，对客户端不可见。
         * 数据隔离： 不同用户的会话数据是相互隔离的，每个用户只能访问自己的会话数据。
         * 数据容量： 由于数据存储在服务器上，会话可以存储较大的数据。
         * 生命周期： 会话可以有不同的生命周期，例如基于时间的过期或用户退出时的销毁。
         *
         * Cookie 和 Session 的关系：
         * 通常情况下，服务器在创建会话时会生成一个唯一的 Session ID，并将其放入一个 Cookie 中发送给客户端，客户端在后续的请求中会携带这个 Cookie。
         * 服务器根据客户端发送的 Session ID 来找到对应的会话数据，从而实现在不同请求之间保持用户状态。
         * 通过结合使用 Cookie 和 Session，可以在客户端和服务器之间实现数据的传递和状态的保持。
         * 总的来说，Cookie 和 Session 是用来在客户端和服务器之间传递数据、实现状态保持的重要机制，各自有不同的特点和适用场景。
         *
         *
         *
         * */
        Cookie cookie = new Cookie("msg","yahah");

        //Cookie cookie = new Cookie("cookieName", "cookieValue");
        //cookie.setDomain(".example.com");
        //response.addCookie(cookie);
        //         如果您的项目托管在不同的子域名下，例如一个项目在 http://project1.example.com，另一个项目在 http://project2.example.com，
        //         您可以设置 Cookie 的 Domain 属性来使它们共享 Cookie。要实现这一点，您需要确保在设置 Cookie 时将 Domain 属性设置为主域名，
        //         例如 .example.com，而不是特定的子域名。
        response.addCookie(cookie);
        cookie.setDomain("localhost");
        cookie.setPath("../../../../");
        cookie.setSecure(false);
        ServletContext servletContext = this.getServletContext();
        System.out.println(servletContext.getRealPath("./"));

        //Cookie 主要用于存储少量的文本数据，通常用于在客户端和服务器之间传递一些简单的状态信息。以下是一些常见的用途和存储的数据类型：
        //
        //会话标识： Cookie 最常用于存储会话标识符（Session ID），以便在客户端和服务器之间维护用户会话状态。
        //用户偏好设置： 例如语言、主题、字体大小等用户偏好设置可以通过 Cookie 存储在客户端，以便在用户下次访问时恢复。
        //购物车数据： 在电子商务网站中，购物车中的商品信息可以存储在 Cookie 中，使得用户关闭浏览器后仍能保持购物车状态。
        //记住登录状态： 记住登录状态的功能可以通过在 Cookie 中存储用户的身份令牌或其他认证信息来实现。
        //广告跟踪： 广告公司可以通过 Cookie 跟踪用户的浏览行为，从而提供个性化广告。
        //统计信息： 一些网站使用 Cookie 来跟踪用户访问的页面、点击率等统计信息。
        //临时状态信息： 一些临时性的状态信息，如展示过的通知、提示等，可以存储在 Cookie 中，以便在用户刷新页面时不重复显示。
        //防止重复提交： 在一些表单提交场景中，可以通过设置 Cookie 来防止用户重复提交相同的表单。


        /**
         * cookie在浏览器中保存多长时间？
         * 		1. 默认情况下，当浏览器关闭后，Cookie数据被销毁
         * 		2. 持久化存储：
         * 			* setMaxAge(int seconds)
         * 				1. 正数：将Cookie数据写到硬盘的文件中。持久化存储。并指定cookie存活时间，时间到后，cookie文件自动失效
         * 				2. 负数：默认值
         * 				3. 零：删除cookie信息
         *
         *
         *
         * */
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
