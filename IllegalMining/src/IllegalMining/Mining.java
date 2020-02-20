/** 
 * @author Kobina Asempa Takyi
 * @author Akwasi Appiadjei Asante - Krobea
 * @author Leslie Nartey - Kodjoe
 * 
 * @version 1.0.0
 * 
*/
package IllegalMining;

import java.awt.*;
import java.sql.*;

// This is used to initialize the variables for the database inputs.

public class Mining {
    Controller controller1 = new Controller();
    String url;
    String username;
    String password;
    String jdbc_driver;


    Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;
    Statement stmt;

    /**
     * This is used to set the connection for the database.
     * @return conn.
     */
    


    public Connection getDbConnection(){
        jdbc_driver = "com.mysql.cj.jdbc.Driver";
        url = "jdbc:mysql://127.0.0.1:3306/Mining_Activity";
        username = "root";
        password = "Asantekrobea12";

        try{
            Class.forName(jdbc_driver);
            conn = DriverManager.getConnection(url, username, password);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return conn;

    }

    /**
     * This allows the user to enter details about the observatory to be stored in the database.
     * @param obser1
     */
   

    public void enterObservatoryData(Observatory obser1){
        String query = "INSERT INTO Observatory(ObsName, country, year_started, area_covered)" +
                "VALUES (?, ?, ?, ?)";
        try {
            pstmt = conn.prepareStatement(query);

            pstmt.setString(1, obser1.getObservatoryName());
            pstmt.setString(2, obser1.getCountry());
            pstmt.setInt(3, obser1.getYearStarted());
            pstmt.setDouble(4, obser1.getArea());

            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

     
    /**
     * This allows for retrieval of details of an observatory in the database.
     * @throws SQLException
     */
   
    public void loadObservatoryData() throws SQLException {
        String query = "SELECT * FROM Observatory";
        stmt = conn.createStatement();
        rs = stmt.executeQuery(query);

        while(rs.next()){
            Observatory o1 = new Observatory(rs.getString(1),rs.getString(2) ,rs.getInt(3),rs.getDouble(4));
        }
    }

     
    /**
     * This allows the user to enter details about the galamsey activities to be stored in the database.
     * @param g1
     * @throws SQLException
     */
    public void enterGalamseyData(Galamsey g1) throws SQLException {
        String query = "INSERT INTO Galamsey(vegetation_color, color_value, latitude, longitude, yearofevent, obsName)" +
                "VALUES (?, ?, ?, ?, ?, ?);";
        pstmt = conn.prepareStatement(query);

        pstmt.setString(1, g1.getvegColor());
        pstmt.setInt(2, g1.getvegColorVal());
        pstmt.setDouble(3, g1.getPosition().getLatitude());
        pstmt.setDouble(4, g1.getPosition().getLongitude());
        pstmt.setInt(5, g1.getYear());
        pstmt.setString(6, g1.getObservatory().getObservatoryName());

        pstmt.executeUpdate();

    }

    
    /**
     * This allows for retrieval of details of a galamsey in the database.
     * @throws SQLException
     */
    public void loadGalamseyData() throws SQLException {
        String query = "SELECT * FROM Galamsey";
        stmt = conn.createStatement();
        rs = stmt.executeQuery(query);

        while(rs.next()){
            Galamsey g1 = new Galamsey(rs.getString(1), rs.getInt(2) ,new Position(rs.getDouble(3), rs.getDouble(4)), rs.getInt(5));

            for(Observatory event: Monitoring.monitor){
                if(rs.getString(6).equals(event.getObservatoryName())){
                    event.addGalamsey(g1);
                }
            }
        }
    }

     
    /**
     * This method displays an observatory when the name is inputted.
     * @return rs
     * @throws SQLException
     */
    public ResultSet ShowObservatories() throws SQLException {
        String query = "SELECT * FROM Observatory";
        stmt = conn.createStatement();
        rs = stmt.executeQuery(query);

        return rs;
    }

     
    /**
     * This shows observatory greater than an arbitary value inputted by the user.
     * @param value
     * @return rs
     * @throws SQLException
     */
    public ResultSet showRecordsGreaterthan(Observatory value) throws SQLException {
        String query = "SELECT * FROM Galamsey WHERE color_value > " + value;
        stmt = conn.createStatement();
        rs = stmt.executeQuery(query);

        return rs;
    }

    
    /**
     * This method is used to display all records of a galamsey activity.
     * @return pstmt.executeQuery
     * @throws SQLException
     */
    public ResultSet showAllGalamseyRecords() throws SQLException {
        String query = "SELECT * FROM Galamsey";
        pstmt = conn.prepareStatement(query);

        return pstmt.executeQuery();
    }


}
