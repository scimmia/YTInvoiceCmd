package com.scimmia;

import java.sql.*;

/**
 * Created by lk on 2017/12/18.
 */
public class DBUtil {

    private static final String Class_Name = "org.sqlite.JDBC";
    private static final String DB_URL = "jdbc:sqlite:sqliteyt.db";

    // 创建Sqlite数据库连接
    public static Connection createConnection() throws SQLException, ClassNotFoundException {
        Class.forName(Class_Name);
        return DriverManager.getConnection(DB_URL);
    }

    public static boolean isSaved(long id){
        boolean result = false;
        Connection connection = null;
        try {
            connection = createConnection();
            result = func1(connection,id);
            System.out.println("Success!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e);
            }
        }
        return  result;
    }

    public static boolean func1(Connection connection,long id) throws SQLException {
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30); // set timeout to 30 sec.
        // 执行查询语句
        ResultSet rs = statement.executeQuery("select COUNT(*) AS c from invoice where invoiceid="+id);
        while (rs.next()) {
            return rs.getInt("c") > 0;
        }
        return false;
    }

    public static boolean insertInvoice(BaiduInfo.PoisBean poisBean){
        boolean result = false;
        Connection connection = null;
        try {
            connection = createConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into invoice(invoiceid,) values('" + poisBean.getId() + "')");
            System.out.println("Success!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e);
            }
        }
        return  result;

    }
}
