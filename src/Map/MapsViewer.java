package Map;


/**
 *
 * @author mixas
 */

import database.DatabaseConnect;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 *
 * @author asimsinanyuksel
 */
public class MapsViewer extends JFXPanel {

    private final ArrayList<Marker> markers = new ArrayList<>();
    Marker user = new Marker();
    private WebEngine engine = null;
    private WebView webView = null;
    private final DatabaseConnect db = new DatabaseConnect();

    public void loadMap(String mapLocation) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                webView = new WebView();
                engine = webView.getEngine();
                engine.setJavaScriptEnabled(true);
                setScene(new Scene(webView));
                File f = new File(MapsViewer.this.getClass().getClassLoader().getResource(mapLocation).getFile());
                try {
                    db.dbConnection();
                } catch (SQLException ex) {
                    Logger.getLogger(MapsViewer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MapsViewer.class.getName()).log(Level.SEVERE, null, ex);
                }
                engine.load(f.toURI().toString());
            }
        });

    }




    
    public void loadMarkerFromDb()
    {
        try {
            db.getAllMarker(markers);
        } catch (SQLException ex) {
            Logger.getLogger(MapsViewer.class.getName()).log(Level.SEVERE, null, ex);
        }
        addMarkersToMap();
        addMarkersOnMap();
    }
        
    public void loadMarkerFromDbId(int sg_id)
    {
        try {
//            markers.clear();
            db.getSportGroudMarker(markers, sg_id);
        } catch (SQLException ex) {
            Logger.getLogger(MapsViewer.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void checkRadiusMarker(double radius)
    {
        ArrayList<Marker> nmarkers = findMarkersInRadius(user, markers, radius);
        markers.clear();
        for (Marker marker : nmarkers) {
            markers.add(marker);
        }
    }

    public void addMarkersToMap() {
        for (Marker marker : markers) {
            addMarker(marker);
        }
    }

    public void addMarker(Marker marker) {

        Platform.runLater(() -> {
            engine.executeScript("addMarker(" + marker.getLat() + "," + marker.getLng() + ",'" + marker.getInfo() + "','" + marker.getTime()+ "','" + marker.getColour()+ "','" + marker.getIcon_url()+ "','" + marker.getName()+ "','" + marker.getAddress()+ "','" + marker.getContact()+ "'" + ")");
        });
    }
    public void createUser(String X, String Y)
    {
        user.setLat(X);
        user.setLng(Y);
        addMarkerUser();
    }
    public void addMarkerUser() {

        Platform.runLater(() -> {
            engine.executeScript("addMarkerUser(" + user.getLat() + "," + user.getLng() + ")");
        });
    }
    
    public void addMarkersOnMap()
    {
        Platform.runLater(() -> {
            engine.executeScript("setMapOnAll()");
        });
    }

    public void removeAllMarkers() {
        markers.clear();
        Platform.runLater(() -> {
            engine.executeScript("deleteMarkers()");
        });
    }

       public static double distance(double lat1, double lng1, double lat2, double lng2) {
        // ?????? ????? ? ??????????
        double R = 6371;

        // ?????????????? ????? ? ?????? ?? ???????? ? ???????
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lng2 - lng1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c;
        return distance;
    }
    
    // ??????? ??? ?????? ???????? ? ???????????? ??????? ?? ???????? ?????????
    public static ArrayList<Marker> findMarkersInRadius(Marker user, List<Marker> markers, double radius) {
        ArrayList<Marker> markersInRadius = new ArrayList<>();
        for (Marker marker : markers) {
            double markerLat = Double.parseDouble(marker.getLat());
            double markerLnn = Double.parseDouble(marker.getLng());
            double userLat = Double.parseDouble(user.getLat());            
            double userLng = Double.parseDouble(user.getLng());
            double dist = distance(userLat, userLng, markerLat, markerLnn);
            if (dist <= radius) {
                markersInRadius.add(marker);
            }
        }
        return markersInRadius;
    }
}

