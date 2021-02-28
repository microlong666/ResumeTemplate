package xyz.microloong.resumetemplate.servlet;

import xyz.microloong.resumetemplate.bean.Result;
import xyz.microloong.resumetemplate.bean.Work;
import xyz.microloong.resumetemplate.service.DbService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/v1/work/insert")
public class WorkServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");

        int userId = 0;
        String userIdText = request.getParameter("userid");
        if (userIdText != null) {
            try {
                userId = Integer.parseInt(userIdText);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        String company = request.getParameter("company");
        String job = request.getParameter("job");
        String description = request.getParameter("description");
        Work work = new Work(userId, start, end, company, job, description);
        int row = DbService.insertWork(work);
        Result result;
        if (row > 0) {
            result = new Result(0, "工作经历新增成功");
        } else {
            result = new Result(-1, "工作经历新增失败");
        }
        response.getWriter().append(result.toJSON());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }
}
