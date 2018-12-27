package dulieu;

import java.sql.*;

public class ConnectDatabase 
{
     private static Connection con = null;
     private static String url = "jdbc:sqlserver://";
     private static String serverName= "localhost";
     private static String portNumber = "1433";
     private static String databaseName= "quanlytaukhach";

     public ConnectDatabase()
     {}
     
     public static String getConnectionUrl()
     {
         return url + serverName + ":" + portNumber + "; databaseName=" + databaseName + "; integratedSecurity=true";
     }

     public static Connection getConnection()
     {
          try
          {
               Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
               con = DriverManager.getConnection(getConnectionUrl());
          }
          catch(Exception e)
          {
              con = null;
              System.out.println(e.getMessage());
          }
          return con;
      }

     public static void closeConnection()
     {
          try
          {
               if(con!=null)
                    con.close();
               con=null;
          }
          catch(Exception e)
          {
               e.printStackTrace();
          }
     }
    
    

    
    
}
