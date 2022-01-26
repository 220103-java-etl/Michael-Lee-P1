package dev.lee.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// This connection Util class will define the methods needed to create a connection to our DB
public class ConnectionUtil {

    private static ConnectionUtil cu = null;
    private static Properties dbProp;

    // private constructor - so we can control the creation of any instance of this class
    // Singleton Design Pattern (Creational Design Pattern) - to make sure we only ever have one instance of this class

    private ConnectionUtil() {
        //Initialize property object to hold DB credentials
        dbProp = new Properties();

        //Stream the credentials from our connection.properties file to the Properties Object
        InputStream prop = ConnectionUtil.class.getClassLoader().getResourceAsStream("DBConnection.properties");

        try {
            dbProp.load(prop); //load method throws an input/output exception that must be handled through a try/catch block
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    //public getter method to return us an instance of this ConnectionUtil class
    public static synchronized ConnectionUtil getConnectionUtil(){
        //first check if an instance already exists
        if(cu == null){
            //then call private constructor
            cu = new ConnectionUtil();
        }
        // otherwise just return the existing instance
        return cu;
    }

    public Connection getConnection() {

        Connection conn = null;
        //Get credentials needed to access the DB from the Properties Object we created above (which gets those from the resources file)

        String url = dbProp.getProperty("url");
        String username = dbProp.getProperty("username");
        String password = dbProp.getProperty("password");

        try {
            conn = DriverManager.getConnection(url, username, password); //must handle possible exception with try/catch
        }catch(SQLException se) {
            se.printStackTrace();
        }
        return conn;
    }
}