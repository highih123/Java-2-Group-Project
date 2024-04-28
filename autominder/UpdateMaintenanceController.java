package autominder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.Node;
import java.io.IOException;

public class UpdateMaintenanceController { 
//Controller for UpdateMaitenance.fxml

   private Model model;

   @FXML
   private Button BackButton;

   @FXML
   private DatePicker BatteryChangeDatePicker;


   @FXML
   private TextField MileageAirFilterReplacementTextField;

   @FXML
   private TextField MileageLastOilChangeTextField;

   @FXML
   private TextField MileageLastTireReplacementTextField;

   @FXML
   private TextField MileageLastTireRotationTextField;

   @FXML
   private TextField MileageTextField;

   @FXML
   private DatePicker OilChangeDatePicker;
   
   @FXML
    private Button finishedButton;

   @FXML
    private Label makeLabel;

   @FXML
    private Label modelLabel;

   @FXML
    private Label yearLabel;

   @FXML
   private void handleBackButton(ActionEvent event) throws IOException
   //Loads SelectAction.fxml from 
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
    private void handleFinishedButton(ActionEvent event) throws IOException
    /* Loads SelectAction.fxml through the Finished Button press
    
     Saves user input into fields in model*/
   {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("SelectAction.fxml"));
      Parent root = loader.load();
      Scene scene = new Scene(root);
      Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      stage.setScene(scene);
      loader.<SelectActionController>getController().setModel(model);
      stage.show();
      
      model.setLastAirfilter(Integer.parseInt(MileageAirFilterReplacementTextField.getText()));
      
      model.setLastTire(Integer.parseInt(MileageLastTireReplacementTextField.getText()));
      
      model.setLastRotation(Integer.parseInt(MileageLastTireRotationTextField.getText()));
      
      model.setLastOilChange(Integer.parseInt(MileageLastOilChangeTextField.getText()));
   }
   
   public void setLabels()
   /* Sets the year, make, model, labels text to the selected
   cars values stored in the Model through 'get' methods. */
   {
      yearLabel.setText(Integer.toString(model.getYear()));
      makeLabel.setText(model.getMake());
      modelLabel.setText(model.getModel());
   }
    
   public void setModel(Model model) //sets model equal to the previous scene's model
   {
      this.model = model;
   }

}
