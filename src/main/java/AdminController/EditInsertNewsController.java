package AdminController;

import beans.AdminUser;
import services.NewsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "EditInsertNewsController", value = "/EditInsertNewsController")
public class EditInsertNewsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /*
       Thêm/sửa tin tức trong admin - Nguyen CHi Thanh 20130403
    */
    @Overrides
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String content = request.getParameter("content");
        String nameFile = request.getParameter("nameFile");
        String oldImg = request.getParameter("oldImg");
        AdminUser admin = (AdminUser) request.getSession().getAttribute("userAdmin");
        String userID = admin.getId();
        String fullnameFile = "http://34.142.249.189/Thu4_Ca2_2023_Nhom9/assets/imgNews/news/" + nameFile;
        if (id == null || id.length() < 1) {
            NewsService.getInstance().InsertNewNews(title, description, content, fullnameFile, userID);
            removeOldImg(oldImg, request);
        } else {
            NewsService.getInstance().UpdateNews(id, title, description, content, fullnameFile, userID);
            removeOldImg(oldImg, request);
        }
    }

    private void removeOldImg(String oldImg, HttpServletRequest request) {
        if (oldImg.length() > 0) {
            String[] splited = oldImg.split(",");
            System.out.println(Arrays.toString(splited));
            for (String split : splited) {
                File fileInServer = new File(request.getServletContext().getAttribute("TEMPNEWS_DIR") + File.separator + split);
                if (fileInServer.exists())
                    fileInServer.delete();
            }
        }
    }
}
