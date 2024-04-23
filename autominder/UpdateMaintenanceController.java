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
   {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("SelectAction.fxml"));
      Parent root = loader.load();
      Scene scene = new Scene(root);
      Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      stage.setScene(scene);
      stage.show();
   }

     @FXML
    private void handleFinishedButton(ActionEvent event) throws IOException
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("SelectAction.fxml"));
      Parent root = loader.load();
      Scene scene = new Scene(root);
      Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      stage.setScene(scene);
      stage.show();
    }
    
    public void setModel(Model model)
    {
      this.model = model;
    }

}
