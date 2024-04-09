package autominder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class UpdateMaintenanceController {

   @FXML
   private Button BackButton;

   @FXML
   private DatePicker BatteryChangeDatePicker;

   @FXML
   private Button CloseButton;

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
   void handleBackButton(ActionEvent event) {
   
   }

   @FXML
   void handleCloseButton(ActionEvent event)
   {
      System.exit(0);
   }

}
