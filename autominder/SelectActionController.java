package autominder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class SelectActionController { 
//Controller for SelectAction.fxml
   private Model model;

   @FXML
    private Button BackButton;

   @FXML
    private Button CheckMaintenanceButton;

   @FXML
    private Button LogExpensesButton;

   @FXML
    private Button LogMaintenanceButton;

   @FXML
    private Label makeTextLabel;

   @FXML
    private Label modelTextLabel;

   @FXML
    private Label yearTextLabel;
    
   
    
   @FXML
    private Button updateMileageButton;

   @FXML
   private void handleBackButton(ActionEvent event) throws IOException
   // Loads SeletAVehicle.fxml from the Back Button press
   {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("SelectAVehicle.fxml"));
      Parent parent = loader.load();
      Scene scene = new Scene(parent);
      Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
      window.setScene(scene);
      loader.<SelectAVehicleController>getController().setModel(model);
      loader.<SelectAVehicleController>getController().updateTable();
      loader.<SelectAVehicleController>getController().fakeQuery();
      window.show();
   }

   @FXML
   private void handleCheckMaintenanceButton(ActionEvent event) throws IOException
   /* if 'clicked' is not equal to 7, an alertbox appears. To make it equal to 7 you
   must click the update mileage button and set your car's current mileage.
   
   If this is fufilled, Loads MaintenanceResults.fxml from the Check maintenance button press */
   {
      if(model.getClicked() != 7)
      {
         Alert a = new Alert(AlertType.WARNING);
         a.setHeaderText("Update your car's mileage");
         a.setContentText("Please update your cars current mileage before continuing!");
         a.show();
         return;
      }
      
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("MaintenanceResults.fxml"));
      Parent root = loader.load();
      Scene scene = new Scene(root);
      Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      stage.setScene(scene);
      loader.<MaintenanceResultsController>getController().setModel(model);
      loader.<MaintenanceResultsController>getController().setLabels();
      loader.<MaintenanceResultsController>getController().setOverdue();
      stage.show();
   }

   @FXML
    private void handleLogExpensesButton(ActionEvent event) throws IOException
    //Loads Expenses.fxml from the Log Expenses button press
   {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("Expenses.fxml"));
      Parent root = loader.load();
      Scene scene = new Scene(root);
      Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      stage.setScene(scene);
      loader.<ExpensesController>getController().setModel(model);
      loader.<ExpensesController>getController().setLabels();
      stage.show();
   }

   @FXML
   private  void handleLogMaintenanceButton(ActionEvent event)throws IOException 
   //Loads UpdateMaintenance.fxml from the Log Maintenance Button press
   {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("UpdateMaintenance.fxml"));
      Parent root = loader.load();
      Scene scene = new Scene(root);
      Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      stage.setScene(scene);
      loader.<UpdateMaintenanceController>getController().setModel(model);
      loader.<UpdateMaintenanceController>getController().setLabels();
      stage.show();
   }
   
   @FXML
   private void handleUpdateMileageButton(ActionEvent event) throws IOException
   //Loads UpdateMileage.fxml from the Update Mileage Button press
   {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("UpdateMileage.fxml"));
      Parent root = loader.load();
      Scene scene = new Scene(root);
      Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      stage.setScene(scene);
      loader.<UpdateMileageController>getController().setModel(model);
      loader.<UpdateMileageController>getController().setLabels();
      stage.show();
   }
   
   public void setLabels()
   /* Sets the year, make, model, labels text to the selected
   cars values stored in the Model through 'get' methods. */
   {
      yearTextLabel.setText(Integer.toString(model.getYear()));
      makeTextLabel.setText(model.getMake());
      modelTextLabel.setText(model.getModel());
   }
   
   public void setModel(Model model) //sets the model to the previous scene's model
   {
      this.model = model;
   }

}
