package xyz.microloong.resumetemplate.servlet;

import xyz.microloong.resumetemplate.bean.Result;
import xyz.microloong.resumetemplate.bean.User;
import xyz.microloong.resumetemplate.service.DbService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/v1/user/insert")
public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.    避免乱码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");
        //2.    接受浏览器传递的数据
        String name = request.getParameter("name");
        String city = request.getParameter("city");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String weixin = request.getParameter("weixin");
        String qq = request.getParameter("qq");
        String weibo = request.getParameter("weibo");
        String sex = request.getParameter("sex");
        String description = request.getParameter("description");
        String ageText = request.getParameter("age");
        int age = -1;
        try {
            age = Integer.parseInt(ageText);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        //3。    调用service，将数据存储到数据库中
        User user = new User(name, age, city, address, email, phone, weixin, qq, weibo, sex, description);
        int userId = DbService.insertUser(user);
        //4。    将存储的结果，封装为JSON格式，发送给浏览器
        Result r;
        if (userId > 0) {
            r = new Result(0, "用户新增成功", userId);
        } else {
            r = new Result(-1, "用户新增失败");
        }
        String json = r.toJSON();
        response.getWriter().append(json);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }
}
