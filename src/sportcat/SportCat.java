/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sportcat;
import Map.MapsFrame;
/**
 *
 * @author yamis
 */
public class SportCat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MapsFrame map = new MapsFrame();
        map.setVisible(true);
        StartFrame st = new StartFrame(map);
        st.setVisible(true);        
        st.setAlwaysOnTop(true);
        
    }
    
}
