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

public class MaintenceResultsController {

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
    void handleBackButton(ActionEvent event) {
   
   }

   @FXML
   private void handleHomeButton(ActionEvent event) throws IOException
   {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("MainMenu.fxml"));
      Parent parent = loader.load();
      Scene scene = new Scene(parent);
      Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
      window.setScene(scene);
      window.show();
   }

}
