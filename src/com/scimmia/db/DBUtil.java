package com.scimmia.db;

import com.scimmia.BaiduInfo;

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

    public static boolean insertInvoice(InvoiceBean i){
        boolean result = false;
        Connection connection = null;
        try {
            connection = createConnection();

            String sql = "insert into invoice(invoiceid,fpdm,fphm,fprq,fpje) values(?,?,?,?,?) ";
            PreparedStatement pst = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            pst.setLong(1, i.getId());
            pst.setString(2, i.getFpdm());
            pst.setString(3, i.getFphm());
            pst.setString(4, i.getFprq());
            pst.setString(5, i.getFpje());
            pst.executeUpdate();
            pst.close();

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


    public static boolean updateInvoice(InvoiceBean i){
        boolean result = false;
        Connection connection = null;
        try {
            connection = createConnection();

            String sql = "UPDATE invoice SET piaozhong=?, xiaoshoufang=?, goumaifang=?, jine=?, shuie=?," +
                    "jiashuiheji=?, zuofei=?, createtime=? WHERE invoiceid=?";
            PreparedStatement pst = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, i.getPiaozhong());
            pst.setString(2, i.getXiaoshoufang());
            pst.setString(3, i.getGoumaifang());
            pst.setString(4, i.getJine());
            pst.setString(5, i.getShuie());
            pst.setString(6, i.getJiashuiheji());
            pst.setString(7, i.getZuofei());
            pst.setString(8, i.getCreatetime());
            pst.setLong(9, i.getId());
            pst.executeUpdate();
            pst.close();

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
