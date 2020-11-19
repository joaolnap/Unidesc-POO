package CRUD.Crud03.Connection;

import java.sql.*;


public class DataBaseConnection {
    private static Connection con = null;
    private static DataBaseConnection dataBaseConnection;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/UnidescPOO?autoReconnect=true&useSSL=false";
    private static final String PWD = "123";
    private static final String USR = "root";

    private DataBaseConnection(){
        getConnetion();
    }

    public static  DataBaseConnection getInstance(){
        if (dataBaseConnection == null){
            dataBaseConnection = new DataBaseConnection();
        }
        return dataBaseConnection;
    }

    public static Connection getConnetion(){

        try{
            if(con==null){
                Class.forName(DRIVER);
                con = DriverManager.getConnection(URL,USR,PWD);
            }
        }catch (ClassNotFoundException | SQLException ex)
        {
            ex.printStackTrace();
        }
        return con;
    }

    public ResultSet executarSelect(String sql) throws SQLException{ // o que o Exception em java
        Statement query = con.createStatement();// O uqe significa os termos desta linha?
        return query.executeQuery(sql);//O que esta havendo aqui
    }
    public PreparedStatement criarPreparedStatement(String sql, int returnGeneratekeys)throws SQLException{// O que significa os termos desta linha?
        return con.prepareStatement(sql, returnGeneratekeys);
    }


}
