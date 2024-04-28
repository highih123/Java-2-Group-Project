package autominder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;

public class Model /* Functions as the Model in our app, holds all data
'Car.java' is an extension of the Model*/
{  
   private int year;
   private String make;
   private String model;
   private int mileage;
   private int expenses;
   
   private int updatedMileage;
   
   private int oilDifference;
   private int airfilterDifference;
   private int tireReplacementDifference;
   private int tireRotationDifference;
   private int batteryDifference;
   private int sparkPlugDifference;
   
   private int lastAirfilter;
   private int lastTire;
   private int lastRotation;
   private int lastOilChange;
   
   private int clicked = 0;
   
   private int gas;
   private int motor;
   private int tire;
   private int newExpenses;
   private int combinedExpenses;
   
   private String insertStringOne;
   private String insertStringTwo;
   private String insertStringThree;
   private String insertStringFour;
   private String insertStringFive;
   
   private String updateMileage;
   
   private ObservableList<Car> cars;
   
   public Model() //Initializes cars Observable ArrayList
   {
      cars = FXCollections.observableArrayList();
   }  
   
   public void updateCarList(String searchString)
    /*Initializes newList, queries the database
     with one user input (searchString) for the wildcard
     uses a prepared statement to protect from SQLinjection */
   {
      ObservableList<Car> newList = FXCollections.observableArrayList();
      
      Connection connection = null;
      
      try
      {
         connection = DriverManager.getConnection("jdbc:sqlite:resources/Cars.db");
         
         Statement statement = connection.createStatement();
         String updateString = "SELECT year, make, model, mileage, expenses FROM " +
         "cars WHERE year LIKE ?";
         PreparedStatement ps = connection.prepareStatement(updateString);
         ps.setString(1, "%" + searchString + "%");
         ResultSet rs = ps.executeQuery(); 
         
         while(rs.next())
         {
            newList.add(new Car(rs.getInt("year"), rs.getString("make"),
               rs.getString("model"), rs.getInt("mileage"), rs.getInt("expenses")));
         }
      }
      catch(SQLException e)
      {
         e.printStackTrace();
      }
      cars = newList;
      setCars(newList);
   }
   
   public void insertCarList(String insertStringOne, String insertStringTwo, String insertStringThree, String insertStringFour, String insertStringFive)
   /*Inserts a new row into the Cars database using the five user inputs
    into the text fields in 'AddCar' */
   {
      
      Connection connection = null;
      
      try
      {
         connection = DriverManager.getConnection("jdbc:sqlite:resources/Cars.db");
         
         Statement statement = connection.createStatement();
         // statement.executeUpdate("drop table if exists cars");
         // statement.executeUpdate("create table cars (year int, make String, model String, mileage int, expenses int)");
         String updateString = "INSERT INTO cars " + "VALUES (?, ?, ?, ?, ?)";
         PreparedStatement ps = connection.prepareStatement(updateString);
         ps.setString(1,insertStringOne);
         ps.setString(2,insertStringTwo); 
         ps.setString(3,insertStringThree);
         ps.setString(4,insertStringFour);
         ps.setString(5,insertStringFive);
         ps.executeUpdate();
      }
      catch(SQLException e)
      {
         e.printStackTrace();
      }
   
   }
   
   public void updateMileage(String updateMileage, int mileage)
   /* sets clicked to 7, updates the mileage field
    for the car that has been picked in the tableView. Updates database.*/
   {
      clicked = 7;
      
      Connection connection = null;
      
      try
      {
         connection = DriverManager.getConnection("jdbc:sqlite:resources/Cars.db");
         
         Statement statement = connection.createStatement();
         String updateString = " update cars SET mileage = ? WHERE mileage = ?";
         PreparedStatement ps = connection.prepareStatement(updateString);
         ps.setString(1, updateMileage);
         ps.setInt(2, mileage);
         ps.executeUpdate();
      }
      catch(SQLException e)
      {
         e.printStackTrace();
      }
   
   }
   
   public void updateExpenses(int newExpenses, int expenses)
   /*  updates the expenses field
    for the car that has been picked in the tableView. Updates database.*/
   {
      
      Connection connection = null;
      
      try
      {
         connection = DriverManager.getConnection("jdbc:sqlite:resources/Cars.db");
         
         Statement statement = connection.createStatement();
         String updateString = " update cars SET expenses = ? WHERE expenses = ?";
         PreparedStatement ps = connection.prepareStatement(updateString);
         ps.setInt(1, newExpenses);
         ps.setInt(2, expenses);
         ps.executeUpdate();
      }
      catch(SQLException e)
      {
         e.printStackTrace();
      }
   
   }

   
   public ObservableList<Car> getCars() // returns the cars observable List
   { 
      return cars;
   }
   
   public void setCars(ObservableList<Car> cars) // sets the cars observable list
   {
      this.cars = cars;
   }
   
   public int getYear() // returns year for selected Car object
   {
      return year;
   }
   
   public void setYear(int year) // sets year for selected Car object
   {
      this.year = year;
   }
   
   public String getMake() // returns make for selected Car object
   {
      return make;
   }
   
   public void setMake(String make) // sets make for selected Car object
   {
      this.make = make;
   }
   
   public String getModel() // returns model
   {
      return model;
   }
   
   public void setModel(String model) // sets the model
   {
      this.model = model;
   }
   
   public int getMileage() // returns mileage for selected Car object
   {
      return mileage;
   }
   
   public void setMileage(int mileage) // sets mileage for selected Car object
   {
      this.mileage = mileage;
   }
   
   public int getExpenses() // returns expenses for selected Car object
   {
      return expenses;
   }
   
   public void setExpenses(int expenses) // sets expenses for selected Car object
   {
      this.expenses = expenses;
   }
   
   public int getUpdatedMileage() // returns updatedMileage for selected Car object
   {
      return updatedMileage;
   }
   
   public void setUpdatedMileage(int updatedMileage) // sets updatedMileage from user input in 'UpdateMileageController'
   {
      this.updatedMileage = updatedMileage;
   }
   
   public int getOilDifference() // returns oilDifference using formula
   {
      return 3000 - (getUpdatedMileage() - getMileage());
   }
   
   public int getAirFilterDifference() // returns airfilterDifference using formula
   {
      return 15000 - (getUpdatedMileage() - getMileage());
   }
   
   public int getTireReplacementDifference() // returnsTireReplacementDifference using formula
   {
      return 50000 - (getUpdatedMileage() - getMileage());
   }
   
   public int getTireRotationDifference() // returns tireRotationDifference using formula
   {
      return 7500 - (getUpdatedMileage() - getMileage());
   
   }
   
   public int getBatteryDifference() // returns batteryDifference using formula
   {
      return 50000 - (getUpdatedMileage() - getMileage());
   }
   
   public int getSparkplugDifference() // returns sparkplugDifference using formula
   {
      return 50000 - (getUpdatedMileage() - getMileage());
   }
   
   public void setLastAirfilter(int lastAirfilter) // sets lasAirfilter from user input in 'UpdateMaintenanceController'
   {
      this.lastAirfilter = lastAirfilter;
   }
   
   public void setLastTire(int lastTire) // sets lastTire from user input in 'UpdateMaintenanceController'
   {
      this.lastTire = lastTire;
   }
   
   public void setLastRotation(int lastRotation) // sets lastRotation from user input in 'UpdateMaintenanceController'
   {
      this.lastRotation = lastRotation;
   }
   
   public void setLastOilChange(int lastOilChange) // sets lastOilChange from user input in 'UpdateMaintenanceController'
   {
      this.lastOilChange = lastOilChange;
   }
      
   public int getClicked() // returns clicked
   {
      return clicked;
   }   
   
   public void setClicked(int clicked) // sets clicked. Either 0 or 7.
   {
      this.clicked = clicked;
   }
   
   public int getGas() // returns gas
   {
      return gas;
   }
   public void setGas(int gas) // sets gas
   {
      this.gas = gas;
   }
   
   public int getMotor() // returns motor
   {
      return motor;
   }
   public void setMotor(int motor) // sets motor
   {
      this.motor = motor;
   }
   
   public int getTire() // returns tire
   {
      return tire;
   }
   public void setTire(int tire) // sets tire
   {
      this.tire = tire;
   }
   
   public int getNewExpenses() // returns newExpenses
   {
      return newExpenses;
   }
   
   public void setNewExpenses(int newExpenses) // sets newExpenses
   {
      this.newExpenses = newExpenses;
   }
   
   public int getCombinedExpenses() // returns getNewExpenses() plus getExpenses()
   {
      return getNewExpenses() + getExpenses();
   }

}