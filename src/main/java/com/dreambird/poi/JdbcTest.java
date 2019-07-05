package com.dreambird.poi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.* ;

/**
 * 数据库连接测试类
 * @author chen.jun
 *
 */
public class JdbcTest {
    //orcl为oracle数据库中的数据库名，localhost表示连接本机的oracle数据库
    //1521为连接的端口号
    private static String url="jdbc:oracle:thin:@localhost:1521:orcl";
    //system为登陆oracle数据库的用户名
    private static String user="system";
    //manager为用户名system的密码
    private static String password="system";
    public static Connection conn;
    public static PreparedStatement ps;
    public static ResultSet rs;
    public static Statement st ;
    //连接数据库的方法
    public void getConnection(){
        try {
            //初始化驱动包
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //根据数据库连接字符，名称，密码给conn赋值
            conn=DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    /**
     * 一个非常标准的连接Oracle数据库的示例代码
     */
    public void testOracle()
    {
        Connection con = null;// 创建一个数据库连接
        PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
        ResultSet result = null;// 创建一个结果集对象
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");// 加载Oracle驱动程序
            System.out.println("开始尝试连接数据库！");
            String url = "jdbc:oracle:" + "thin:@localhost:1521:orcl";
            String user = "scott";// 用户名,系统默认的账户名
            String password = "tiger";// 你安装时选设置的密码
            con = DriverManager.getConnection(url, user, password);// 获取连接
            System.out.println("连接成功！");
            String sql = "select * from emp where sal>?";// 预编译语句，“？”代表参数
//            Statement st = con.createStatement();
//            result = st.executeQuery(sql);
            pre = con.prepareStatement(sql);// 实例化预编译语句
            pre.setInt(1, 2000);// 设置参数，前面的1表示参数的索引，而不是表中列名的索引
            result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
            while (result.next())
                // 当结果集不为空时
                System.out.println("工号:" + result.getInt("EMPNO") + "姓名:"
                        + result.getString("ENAME"));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                // 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
                // 注意关闭的顺序，最后使用的最先关闭
                if (result != null)
                    result.close();
                if (pre != null)
                    pre.close();
                if (con != null)
                    con.close();
                System.out.println("数据库连接已关闭！");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    //测试能否与oracle数据库连接成功
    public static void main(String[] args) {
        JdbcTest basedao=new JdbcTest();
//        basedao.getConnection();
//        if(conn==null){
//            System.out.println("与oracle数据库连接失败！");
//        }else{
//            System.out.println("与oracle数据库连接成功！");
//        }   

        basedao.testOracle();
    }
}    
