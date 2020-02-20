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
import java.util.Scanner;
import java.util.ArrayList;

// This class takes information from the Observatory and galamsey classes.

public class MonitoringIO{
    public static Monitoring monitor = new Monitoring();
    public static Observatory newObservatory;
    public static Mining database = new Mining();
   

    // This method prints out a menu for the user to choose from.

    public static void MainMenu(){
        System.out.println("------------------------------------");
        System.out.println("Main Menu:"
                            +"\n1.To Enter Observatory Data"
                            +"\n2.To Enter Galamsey Data"
                            +"\n3.For Monitoring Statistics"
                            +"\n4.Exit Program");
        System.out.println();
        System.out.println("------------------------------------");
        System.out.println();

        // The options below show the methods each option calls.

        Scanner input1 = new Scanner(System.in);
        System.out.print("Select any number from the menu: ");
        int option = input1.nextInt();

        if(option == 1){
            System.out.println("------------------------------------");
            System.out.println("Enter observatory data here: ");
            System.out.println();
            ObservatoryInput();
            System.out.println("-------------------------------------");
            MainMenu();
            System.out.println();
        }

        else if(option == 2){
            System.out.println("------------------------------------");
            System.out.println("Enter the galamsey data: ");
            System.out.println();
            GalamseyInput();
            System.out.println("------------------------------------");
            MainMenu();
            System.out.println();
        }

        else if(option == 3){
            System.out.println("------------------------------------");
            MonitoringStatsMenu();
            System.out.println("------------------------------------");
        }

        else if(option == 4){
            System.out.println("Thank you.");
        }
        else{
            System.exit(4);
        }


    }

    // This method takes care of the details of the galamsey activities.

    public static void MonitoringStatsMenu(){
        System.out.println("Monitoring Menu:"
                            +"\n1.Show All Observatory Data"
                            +"\n2.Show Statistics"
                            +"\n3.Galamsey Activities with Color Value greater than given number"
                            +"\n4.Return to Menu"
                            +"\n0.Exit Program");
        System.out.println();
        Scanner input2 = new Scanner(System.in);
        int option = input2.nextInt();
        if(option == 1){
            showObservatories(monitor);
            MonitoringStatsMenu();
            System.out.println();
        }

        else if(option == 2){
            showStatistics(monitor);
            MonitoringStatsMenu();
            System.out.println();
        }

        else if(option == 3){
            GalamseyEventsGreater(monitor);
            MonitoringStatsMenu();
            System.out.println();
        }

        else if(option == 4){
            MainMenu();
        }

        else if(option == 0){
            System.out.println("Thank You.");
        }

    }

    
    /**
     * This method is used to print all the recorded observatories.
     * @param monitor
     */
    public static void showObservatories(Monitoring monitor){
        monitor.printAllEvents();
        MainMenu();
    }

    // This method is used to show the statistics about a particular observatory.
    /**
     * 
     * @param monitor
     */
    public static void showStatistics(Monitoring monitor){
        System.out.println("Largest average color value: "+ monitor.getLargestAverage()+" Obtained From: "
                + monitor.getObservatoryWithLargestAverageColorValue());
        System.out.println("Largest galamsey value: " +monitor.getLargestValueRecorded() );
        MainMenu();
    }

    // This method returns galamsey events greater than a given color value.
    /**
     * 
     * @param monitor
     */
    public static void GalamseyEventsGreater(Monitoring monitor){
        int value = 0;
        Scanner val = new Scanner(System.in);
        System.out.println("Enter value to compare with: ");

        value = val.nextInt();
        for(Galamsey events:monitor.getObservatoryRecordsGreaterThan(value)){
            System.out.println(events);
        }

        MainMenu();
    }


    // This method is user to take user inputs on a particular observatory.

    public static void ObservatoryInput(){
        Scanner obsInput = new Scanner(System.in);
        System.out.print("Enter Observatory name: ");
        String obsName = obsInput.nextLine();

        System.out.println();
        System.out.print("Enter observatory country: ");
        String obsCountry = obsInput.next();

        System.out.println();
        System.out.print("Enter observatory year: ");
        int obsYear = obsInput.nextInt();

        System.out.println();
        System.out.print("Enter observatory area: ");
        double obsArea = obsInput.nextDouble();

        Observatory observatory1 = new Observatory(obsName,obsCountry,obsYear,obsArea);
        try {
            observatory1.addtoDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        

    }

    // This method is used to take user inputs on a particular galamsey.

    public static void GalamseyInput(){
        Scanner GalamInput = new Scanner(System.in);

        int i = 0;

        if(Monitoring.monitor.size() == 0){
            System.out.println("Sorry");
            MainMenu();
        }
        System.out.println("Enter Observatory name");

        for(Observatory event: Monitoring.monitor){
            System.out.println(i + " " +event.getObservatoryName());
            i++;
        }

        int control = GalamInput.nextInt();
        newObservatory = Monitoring.monitor.get(control);

        GalamInput.nextLine();
        System.out.println("Enter galamsey activity for "+newObservatory.getObservatoryName());

        System.out.println("Enter Vegetation Color:");
        String VegColor = GalamInput.nextLine();

        System.out.println("Enter Color value:");
        int VegColorValue = GalamInput.nextInt();

        GalamInput.nextLine();
        System.out.println("Enter Latitude:");
        double latitude = GalamInput.nextDouble();

        System.out.println("Enter Longitude:");
        double longitude = GalamInput.nextDouble();

        System.out.println("Enter Year of Galamsey:");
        int YearofGalam = GalamInput.nextInt();

        newObservatory.recordGalamsey(VegColor, VegColorValue, new Position(latitude,longitude), YearofGalam);

    }

    // This method loads the database with the user - inputted values.
    
    public static void loadDatabaseInfo(){
        try {
            MonitoringIO.database.loadObservatoryData();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try{
            MonitoringIO.database.loadGalamseyData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    

    public static void main(String[] args){
        loadDatabaseInfo();
        MainMenu();
    }
}

            