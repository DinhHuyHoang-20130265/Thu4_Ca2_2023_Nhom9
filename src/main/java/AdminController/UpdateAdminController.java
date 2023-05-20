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

@WebServlet(name = "UpdateAdminController", value = "/UpdateAdminController")
public class UpdateAdminController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /*
       Caapj nhata account admin - Đin h Huy Hoàng 20130265
    */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminUser admin = (AdminUser) request.getSession().getAttribute("userAdmin");
        String id = admin.getId();
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String nameFile = request.getParameter("nameFile");
        String oldImg = request.getParameter("oldImg");

        AccountService.getInstance().UpdateAdminAccount(id, fullname, email, password, address, phone, nameFile);
        removeOldImg(oldImg, request);
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
