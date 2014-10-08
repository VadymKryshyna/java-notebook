package com.kryshyna.notebook.dao;

import com.kryshyna.notebook.entity.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vadym Kryshyna
 */
public class PersonDao {
    private final Connection connection;

    public PersonDao(Connection connection){
        this.connection = connection;
    }

    public List<Person> getAll() throws SQLException {
        String sql = "SELECT * FROM person;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        List<Person> list = new ArrayList<>();
        while (rs.next()) {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setFirstname(rs.getString("firstname"));
            person.setLastname(rs.getString("lastname"));
            list.add(person);
        }
        return list;
    }

    public void create(Person person) throws SQLException {
        String sql = "INSERT INTO person(firstname, lastname) VALUES (?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, person.getFirstname());
        preparedStatement.setString(2, person.getLastname());
        preparedStatement.executeUpdate();
    }

    public void update(Person person) throws SQLException {
        String sql = "UPDATE person SET firstname=?, lastname=? WHERE id=?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, person.getFirstname());
        preparedStatement.setString(2, person.getLastname());
        preparedStatement.setInt(3, person.getId());
        preparedStatement.executeUpdate();
    }

    public void delete(Person person) throws SQLException {
        String sql = "DELETE FROM person WHERE id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, person.getId());
        preparedStatement.executeUpdate();
    }
}
