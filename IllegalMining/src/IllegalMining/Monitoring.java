/** 
 * @author Kobina Asempa Takyi
 * @author Akwasi Appiadjei Asante - Krobea
 * @author Leslie Nartey - Kodjoe
 * 
 * @version 1.0.0
 * 
*/

import java.io.FileReader;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

// This creates an array which references data from the observatory class.

public class Monitoring{
    public static List<Observatory> monitor = new ArrayList<>();


    public Monitoring(){

    }

    // This method is used to print all events in a particular observatory.

    public void printAllEvents(){

        for(Observatory event:monitor){
            System.out.println(event.printInfo());
            System.out.println("\n");

        }

    }

    /**
     * This method is used to retrieve the observatory with the largest average color value.
     * @return obsName
     */

    public String getObservatoryWithLargestAverageColorValue() {
        double val = 0.0;
        String obsName = "";
        for(Observatory event:monitor){
            if(event.getAverageColorValue()>val){
                val = event.getAverageColorValue();
                obsName = event.getObservatoryName();

            }
        }
        return obsName;

    }


    /**
     * This method returns the galamsey with the largest average value.
     * @return value
     */

     public double getLargestAverage(){
         double value = 0.0;
         for(Observatory event:monitor){
             if(event.getAverageColorValue()>value){
                 value = event.getAverageColorValue();

             }
         }
         return value;
     }


    /**
     * This method returns the galamsey with the largest color value.
     * @return value
     */

    public int getLargestValueRecorded(){
        int value = 0;
        for(Observatory event:monitor){
            if(event.getLargestColorValue() > value){
                value = event.getLargestColorValue();
            }
        }
        return value;
    }

    
    /**
     * This method returns all galamsey recorded with color value greater than the given number.
     * @param value
     * @return allGalamEvents
     */

    public List<Galamsey> getObservatoryRecordsGreaterThan(int value){
        List<Galamsey> allGalamEvents = new ArrayList<>();
        for(Observatory event:monitor){
            for(Galamsey gEvent:event.getGalamseyEventsGreaterThan(value)){
                allGalamEvents.add(gEvent);
            }

        }
        return allGalamEvents;

    }

}