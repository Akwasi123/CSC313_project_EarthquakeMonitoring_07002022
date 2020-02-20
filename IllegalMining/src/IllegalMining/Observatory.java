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
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;



public class Observatory{

    // The instance variables for the class Observatory is created.

    private String name;
    private String country;
    private int year;
    private double area;
    private List<Galamsey> obsList;
 


    /**
     * This class is used to differentiate the variable name from the object.
     * @param name This is the name of the observatory.
     * @param country This is the country in which the observatory is in.
     * @param year This is the year the observatory was created.
     * @param area This is the total area of the observatory.
     */

    public Observatory(String name, String country, int year, double area){
        this.name = name;
        this.country = country;
        this.year = year;
        this.area = area;

        obsList = new ArrayList<>();


        Monitoring.monitor.add(this);

    }

    

    /**
     * The accessor method for getting the observatory name.
     * @return name
     */

    public String getObservatoryName(){
        return name;
    }

    

    /**
     * The mutator method for setting the observatory name is created.
     * @param name
     */

    public void setObservatoryName(String name){
        this.name = name;

    }

    

    /**
     * The accessor method for getting the country name.
     * @return country
     */

    public String getCountry(){
        return country;
    }

    

    /**
     * The mutator method for setting the coountry name.
     * @param country
     */

    public void setCountry(String country){
        this.country = country;
        
    }

    

    /**
     * // The accessor method for getting the year the observatory.
     * @return year
     */

    public int getYearStarted() {
        return year;
    }

    

    /**
     * The mutator method for setting the year the observatory started.
     * @param year
     */

    public void setYearStarted(int year){
        this.year = year;

    }


    /**
     * The accessor method for getting the area of the observatory.
     * @return area
     */
    public double getArea(){
        return area;

    }

    

    /**
     * The mutator method for setting the area of the observatory.
     * @param area
     */

    public void setArea(double area){
        this.area = area;
    }

    

    /**
     * The mutator method for setting the galamsey events in a particular observatory.
     * @param obsList
     */

    public void setgalamEvents(List<Galamsey> obsList){
        this.obsList = obsList;
    }

    

    /**
     * The method used to add a galamsey to an observatory.
     * @param object
     */

    public void addGalamsey(Galamsey object){
        obsList.add(object);
    }

    // This returns a list of the galamsey recorded.

    /**
     * This returns a list of the galamsey recorded.
     * @return oblist
     */

    public List<Galamsey> getGalamsey(){
        return obsList;
    }

    /**
     * 
     * @param vegColor This is the name of the vegetation color. 
     * @param colorValue This is the color value for the galamsey.
     * @param position This is the value for the position.
     * @param year This is the year for the galamsey.
     */


    public void recordGalamsey(String vegColor, int colorValue, Position position,int year){
        Galamsey galamsey = new Galamsey(vegColor, colorValue, position, year);
        galamsey.setObservatory(this);

        try{
            galamsey.addtoDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        obsList.add(galamsey);

    }

    

    /**
     * The accessor method for getting the galamsey with the largest color value is created.
     * The method for getting the galamsey with the largest color value.
     * @return num
     */

    public int getLargestColorValue(){
        int num = 0;
        for(Galamsey event:obsList) {
            if (event.getvegColorVal() > num) {
                num = event.getvegColorVal();

            }

        }
        return num;
    }


    /**
     * The accessor method for getting the average color value.
     * @return colorTotal/count
     */

    public double getAverageColorValue(){
        double count = 0;
        double colorTotal = 0;
        for(Galamsey event:obsList){
            colorTotal = colorTotal + event.getvegColorVal();
            count ++;
        }
        return colorTotal/count;
    }


    /**
     * // The method used to return the galamsey events greater than a given value.
     * @param value
     * @return greater
     */

    public List<Galamsey> getGalamseyEventsGreaterThan(int value){
        List<Galamsey> greater = new ArrayList<>();
        for(Galamsey event:obsList){
            if(event.getvegColorVal() > value){
                greater.add(event);
            }


        }
        return greater;

    }

    // This method is used to print the information on an observatory.

    public String printInfo(){
        return "Name of Observatory: "+name+
                "\nCountry Situated: "+ country+
                "\nYear Started: "+ year+
                "\nArea: "+area;


    }

   
    /**
     * This adds to the database, the records the user inputs.
     * @throws SQLException
     */
    public void addtoDatabase() throws SQLException {
        MonitoringIO.database.enterObservatoryData(this);

    }

    @Override
    public String toString(){
        return getObservatoryName();
    }


}