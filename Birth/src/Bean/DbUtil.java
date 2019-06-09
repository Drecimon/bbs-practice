package Bean;

import java.sql.*;




public class DbUtil {


    private String dbUrl = "jdbc:mysql://localhost:3306/Student?useUnicode=true&characterEncoding=utf-8";


    private String dbUserName = "root";
    private String dbPassword = "123qwe123qwe";

    private String jdbcName = "com.mysql.cj.jdbc.Driver";

    public Connection getCon() throws Exception {
         Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
       // Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Student?useSSL=true&serverTimezone=GMT", "root", "123qw3123qwe");
        System.out.println(con);
        return con;
    }

    /**
     *      * 关闭数据库连接
     *      * @param con
     *      * @throws Exception
     *     
     */
    public void closeCon(Connection con) throws Exception {
        if (con != null) {
            con.close();
        }
    }


    public static void main(String[] args) {
        DbUtil dbUtil = new DbUtil();
        try {
            dbUtil.getCon();
             String dbUrl = "jdbc:mysql://localhost:3306/Student?useUnicode=true&characterEncoding=utf-8&useSSL=true";


        String dbUserName = "root";
        String dbPassword = "123qwe123qwe";

          String jdbcName = "com.mysql.cj.jdbc.Driver";
            Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);

            System.out.println("数据库连接成功");
            String sql;
            sql = "select * from user";
            PreparedStatement pstmt=con.prepareStatement(sql);
          //  pstmt.setInt(1, 1);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                String username=rs.getString(2);
             //   int age=rs.getInt("age");
                System.out.println(username);
            }
        } catch (Exception e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

