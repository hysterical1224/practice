package com.example.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletSession", value = "/ServletSession")
public class ServletSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
//        Session 和 Cookie 都是用于在 Web 应用程序中存储用户数据的方式，但它们之间有一些重要的区别：
        //
        //Cookie：
        //位置：Cookie 是存储在客户端（浏览器）的小型文本文件中，每次请求都会将 Cookie 信息发送到服务器。
        //
        //存储容量：每个 Cookie 的存储容量通常有限，一般不超过4KB。因此，Cookie 适合存储小量的数据，如用户的偏好设置、登录状态等。
        //
        //安全性：Cookie 数据存储在客户端，因此可能被恶意用户访问和篡改。为了增加安全性，可以对 Cookie 设置一些属性，如设置为仅在 HTTPS 连接下传输。
        //
        //跨域限制：Cookie 受同源策略的限制，只能访问创建它的域名。如果需要在不同域名之间共享数据，通常需要通过设置 Cookie 的域名属性来实现。
        //
        //Session：
        //
        //位置：Session 数据通常存储在服务器上，客户端仅存储一个唯一的会话标识符（通常是 SessionID）。
        //
        //存储容量：与 Cookie 不同，Session 在服务器上存储，因此理论上可以存储更大的数据量，但实际上仍然受服务器资源的限制。
        //
        //安全性：Session 数据存储在服务器上，客户端无法直接访问或篡改。这使得 Session 数据相对更安全，适用于存储敏感信息，如用户身份验证信息。
        //
        //跨域限制：Session 通常不受同源策略的限制，允许在不同域名之间共享数据，前提是服务器配置允许跨域访问。
        //
        //使用场景：
        //
        //使用 Cookie 适合存储一些非敏感的客户端数据，如用户偏好设置、购物车信息等。
        //使用 Session 适合存储敏感信息，如用户身份验证信息、购买历史记录等，因为 Session 数据存储在服务器端，更加安全。
        //通常，Web 应用程序会综合使用 Cookie 和 Session，以满足不同的需求。
        // 例如，使用 Cookie 存储用户登录状态的标识符，而将实际的用户数据存储在 Session 中，以确保安全性和隐私。



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        org.apache.catalina.session.StandardSessionFacade@2eac1a2d
        HttpSession session = request.getSession();
        System.out.println(session);
        //Session 的标识符通常存储在 Cookie 中： 当用户首次访问网站时，服务器会创建一个唯一的 Session 标识符（通常称为 SessionID），
        //然后将这个 SessionID 存储在一个名为 JSESSIONID 的 Cookie 中，然后将该 Cookie 发送给客户端。
        //客户端浏览器会在随后的每个请求中自动将这个 Cookie 发送回服务器。这个 SessionID 用于标识用户的会话，
        //服务器可以根据它查找和恢复用户的 Session 数据。
        //
        //Session 数据存储在服务器端： 用户的 Session 数据实际上存储在服务器的内存或持久化存储中，而不是存储在客户端。
        // Session 数据通常包括用户的登录状态、购物车内容、个人配置等。通过 Cookie 中的 SessionID，服务器能够关联每个请求到正确的 Session 数据。
        //
        //Cookie 用于标识和管理会话： Cookie 主要用于标识和管理用户会话。它可以包含一些会话相关的信息，但不应该包含敏感数据。
        // 通过 Cookie，Web 应用可以在客户端和服务器之间保持会话状态。
        //
        //Session 用于存储和管理会话数据： Session 用于存储和管理与用户会话相关的数据。
        // 它提供了一个安全的存储位置，用于存储敏感数据，如用户身份验证信息、购物车内容等。
        //
        //综上所述，Cookie 和 Session 是两个不同的概念，但它们通常一起使用以实现用户会话的管理。Cookie 用于标识和管理会话，而 Session 用于存储和管理会话数据。
        // 通过将 SessionID 存储在 Cookie 中，服务器能够将每个请求与正确的 Session 数据关联起来，实现了用户会话的持续性和状态管理。


        //Session 钝化（Passivation）和活化（Activation）是与分布式应用程序和会话管理相关的概念，通常在持久性会话管理中使用。
        // 这两个概念主要与 Java EE（Enterprise Edition）平台中的分布式 Web 应用程序开发相关。下面我将详细解释这两个概念：
        //
        //Session 钝化（Passivation）：
        //钝化是指将会话状态从内存中写入到持久性存储（通常是磁盘）的过程。这通常在会话不活动（Idle）或服务器需要释放内存资源时发生。
        //在 Java EE 中，HttpSession 对象（也就是 Web 应用程序中的会话对象）通常存储在服务器的内存中。
        //如果有太多的会话对象或服务器需要释放内存以响应其他请求，那么一些会话对象可能会被钝化到持久性存储中。
        //钝化会话后，会话状态被序列化为一个二进制对象并写入到持久性存储。这可以是数据库、文件系统或其他持久性存储机制。
        //钝化并不会终止会话，只是将其状态保存到磁盘上。当客户端再次访问该会话时，它会被活化并恢复到内存中，客户端无感知。
        //钝化和活化过程通常是由应用服务器自动管理的，开发人员不需要直接干预。


        //Session 活化（Activation）：
        //活化是指将会话状态从持久性存储重新加载到内存中的过程。
        //当客户端再次访问之前被钝化的会话时，应用服务器会执行活化操作，将持久化的会话状态读取到内存中，以便继续处理客户端请求。
        //活化会话后，客户端可以继续与会话进行交互，就像从未发生过钝化一样。
        //总的来说，Session 钝化和活化是用于管理持久性会话状态的机制。它们使得 Web 应用程序能够有效地处理大量会话对象，同时在需要时将会话状态保存到持久性存储中以释放内存资源。这有助于提高 Web 应用程序的可伸缩性和性能。开发人员通常不需要手动管理这些过程，因为应用服务器会自动处理钝化和活化。



    }
}
