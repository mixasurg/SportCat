package Map;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mixas
 */
public class Marker {
    
    private String info;
    private String lat;
    private String lng;
    private float rating;
    private String colour; 
    private String time; 
    private String icon_url; 

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
    

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
        if (rating >= 4)
        {
            this.setColour("green");
        }
        else if (rating < 4 && rating >= 2.5)
        {
            this.setColour("blue");
        }
        else if (rating < 2.5 && rating >= 1)
        {
            this.setColour("red");
        }
        else 
        {
            this.setColour("grey");
        }
    }

    /**
     * @return the info
     */
    public String getInfo() {
        return info;
    }

    /**
     * @param info the info to set
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * @return the lat
     */
    public String getLat() {
        return lat;
    }

    /**
     * @param lat the lat to set
     */
    public void setLat(String lat) {
        this.lat = lat;
    }

    /**
     * @return the lng
     */
    public String getLng() {
        return lng;
    }

    /**
     * @param lng the lng to set
     */
    public void setLng(String lng) {
        this.lng = lng;
    }
    
}

