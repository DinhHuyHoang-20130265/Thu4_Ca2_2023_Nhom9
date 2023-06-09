package DAO;


import beans.AdminRole;
import db.JDBIConnector;

import java.util.List;

public class AdminUserRoleDAO {
    private String id;

    public AdminUserRoleDAO(String id) {
        this.id = id;
    }

    public List<AdminRole> getRoleList() {
        List<AdminRole> list = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("select table_name, permission  from admin_permission where id =?")
                    .bind(0, id)
                    .map((rs, ctx) -> new AdminRole(rs.getString("table_name"), rs.getString("permission")))
                    .list();
        });
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new AdminUserRoleDAO("user2").getRoleList());
    }
}
