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

public class SelectActionController {
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
   {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("SelectAVehicle.fxml"));
      Parent parent = loader.load();
      Scene scene = new Scene(parent);
      Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
      window.setScene(scene);
      loader.<SelectAVehicleController>getController().setModel(model);
      loader.<SelectAVehicleController>getController().updateTable();
      window.show();
   }

   @FXML
   private void handleCheckMaintenanceButton(ActionEvent event) throws IOException
   {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("MaintenanceResults.fxml"));
      Parent root = loader.load();
      Scene scene = new Scene(root);
      Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      stage.setScene(scene);
      loader.<MaintenanceResultsController>getController().setModel(model);
      stage.show();
   }

   @FXML
    private void handleLogExpensesButton(ActionEvent event) throws IOException
   {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("Expenses.fxml"));
      Parent root = loader.load();
      Scene scene = new Scene(root);
      Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      stage.setScene(scene);
      loader.<ExpensesController>getController().setModel(model);
      stage.show();
   }

   @FXML
   private  void handleLogMaintenanceButton(ActionEvent event)throws IOException 
   {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("UpdateMaintenance.fxml"));
      Parent root = loader.load();
      Scene scene = new Scene(root);
      Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      stage.setScene(scene);
      loader.<UpdateMaintenanceController>getController().setModel(model);
      stage.show();
   }
   
   @FXML
   private void handleUpdateMileageButton(ActionEvent event) throws IOException
   {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("UpdateMileage.fxml"));
      Parent root = loader.load();
      Scene scene = new Scene(root);
      Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      stage.setScene(scene);
      loader.<UpdateMileageController>getController().setModel(model);
      stage.show();
   }
   
   public void setYearLabel()
   {
   
   }
   
   public void setModel(Model model) 
  {
   this.model = model;
  }

}
