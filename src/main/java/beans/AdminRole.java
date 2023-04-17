package beans;

import java.io.Serializable;

public class AdminRole implements Serializable {
    private String table;
    private String permission;

    public AdminRole(String table, String permission) {
        this.table = table;
        this.permission = permission;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "AdminRole{" +
                "table=" + table +
                ", permission='" + permission + '\'' +
                '}';
    }
}
