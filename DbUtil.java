
package com.agh.filmy.util;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbUtil {
    private static Connection connection= null;
    public static Connection getConnection(){
    if(connection!= null)
        return connection;
    else{
        try{
            Properties prop= new Properties();
            InputStream inputStream= DbUtil.class.getResourceAsStream("db.properties");
            prop.load(inputStream);
            String driver = prop.getProperty("driver");
            String url= prop.getProperty("url");
            String user= prop.getProperty("user");
            String password= prop.getProperty("password");
            Class.forName(driver);
            connection= DriverManager.getConnection(url, user, password);
        } catch( SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return connection;
        }
    }
}
