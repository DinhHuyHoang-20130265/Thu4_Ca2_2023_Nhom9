package AdminController;


import beans.AdminLogin;
import beans.AdminRole;
import beans.AdminUser;
import beans.ForgotPasswordStatus;
import services.AdminLoginService;
import services.ReCAPTCHAService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginAdminController", value = "/LoginAdminController")
public class LoginAdminController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        Đăng nhập admin Đinh Huy Hoàng - 20130265
        */
        //  Lấy dữ liệu
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        //  Lưu biến thông báo
        AdminLogin loginAdmin = new AdminLogin("", remember);
        boolean notify = false;
        // remove session của lấy lại mật khẩu nếu có
        ForgotPasswordStatus forgotPassword = (ForgotPasswordStatus) request.getSession().getAttribute("forgotPasswordAdmin");
        if (forgotPassword != null)
            request.getSession().removeAttribute("forgotPasswordAdmin");
        //  Kiểm tra xem thử đúng tài khoản có đúng hay không
        String user = AdminLoginService.getInstance().stringAccountAdminUser(username);

        //  Nếu mã tài khoản trả về là null thì nhập sai tài khoản rồi
        if (user == null) {
            notify = true;
            loginAdmin.setNotifyAccount(true);
            loginAdmin.setContent("Bạn nhập sai tài khoản");
        } else {
            //  Tiếp theo kiểm tra xem tài khoản đúng rồi mà hiện tại nó bị vô hiệu hóa hay chưa
            boolean isActive = AdminLoginService.getInstance().statusAccountAdminUser(username);
            //  Nếu tài khoản bị vô hiệu hóa thì thông báo
            if (!isActive) {
                notify = true;
                loginAdmin.setNotifyAccount(true);
                loginAdmin.setContent("Tài khoản của bạn đã bị vô hiệu hóa");
            } else {
                String captcha = request.getParameter("g-recaptcha-response");
                boolean check = ReCAPTCHAService.getInstance().verify(captcha);
                if (!check) {
                    notify = true;
                    loginAdmin.setNotifyPassword(true);
                    loginAdmin.setAccount(username);
                    loginAdmin.setContent("Bạn chưa check capcha");
                } else {
                    //  Tới đây thì tài khoản của bạn đã oke rồi
                    AdminUser admin = AdminLoginService.getInstance().getAccountAdminUser(username, password);

                    //  Nếu không đúng mật khẩu thì lưu lại tài khoản
                    if (admin == null) {
                        notify = true;
                        loginAdmin.setNotifyPassword(true);
                        loginAdmin.setAccount(username);
                        loginAdmin.setContent("Bạn nhập sai mật khẩu");
                    }
                }
            }
        }
        //  Nếu như có thông báo thì bạn đã nhập sai
        if (notify) {
            // Tới trang đăng nhập thì ta xóa remember account khỏi sesstion
            request.getSession().removeAttribute("rememberAccount");
            // Lưu vô session rồi sendRedirect
            request.getSession().setAttribute("loginAdmin", loginAdmin);
            response.sendRedirect("admin-page/login.jsp");

        } else {
            //  Nếu tới đây là oke hết rồi, chuyển admin tới index
            //  trước đó phải lưu vô session
            //  1. Lấy AccountAdmin
            AdminUser account = AdminLoginService.getInstance().getAccountAdminUser(username, password);

            //  2. Lấy role của account này và set cho nó
            List<AdminRole> role = AdminLoginService.getInstance().getListRole(account.getId());
            account.setRole(role);

            //  Tạo đối tượng admin rồi lưu vào session
            request.getSession().setAttribute("userAdmin", account);
            //  sendirect tới index
            request.getSession().removeAttribute("loginAdmin");
            response.sendRedirect("admin-page/index.jsp");

        }

    }
}
