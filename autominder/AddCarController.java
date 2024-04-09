package autominder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.Parent;
import java.io.IOException;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddCarController {

   @FXML
    private Button BackButton;

   @FXML
    private Button CloseButton;

   @FXML
    private Button ContinueButton;

   @FXML
    private Button DeleteButton;

   @FXML
    private TextField MakeTextField;

   @FXML
    private TextField MileageTextField;

   @FXML
    private TextField ModelTextField;

   @FXML
    private TextField YearTextField;

   @FXML
    private void handleBackButton(ActionEvent event) throws IOException
   {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("MainMenu.fxml"));
      Parent parent = loader.load();
      Scene scene = new Scene(parent);
      Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
      window.setScene(scene);
      window.show();
   }

   @FXML
    void handleCloseButton(ActionEvent event) 
   {
      System.exit(0);
   }

   @FXML
    void handleContinueButton(ActionEvent event) {
   
   }

   @FXML
    void handleDeleteButton(ActionEvent event) {
   
   }

}
