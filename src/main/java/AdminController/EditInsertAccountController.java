package AdminController;

import beans.AdminUser;
import services.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "EditInsertAccountController", value = "/EditInsertAccountController")
public class EditInsertAccountController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    /*
       Thêm/sửa account trong admin - Đinh Huy Hoàng 20130265
    */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("userId");
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String status = request.getParameter("status");
        String role = request.getParameter("role");
        String permission = request.getParameter("permission");
        String nameFile = request.getParameter("nameFile");
        String oldImg = request.getParameter("oldImg");
        AdminUser admin = (AdminUser) request.getSession().getAttribute("userAdmin");
        String adminId = admin.getId();
        if (id == null || id.length() < 1) {
            AccountService.getInstance().AddNewAccount(id, fullname, email, username, password, address, status, role, permission, nameFile, adminId);
            removeOldImg(oldImg, request);
        } else {
            AccountService.getInstance().UpdateAccount(id, fullname, email, username, password, address, status, role, permission, nameFile, adminId);
            removeOldImg(oldImg, request);
        }
    }

    private void removeOldImg(String oldImg, HttpServletRequest request) {
        if (oldImg.length() > 0) {
            String[] splited = oldImg.split(",");
            System.out.println(Arrays.toString(splited));
            for (String split : splited) {
                File fileInServer = new File(request.getServletContext().getAttribute("TEMPAVATAR_DIR") + File.separator + split);
                if (fileInServer.exists())
                    fileInServer.delete();
            }
        }
    }
}
