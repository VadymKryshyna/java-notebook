package com.kryshyna.notebook.dao;

import com.kryshyna.notebook.entity.Telephone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vadym Kryshyna
 */
public class TelephoneDao {
    private final Connection connection;

    public TelephoneDao(Connection connection){
        this.connection = connection;
    }

    public List<Telephone> getAll(int idfk) throws SQLException {
        String sql = "SELECT * FROM telephone WHERE idfk = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, idfk);
        ResultSet rs = preparedStatement.executeQuery();
        List<Telephone> list = new ArrayList<>();
        while (rs.next()) {
            Telephone telephone = new Telephone();
            telephone.setId(rs.getInt("id"));
            telephone.setNumber(rs.getString("number"));
            telephone.setFkid(rs.getInt("idfk"));
            list.add(telephone);
        }
        return list;
    }

    public void create(Telephone telephone) throws SQLException {
        String sql = "INSERT INTO telephone(number, idfk) VALUES (?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, telephone.getNumber());
        preparedStatement.setInt(2, telephone.getFkid());
        preparedStatement.executeUpdate();
    }

    public void update(Telephone telephone) throws SQLException {
        String sql = "UPDATE telephone SET number=? WHERE id=?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, telephone.getNumber());
        preparedStatement.setInt(2, telephone.getId());
        preparedStatement.executeUpdate();
    }

    public void delete(Telephone telephone) throws SQLException {
        String sql = "DELETE FROM telephone WHERE id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, telephone.getId());
        preparedStatement.executeUpdate();
    }
}
