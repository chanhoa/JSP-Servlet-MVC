package com.test.dao;

import com.test.entities.Categroy;

import java.sql.*;
import java.util.ArrayList;

public class CategoryDAO {
    Connection dbConnection = DBConnection.getInstance().getConnection();

    public ArrayList<Categroy> getAll() {
        ArrayList<Categroy> list = new ArrayList<>();
        Statement stmt = null;
        try {
            stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tblcatalogy");
            while (rs.next()) {
                Categroy c = new Categroy(rs.getInt(1), rs.getString(2));
                list.add(c);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public boolean insert(Categroy c) {
        String sql = "INSERT INTO tblcatalogy (category) VALUES (?)";


        int rowsInserted = 0;
        try {
            PreparedStatement statement = dbConnection.prepareStatement(sql);
            statement.setString(1, c.getCategoryName());
            rowsInserted = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (rowsInserted > 0) {
            return true;
        }
        return false;
    }

    public boolean update(Categroy c) {
        String sql = "UPDATE tblcatalogy SET category=? WHERE id=?";
        int rowsUpdated = 0;
        PreparedStatement statement = null;
        try {
            statement = dbConnection.prepareStatement(sql);
            statement.setString(1, c.getCategoryName());
            statement.setInt(2, c.getId());
            rowsUpdated=   statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if (rowsUpdated > 0) {
            return true;
        }
        return false;
    }

    public boolean delete(Categroy c) {
        String sql = "DELETE FROM tblcatalogy WHERE id=?";
        int rowsDeleted =0;
        try {
            PreparedStatement statement = dbConnection.prepareStatement(sql);
            statement.setInt(1, c.getId());
            rowsDeleted= statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        if (rowsDeleted > 0) {
           return true;
        }
        return false;
    }

}
