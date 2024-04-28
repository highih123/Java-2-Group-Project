package autominder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class UpdateMileageController {
//Controller for UpdateMileage.fxml
   private Model model;

   @FXML
    private Button backButton;

   @FXML
    private Button continueButton;

   @FXML
    private TextField currentMileageTextField;

   @FXML
    private Label makeLabel;

   @FXML
    private Label modelLabel;

   @FXML
    private Label yearLabel;

   @FXML
    private void handleBackButton(ActionEvent event) throws IOException
    //Loads SelectAction.fxml through the Back Button press
   {
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
    private void handleContinueButton(ActionEvent event) throws IOException
    /*Loads Select Action.fxml through the Confrim Button press
    
    Updates the database for the selected Car object's mileage from user input
    in the currentMileageTextField*/
   {
      try
      {
         FXMLLoader loader = new FXMLLoader();
         loader.setLocation(getClass().getResource("SelectAction.fxml"));
         Parent root = loader.load();
         Scene scene = new Scene(root);
         Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         stage.setScene(scene);
         loader.<SelectActionController>getController().setModel(model);
         loader.<SelectActionController>getController().setLabels();
         stage.show();
         
         model.updateMileage(currentMileageTextField.getText(),model.getMileage());
      
         model.setUpdatedMileage(Integer.parseInt(currentMileageTextField.getText()));
      }
      
      catch(NumberFormatException e)
      {
         Alert a = new Alert(AlertType.WARNING);
         a.setHeaderText("Mileage is an whole number");
         a.setContentText("Please enter a whole number for current mileage");
         a.show();
      }
   }
    
   public void setLabels() /*Sets the year, make, and model labels text
     equal to the selected car's model values.*/
   {
      yearLabel.setText(Integer.toString(model.getYear()));
      makeLabel.setText(model.getMake());
      modelLabel.setText(model.getModel());
   }
    
   public void setModel(Model model)// Sets the model equal to the previous scene's model
   {
      this.model = model;
   }

}
