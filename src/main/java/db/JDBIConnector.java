package db;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.jdbi.v3.core.Jdbi;

import java.sql.SQLException;


public class JDBIConnector {
    private static Jdbi jdbi;

    private static void makeConnect() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://" + DBProperties.host() + ":" + DBProperties.port() + "/"
                + DBProperties.name());
        dataSource.setUser(DBProperties.user());
        dataSource.setPassword(DBProperties.pass());
        try {
            dataSource.setUseCompression(true);
            dataSource.setAutoReconnect(true);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
        jdbi = Jdbi.create(dataSource);
    }


    private JDBIConnector() {
    }

    public static Jdbi get() {
        if(jdbi==null) makeConnect();
        return jdbi;
    }

    public static void main(String[] args) {
        JDBIConnector.makeConnect();
    }
}