package Map;


/**
 *
 * @author mixas
 */

import database.DatabaseConnect;
import java.awt.geom.Point2D;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
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
    private WebEngine engine = null;
    private WebView webView = null;
    private final Set<Point2D> coordinateSet = new HashSet<>();
    private final Random random = new Random();
    private final DatabaseConnect db = new DatabaseConnect();

    public void loadMap(String mapLocation) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                webView = new WebView();
                engine = webView.getEngine();
                engine.setJavaScriptEnabled(true);
                setScene(new Scene(webView));
//                File f = new File(MapsViewer.this.getClass().getClassLoader().getResource(mapLocation).getFile());
                File f = new File(MapsViewer.this.getClass().getClassLoader().getResource(mapLocation).getFile());
                try {
                    db.dbConnection();
                } catch (SQLException ex) {
                    Logger.getLogger(MapsViewer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MapsViewer.class.getName()).log(Level.SEVERE, null, ex);
                }
                db.getAllMarker(markers);
                addMarkersToMap();
                engine.load(f.toURI().toString());
            }
        });

    }

    public void generateRandomCoordinates(double centerX, double centerY, double radius, int count) {
        double radiusInDegrees = radius / 111320f;
        while (getCoordinateSet().size() <= count) {
            double u = random.nextDouble();
            double v = random.nextDouble();
            double w = radiusInDegrees * Math.sqrt(u);
            double t = 2 * Math.PI * v;
            double x = w * Math.cos(t);
            double y = w * Math.sin(t);
            double new_x = x / Math.cos(Math.toRadians(centerY));

            double foundLatitude;
            double foundLongitude;

            foundLongitude = centerY + y;
            foundLatitude = centerX + new_x;
            getCoordinateSet().add(new Point2D.Double(foundLatitude, foundLongitude));
        }
    }

    public void createMarkers() {
        Object[] mapArray = getCoordinateSet().toArray();
        for (int i = 0; i < mapArray.length; i++) {
            Point2D point = (Point2D) mapArray[i];
            Marker marker = new Marker();
            String info = "Привет! Это маркер №" + String.valueOf(i + 1);
            marker.setInfo(info);
            marker.setLabel(String.valueOf(i + 1));
            marker.setLat(String.valueOf(point.getX()));
            marker.setLng(String.valueOf(point.getY()));
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
            engine.executeScript("addMarker(" + marker.getLat() + "," + marker.getLng() + ",'" + marker.getLabel() + "','" + marker.getInfo() + "'" + ")");
//            engine.executeScript("setMapOnAll()");
        });
    }
    
    public void addMarkersOnMap()
    {
        Platform.runLater(() -> {
            engine.executeScript("setMapOnAll()");
        });
    }

    public void removeAllMarkers() {
        coordinateSet.clear();
        markers.clear();
        Platform.runLater(() -> {
            engine.executeScript("deleteMarkers()");
        });
    }

    /**
     * @return the coordinateSet
     */
    public Set<Point2D> getCoordinateSet() {
        return coordinateSet;
    }

}

