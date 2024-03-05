/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import Map.Marker;
import java.awt.geom.Point2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author yamis
 */
public class DatabaseConnect {

    Connection connection;
    String url = "jdbc:postgresql//localhost:5432/sportcat";
    String user = "postgres";
    String password = "postgres";
    
    public Connection dbConnection() throws SQLException, ClassNotFoundException
    {
        Class.forName("org.postgresql.Driver");
        
        DriverManager.getConnection(url, user, password);
        return connection;
    }
    
    public void getAllMarker(ArrayList<Marker> markers)
    {
        //Тут какой-то запрос + получить кол-во элементов
        int count = 0;
        String X = "", Y = "";
        for (int i = 0; i < count; i++) {
            Marker marker = new Marker();
            String info = "Привет! Это маркер №" + String.valueOf(i + 1); //Сюда описание из запроса + время работы 
            marker.setInfo(info);
            marker.setRating(i); // Вставка рэйтинга
            marker.setLabel(String.valueOf(i + 1));
            marker.setLat(X);
            marker.setLng(Y);
            markers.add(marker);
        }
//        return markers;
    }
    
}
