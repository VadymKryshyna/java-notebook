package com.kryshyna.notebook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Vadym Kryshyna
 */
public class DaoFactory {
    private String user = "root";//user login
    private String password = "password";//user password
    private String url = "jdbc:mysql://192.168.2.6:3306/notebooks";//URL address database server home
//    String url = "jdbc:mysql://192.168.1.7:3306/notebooks";//URL address database server work
    private String driver = "com.mysql.jdbc.Driver";//Name driver

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public PersonDao getPersonDao(Connection connection){
        return new PersonDao(connection);
    }

    public TelephoneDao getTelephoneDao(Connection connection){
        return new TelephoneDao(connection);
    }


}
