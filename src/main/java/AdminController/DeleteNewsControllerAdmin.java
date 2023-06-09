package AdminController;

import beans.News;
import beans.NewsComment;
import services.NewsCommentService;
import services.NewsService;
import services.NewsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeleteNewsControllerAdmin", value = "/DeleteNewsControllerAdmin")
public class DeleteNewsControllerAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    /*
       Xóa tin tức trong admin
    */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int pageNumb = Integer.parseInt(request.getParameter("pageNumb"));
        NewsService.getInstance().RemoveNews(id);
        List<News> list = NewsService.getInstance().getListNewsByPage(pageNumb);
        request.setAttribute("loadNews", list);
        request.getRequestDispatcher("/admin-page/ajax/ajax_LoadNewsListAdmin.jsp").forward(request, response);
    }
}
