package AdminController;

import beans.News;
import beans.Product;
import services.NewsService;
import services.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoadNewsListAdminController", value = "/LoadNewsListAdminController")
public class LoadNewsListAdminController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    /*
    Load more danh sách tin tức trong admin - Nguyen CHi THanh 20130403
    */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = Integer.parseInt(request.getParameter("pageNumb"));
        List<News> loadNews = NewsService.getInstance().getListNewsByPage(page);
        request.setAttribute("loadNews", loadNews);
        request.getRequestDispatcher("/admin-page/ajax/ajax_LoadNewsListAdmin.jsp").forward(request, response);
    }
}
