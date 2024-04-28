package autominder;

public class Car /* Apart of the Model, holds the information for One row
in the tableView.*/
{
   private int year;
   private String make;
   private String model;
   private int mileage;
   private int expenses;
   
   public Car(int year, String make, String model, int mileage, int expenses)
   // Constructor for Car object
   {
      super();
      this.year = year;
      this.make = make;
      this.model = model;
      this.mileage = mileage;
      this.expenses = expenses;
   }
   
   public int getYear() // returns the Car object's year
   {
      return year;
   }
   
   public void setYear(int year) // sets the Car object's year
   {
      this.year = year;
   }
   
   public String getMake() // returns the Car object's make
   {
      return make;
   }
   
   public void setMake(String make) // sets the Car object's make
   {
      this.make = make;
   }
   
   public String getModel() // returns the Car object's model
   {
      return model;
   }
   
   public void setModel(String model) //  sets the Car object's model
   {
      this.model = model;
   }
   
   public int getMileage() // returns the Car object's mileage
   {
      return mileage;
   }
   
   public void setMileage(int mileage) // sets the Car object's mileage
   {
      this.mileage = mileage;
   }
   
   public int getExpenses() // returns the Car object's expenses
   {
      return expenses;
   }
   
   public void setExpenses(int expenses) //sets the car object's expenses
   {
      this.expenses = expenses;
   }
}