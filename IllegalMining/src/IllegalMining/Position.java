/** 
 * @author Kobina Asempa Takyi
 * @author Akwasi Appiadjei Asante - Krobea
 * @author Leslie Nartey - Kodjoe
 * 
 * @version 1.0.0
 * 
*/

package IllegalMining;
import java.util.Scanner;

public class Position{

    // This is used to create the instance variables for the position class.

    private  double latitude;
    private  double longitude;
    private  double[] position;


    /**
     * 
     * @param latitude This is the latitude of the galamsey.
     * @param longitude This is the longitude of the galamsey.
     */

    public Position(double latitude, double longitude){
        this.latitude = latitude;
        this.longitude = longitude;


    }

    /**
     * This method returns the latitude of the galamsey.
     * @return latitude
     */

    public double getLatitude(){
        return latitude;
    }


    /**
     * This method returns the longitude of the galamsey.
     * @return longitude
     */

    public double getLongitude(){
        return longitude;
    }

    //This returns both the longitude and the latitude of a galamsey.

    @Override
    public String toString(){
        String positionValue = latitude + " " + longitude;
        return positionValue;
    }
}