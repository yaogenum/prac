package ThreadPoolConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 类ConnectionThreadtest.java的实现描述：测试多线程下connection事物之间数据的读写问题
 * 
 * @author yaoge 2015年8月23日 上午1:52:40
 */
public class ConnectionThreadtest {

    public static Connection conn;
    public static Integer    param = 1;

    public static void main(String agrs[]) {
        ConnectionThreadtest t= new ConnectionThreadtest();
        t.testThread();

    }
    public void  testThread() {
        System.out.println(param);
        ExecutorService exec = Executors.newFixedThreadPool(15);
       for(int i=0;i<=15;i++) {
                System.out.println("thread:"+i);
                
                    exec.execute(new Runnable() {

                        public void run() {
                            executeParam();
                        }
                        public void executeParam() {
                            try {
                                    param++;
                                    System.out.println("executebefore:"+param);
                                    execututeSql(param);
                            } catch (Exception e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    });
                }
        exec.shutdown();
                
           
         
    }
    
    public   static void execututeSql(Integer params ) throws Exception{
        
        System.out.println("threadbefore:"+params);
        Connection conns = ConnectionThreadtest.getConnetion();
        PreparedStatement p = conn.prepareStatement("insert into user (name) VALUES (?)");
        p.setString(1, params.toString());
        p.execute();
    }
    public static Connection getConnetion() throws Exception {
        if (conn != null) return conn;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/test?"
                         + "user=root&password=root321&useUnicode=true&characterEncoding=UTF8";
            try {
                conn = DriverManager.getConnection(url);
                return conn;
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

    }

}
