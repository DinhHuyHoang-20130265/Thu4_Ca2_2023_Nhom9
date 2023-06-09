package services;


import DAO.AdminUserDAO;
import DAO.AdminUserRoleDAO;
import beans.AdminRole;
import beans.AdminUser;
import beans.MD5;

import java.util.List;

public class AdminLoginService {
    //  Tạo thể hiện cho lớp
    private static AdminLoginService adminLoginService;

    //  Phương thức lấy thể hiện
    public static AdminLoginService getInstance() {

        //  Kiểm tra xem thể hiện có null hay không, null thì tạo mới
        if (adminLoginService == null) {
            adminLoginService = new AdminLoginService();
        }
        //  Trả về thể hiện
        return adminLoginService;

    }

    public String stringAccountAdminUser(String username) {
        AdminUserDAO DAO = new AdminUserDAO();
        if (!DAO.isExits(username)) {
            return null;
        }
        return username;
    }

    public boolean statusAccountAdminUser(String username) {
        AdminUserDAO DAO = new AdminUserDAO();
        if (!DAO.checkStatus(username)) {
            return false;
        }
        return true;
    }

    public AdminUser getAccountAdminUser(String username, String password) {
        AdminUserDAO DAO = new AdminUserDAO();
        AdminUser account = DAO.checkLogin(username, MD5.md5(password));
        if (account == null) {
            return null;
        }
        return account;
    }

    public List<AdminRole> getListRole(String id) {
        AdminUserRoleDAO DAO = new AdminUserRoleDAO(id);
        return DAO.getRoleList();
    }

    public static void main(String[] args) {
        System.out.println(new AdminLoginService().getListRole("user2"));
    }
}
