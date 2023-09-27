package com.example.day_tomcat;

import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet(name = "ServletCheckCode", value = "/ServletCheckCode")
public class ServletCheckCode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html; charset=utf-8");

//        int width = 200;
//        int height = 50;
//
//        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
//
//
//        Graphics gra = bufferedImage.getGraphics();
//        //设置画笔颜色
//        gra.setColor(Color.pink);
//        //从哪个坐标开始填充，后两个参数，矩阵区域
//        gra.fillRect(0, 0, width, height);
//
//        String wa = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM123456789";
//        for (int i=1;i<=4;i++) {
//            Random rd = new Random();
//            int idx = rd.nextInt(wa.length());
//            char ch = wa.charAt(idx);
//            gra.drawString(ch+"", width/5*i, height/2 );
//
//        }
//        ImageIO.write(bufferedImage,"jpg",response.getOutputStream());

        //创建一张图片
        BufferedImage image = new BufferedImage(200, 100, BufferedImage.TYPE_INT_RGB);

        //透明玻璃
        Graphics2D gra = image.createGraphics();
        //设置画笔颜色
        gra.setColor(Color.white);
        //从哪个坐标开始填充，后两个参数，矩阵区域
        gra.fillRect(0, 0, 200, 100);

        //产生4个一位数的随机数
        List<Integer> randList = new ArrayList<Integer>();
        Random rand = new Random();
        for(int i=0; i < 4; i++) {
            randList.add(rand.nextInt(10));
        }

        //设置画笔的颜色及样式
        gra.setColor(Color.BLACK);
        gra.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,40));
        Color[] colors = new Color[] {Color.RED,Color.YELLOW,Color.BLUE,Color.GREEN,Color.PINK,Color.GRAY};

        //将rand产生的4个随机数画在透明玻璃上
        for(int i=0; i < randList.size(); i++) {
            gra.setColor(colors[rand.nextInt(colors.length)]);
            gra.drawString(randList.get(i)+"", i*40, 70+(rand.nextInt(21)-10));
        }

        //在验证码图片上随机画上2条线
        for(int i = 0; i < 2; i++) {
            gra.setColor(colors[rand.nextInt(colors.length)]);
            //画横线
            gra.drawLine(0, rand.nextInt(101), 200, rand.nextInt(101));
        }

        //设置图片的格式，并输出到页面上
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(image, "jpg", outputStream);

        //将验证码中的4位数字转换成字符保存在session中
        HttpSession session = request.getSession();
        session.setAttribute("code", ""+randList.get(0)+randList.get(1)+randList.get(2)+randList.get(3));



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
