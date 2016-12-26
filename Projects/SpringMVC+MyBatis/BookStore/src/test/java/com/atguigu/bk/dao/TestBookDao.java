package com.atguigu.bk.dao;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.sql.*;

public class TestBookDao {
    BookDao bookDao;

    @Before
    public void setUp() {
        bookDao = new BookDao();
    }

    @After
    public void tearDown() {
        bookDao = null;
    }


    @Test
    public void testGetBookPic() {
        //hint: 如何将图片以二进制的形式存入到oracle中的blob类型
        String sql = "update tbook set pic=? where isbn=?";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connention = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "test", "test");
            PreparedStatement ps = connention.prepareStatement(sql);

            //hint:  void setBinaryStream(int parameterIndex, java.io.InputStream x)
            File file = new File("C:\\Users\\Administrator\\Desktop\\400501128467508726.jpg");
            FileInputStream in = new FileInputStream(file);
            ps.setBinaryStream(1, in);
            ps.setString(2, "s004");
            ps.executeUpdate();
            connention.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
