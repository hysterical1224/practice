package com.example.jstl_mvc;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet_MVC", value = "/Servlet_MVC")
public class Servlet_MVC extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        2. MVC：
        //	1. M：Model，模型。JavaBean
        //		* 完成具体的业务操作，如：查询数据库，封装对象
        //	2. V：View，视图。JSP
        //		* 展示数据
        //	3. C：Controller，控制器。Servlet
        //		* 获取用户的输入
        //		* 调用模型
        //		* 将数据交给视图进行展示


        //MVC（Model-View-Controller）是一种常见的软件架构模式，用于组织和管理应用程序的代码。
        // 它将应用程序分为三个主要部分：模型（Model）、视图（View）和控制器（Controller）。每个部分都有不同的职责和作用。
        //
        //模型（Model）：
        //作用： 模型表示应用程序的数据和业务逻辑。它负责处理数据的存储、检索、更新和验证，以及执行与应用程序的核心功能相关的操作。
        //示例： 在一个电子商务应用中，模型可以包括产品信息、用户信息、订单信息等，以及与它们相关的数据库交互和业务规则。

        //视图（View）：
        //作用： 视图负责将模型的数据呈现给用户，并接收用户的输入。它通常负责渲染用户界面，以便用户可以查看和与数据交互。
        //示例： 在一个网页应用中，视图可以是网页的 HTML 和 CSS 部分，用于展示产品列表、购物车内容等。

        //控制器（Controller）：
        //作用： 控制器充当模型和视图之间的协调者。它接收来自用户界面的输入，根据输入调用适当的模型操作，然后更新视图以反映新的数据状态。
        //示例： 在一个在线商店应用中，控制器可以接受来自用户的购买请求，调用模型来处理购买操作，然后将更新后的购物车内容显示在用户的界面上。

        //MVC 模式的主要优点包括：
        //分离关注点：将应用程序的不同方面分离，使代码更易于管理和维护。
        //可重用性：模型、视图和控制器之间的分离允许它们在不同的上下文中重用。
        //并行开发：不同团队或开发者可以并行开发模型、视图和控制器的不同部分。
        //测试性：每个组件可以独立地进行单元测试。
        //需要注意的是，虽然 MVC 是一个常见的模式，但它并不是唯一的架构模式。在实际应用中，还可以使用其他模式，如MVVM（Model-View-ViewModel）、MVP（Model-View-Presenter）等，以满足特定需求和项目的要求。选择适当的模式通常取决于应用程序的规模、复杂性和开发团队的经验。
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
