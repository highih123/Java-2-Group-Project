package autominder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.Parent;
import java.io.IOException;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MaintenanceResultsController { 

/* This is the controller for AutoMinderApp, from here you can load
either AddCar.fxml or SelectAVehicle.fxml */

   private Model model;

   @FXML
    private Label AirFilterMiles;

   @FXML
    private Label AirFilterOverdue;

   @FXML
    private Button BackButton;

   @FXML
    private Label BatteryReplacementMiles;

   @FXML
    private Label BatteryReplacementOverdue;

   @FXML
    private Button HomeButton;

   @FXML
    private Label OilChangeMiles;

   @FXML
    private Label OilChangeOverdue;

   @FXML
    private Label SparkPlugReplacementMiles;

   @FXML
    private Label SparkPlugReplacementOverdue;

   @FXML
    private Label TireReplacementMiles;

   @FXML
    private Label TireReplacementOverdue;

   @FXML
    private Label TireRotationMiles;

   @FXML
    private Label TireRotationOverdue;
    
    
   @FXML
    private Label makeLabel;

   @FXML
    private Label mileageLabel;

   @FXML
    private Label modelLabel;

   @FXML
    private Label yearLabel;
    
   @FXML
    private Label newMileageLabel;

   @FXML
    private void handleBackButton(ActionEvent event) throws IOException
   {
      /* Loads SelectAction.fxml through the back button press */
      
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("SelectAction.fxml"));
      Parent root = loader.load();
      Scene scene = new Scene(root);
      Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      stage.setScene(scene);
      loader.<SelectActionController>getController().setModel(model);
      loader.<SelectActionController>getController().setLabels();
      stage.show();
   }

   @FXML
   private void handleHomeButton(ActionEvent event) throws IOException
   {
      /* Loads MainMenu.fxml through the home button press */
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("MainMenu.fxml"));
      Parent root = loader.load();
      Scene scene = new Scene(root);
      Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      stage.setScene(scene);
      loader.<MainMenuController>getController().setModel(model);
      stage.show();
   }
   
   public void setLabels() 
   /*Sets the year, make, model, and mileage labels text to the selected
   cars values stored in the Model through 'get' methods.
   
   The following is the different frequencies used to decide how often
   the part changes need to happen:
   
   Oil change every 3000 miles, air filter: 15,000, tires 50k,
   tire rotation 7,500, battery 50k, spark plug 50k.*/
   {
      yearLabel.setText(Integer.toString(model.getYear()));
      makeLabel.setText(model.getMake());
      modelLabel.setText(model.getModel());
      mileageLabel.setText(Integer.toString(model.getMileage()));
      newMileageLabel.setText(Integer.toString(model.getUpdatedMileage()));
      
   }
   
   public void setOverdue()
   /*Sets the various Overdue labels as visible if the various getDifference methods in the model
   return less than  or equal to zero.*/
   {
      OilChangeMiles.setText(Integer.toString(model.getOilDifference()));
      if(model.getOilDifference() <= 0)
      {
         OilChangeOverdue.setVisible(true);
      }
      
      AirFilterMiles.setText(Integer.toString(model.getAirFilterDifference()));
      if(model.getAirFilterDifference() <= 0)
      {
         AirFilterOverdue.setVisible(true);
      }
      
      TireReplacementMiles.setText(Integer.toString(model.getTireReplacementDifference()));
      if(model.getTireReplacementDifference() <= 0)
      {
         TireReplacementOverdue.setVisible(true);
      }
      
      TireRotationMiles.setText(Integer.toString(model.getTireRotationDifference()));
      if(model.getTireRotationDifference() <= 0)
      {
         TireRotationOverdue.setVisible(true);
      }
      
      BatteryReplacementMiles.setText(Integer.toString(model.getBatteryDifference()));
      if(model.getBatteryDifference() <= 0)
      {
         BatteryReplacementOverdue.setVisible(true);
      }
      
      SparkPlugReplacementMiles.setText(Integer.toString(model.getSparkplugDifference()));
      if(model.getSparkplugDifference() <= 0)
      {
         SparkPlugReplacementOverdue.setVisible(true);
      }
      
      
   }
   
   public void setModel(Model model) // sets this model equal to the previous scene's model
   {
      this.model = model;
   }

}
