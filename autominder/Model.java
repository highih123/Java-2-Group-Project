package autominder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;

public class Model
{  
   private int year;
   private String make;
   private String model;
   private int mileage;
   
   private int gas;
   private int motor;
   private int tire;
   
   private String insertStringOne;
   private String insertStringTwo;
   private String insertStringThree;
   private String insertStringFour;
   
   private ObservableList<Car> cars;
   
   public Model() //Initializes cars Observable List
   {
      cars = FXCollections.observableArrayList();
      cars.add(new Car(2003, "Lexus", "RX 300", 200000));
      cars.add(new Car(2000, "Hyundai", "Civic", 45000));
   }  
   
   public void updateCarList(String searchString)
   {
      ObservableList<Car> newList = FXCollections.observableArrayList();
      
      Connection connection = null;
      
      try
      {
         connection = DriverManager.getConnection("jdbc:sqlite:resources/Cars.db");
         
         Statement statement = connection.createStatement();
         //statement.executeUpdate("drop table if exists cars");
         //statement.executeUpdate("create table cars (year int, make String, model String, mileage int)");
         String updateString = "SELECT year, make, model, mileage FROM " +
            "cars WHERE year LIKE ?";
         PreparedStatement ps = connection.prepareStatement(updateString);
         ps.setString(1, "%" + searchString + "%");
         ResultSet rs = ps.executeQuery(); 
         
         while(rs.next())
         {
            newList.add(new Car(rs.getInt("year"), rs.getString("make"),
               rs.getString("model"), rs.getInt("mileage")));
         }
      }
      catch(SQLException e)
      {
         e.printStackTrace();
      }
      cars = newList;
   }
   
   public void insertCarList(String insertStringOne, String insertStringTwo, String insertStringThree, String insertStringFour)
   {
      ObservableList<Car> newList = FXCollections.observableArrayList();
      
      Connection connection = null;
      
      try
      {
         connection = DriverManager.getConnection("jdbc:sqlite:resources/Cars.db");
         
         Statement statement = connection.createStatement();
         //statement.executeUpdate("drop table if exists cars");
         //statement.executeUpdate("create table cars (year int, make String, model String, mileage int)");
         String updateString = "INSERT INTO cars " + "VALUES (?, ?, ?, ?)";
         PreparedStatement ps = connection.prepareStatement(updateString);
         ps.setString(1,insertStringOne);
         ps.setString(2,insertStringTwo); // may need redone
         ps.setString(3,insertStringThree); // may need redone
         ps.setString(4,insertStringFour); //  all 4 may need + "%", add back insertStringFour
         ps.executeUpdate();
      }
      catch(SQLException e)
      {
         e.printStackTrace();
      }
   
   }
   
   public ObservableList<Car> getCars()
   { 
      return cars;
   }
   
   public void setCars(ObservableList<Car> cars)
   {
      this.cars = cars;
   }
   
   public void UserInput(String insertStringOne, String insertStringTwo, String insertStringThree, String insertStringFour)
   {
      this.insertStringOne = insertStringOne;
      this.insertStringTwo = insertStringTwo;
      this.insertStringThree = insertStringThree;
      this.insertStringFour = insertStringFour;
   } 
   public int getGas()
   {
   return gas;
   }

}