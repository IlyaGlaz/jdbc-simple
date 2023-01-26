package org.iliaglaz.jdbcsimple.utils;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.sql.Connection;
import java.sql.DriverManager;

@UtilityClass
public class ConnectionUtil {
    private static final String URL = "db.url";
    private static final String USER = "db.user";
    private static final String PASSWORD = "db.password";

    static {
        loadDriver();
    }

    @SneakyThrows
    public static Connection get() {
        return DriverManager.getConnection(PropertiesUtil.get(URL),
                PropertiesUtil.get(USER),
                PropertiesUtil.get(PASSWORD)
        );
    }

    @SneakyThrows
    private static void loadDriver() {
        Class.forName("com.mysql.jdbc.Driver");
    }
}
