/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import Map.Marker;
import java.awt.geom.Point2D;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author yamis
 */
public class DatabaseConnect {

    Connection connection;
    String url = "jdbc:postgresql://localhost:5432/SportCat";
    String user = "postgres";
    String password = "mixasurg";
    
    public Connection dbConnection() throws SQLException, ClassNotFoundException
    {
        Class.forName("org.postgresql.Driver");
        
        connection = DriverManager.getConnection(url, user, password);
        
        return connection;
    }
    
    public void getAllMarker(ArrayList<Marker> markers) throws SQLException
    {
        //Ňóň ęŕęîé-ňî çŕďđîń + ďîëó÷čňü ęîë-âî ýëĺěĺíňîâ
        
        String X, Y;
        String query = "SELECT * FROM object "+
                    "JOIN object_type ON object.sportground_id = object_type.sportground_id " +
                    "JOIN location ON object.location_id = location.location_id "+
                    "JOIN work_time ON object.workhour_id = work_time.workhour_id";
        
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(query);

        while (result.next()) {
            String description = result.getString("description");
            String contact = result.getString("contact");
            float rating = result.getFloat("rating");
//            String sportGround = result.getString("sportground");
            X = result.getString("location_x");
            Y = result.getString("location_y");
            String iconUrl = result.getString("icon_url");
            String time = result.getString("Work_hour");
            String address = result.getString("address");
            String name = result.getString("name");
            Marker marker = new Marker();
            marker.setContact(contact);
            marker.setInfo(description);
            marker.setAddress("Адрес: " + address);
            marker.setName(name);
            marker.setRating(rating); // Âńňŕâęŕ đýéňčíăŕ
            marker.setLat(X);
            marker.setLng(Y);
            marker.setTime("Время работы: "+time);
            marker.setIcon_url(iconUrl);
            markers.add(marker);
        }
     
        }
    public void getSportGroudMarker(ArrayList<Marker> markers, int sportground_id) throws SQLException
    {
        String X, Y;
        String query = "SELECT * FROM object "+
                    "JOIN object_type ON object.sportground_id = object_type.sportground_id " +
                    "JOIN location ON object.location_id = location.location_id "+
                    "JOIN work_time ON object.workhour_id = work_time.workhour_id "+
                "WHERE object.sportground_id = ?";
        
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, sportground_id);
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            String description = result.getString("description");
            String contact = result.getString("contact");
            float rating = result.getFloat("rating");
//            String sportGround = result.getString("sportground");
            X = result.getString("location_x");
            Y = result.getString("location_y");
            String iconUrl = result.getString("icon_url");
            String time = result.getString("Work_hour");
            String address = result.getString("address");
            String name = result.getString("name");
            Marker marker = new Marker();
            marker.setInfo(description);
            marker.setAddress("Адрес: " + address);
            marker.setName(name);
            marker.setContact(contact);
            marker.setRating(rating); // Âńňŕâęŕ đýéňčíăŕ
            marker.setLat(X);
            marker.setLng(Y);
            marker.setTime("Время работы: "+time);
            marker.setIcon_url(iconUrl);
            markers.add(marker);
        }
    }
}
