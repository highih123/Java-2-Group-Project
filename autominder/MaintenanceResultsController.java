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
    private void handleBackButton(ActionEvent event) throws IOException
   {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("SelectAction.fxml"));
      Parent root = loader.load();
      Scene scene = new Scene(root);
      Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      stage.setScene(scene);
      loader.<SelectActionController>getController().setModel(model);
      stage.show();
   }

   @FXML
   private void handleHomeButton(ActionEvent event) throws IOException
   {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("MainMenu.fxml"));
      Parent root = loader.load();
      Scene scene = new Scene(root);
      Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      stage.setScene(scene);
      loader.<MainMenuController>getController().setModel(model);
      stage.show();
   }
   
   public void setModel(Model model)
   {
      this.model = model;
   }
   
   // fix labels.
   // Oil change every 5000 miles, air filter: 15,000, tires 50k,
   //  tire rotation 7,500, battery 50k, spark plug 50k.

}
