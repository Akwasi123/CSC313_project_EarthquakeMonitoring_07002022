/** 
 * @author Kobina Asempa Takyi
 * @author Akwasi Appiadjei Asante - Krobea
 * @author Leslie Nartey - Kodjoe
 * 
 * @version 1.0.0
 * 
*/

package IllegalMining;
import java.sql.SQLException;
import java.util.*;
import java.io.FileOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;



public class Galamsey{

    // The instance variables for the class Galamsey is created.

    private String vegColor;
    private int colorValue;
    private int year;
    private Position position;
    private Observatory observatory;
    
    
    public Galamsey(){
        super();
    }
    
    // This class is used to differentiate the variable name from the object.

    /**
     * 
     * @param vegColor This is the name of the vegetation color. 
     * @param colorValue This is the color value for the galamsey.
     * @param position This is the value for the position.
     * @param year This is the year for the galamsey.
     */

    public Galamsey(String vegColor, int colorValue, Position position,int year ){
        this.vegColor = vegColor;
        this.colorValue = colorValue;
        this.year = year;
        this.position = position;

        
    }

    

    /**
     * The accessor method for getting the vegetation color.
     * @return vegColor
     */

    public String getvegColor() {
        return vegColor;
    }


    /**
     * The mutator method for setting the vegetation color.
     * @param vegColor
     */

    public void setvegColor(String vegColor){

        this.vegColor = vegColor;
    }


    /**
     * The accessor method for getting the vegetation color value.
     * @return colorValue
     */

    public int getvegColorVal(){

        return colorValue;
    }

    

    /**
     * The mutator method for setting the vegetation color value.
     * @param colorValue
     */

    public void setVegcolorVal(int colorValue){

        this.colorValue = colorValue;
    }


    /**
     * The accessor method for getting year.
     * @return year
     */

    public int getYear(){

        return year;
    }

    

    /**
     * The accessor method for getting the position of the galamsey.
     * @return position
     */

    public Position getPosition(){
        return position;
    }

    /**
     * The mutator method for setting theposition of the galamsey.
     * @param position
     */

    public void setPosition(Position position){
        this.position = position;
    }


    /**
     * The mutator method for setting the observatory.
     * @param observe
     */
    
    public void setObservatory(Observatory observe){
        this.observatory = observe;
    }


    /**
     * The accessor method for getting the observatory is created.
     * @return observatory
     */

    public Observatory getObservatory(){
        return observatory;
    }


    /**
     * The mutator method for setting the year is created.
     * @param year
     */

    public void setYear(int year){
        this.year = year;
    }
        
        

    // This method adds data inputted by the user to the database.

    

    public void addtoDatabase() throws SQLException {
        MonitoringIO.database.enterGalamseyData(this);
    }
    
    
    @Override
    public String toString(){
        return "Vegetation Color:" +getvegColor()
                +"\nColor Value:"+getvegColorVal()
                +"\nYear:"+getYear()
                +"\nPosition: "+getPosition().toString();
    }





}
