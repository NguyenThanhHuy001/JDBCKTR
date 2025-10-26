package vn.huy2k2.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectSQL {
    private final String serverName = "NTH";
    private final String dbName = "quanlynhasach1";
    private final String portNumber = "1433";
    private final String instance = ""; // nếu SQL có instance thì thêm vào, ví dụ: "SQLEXPRESS"
    private final String userID = "sa";
    private final String password = "12345678";

    public Connection getConnection() throws Exception {
        String url;
        if (instance == null || instance.trim().isEmpty()) {
            // default instance
            url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName
                    + ";encrypt=true;trustServerCertificate=true";
        } else {
            // named instance
            url = "jdbc:sqlserver://" + serverName + "\\" + instance + ":" + portNumber + ";databaseName=" + dbName
                    + ";encrypt=true;trustServerCertificate=true";
        }

        // Nạp driver SQL Server
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        // ✅ Trả về Connection hợp lệ
        Connection conn = DriverManager.getConnection(url, userID, password);
        System.out.println("✅ Kết nối SQL thành công!");
        return conn;
    }

    public static void main(String[] args) {
        try {
            ConnectSQL db = new ConnectSQL();
            db.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
