package autominder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import java.io.IOException;

public class MainMenuController 
{

   @FXML
    private Button AddACarButton;

   @FXML
    private Button ChooseACarButton;

   @FXML
    private Button CloseButton;

   @FXML
    private void handleAddACarButton(ActionEvent event) throws IOException
   {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("AddCar.fxml"));
      Parent parent = loader.load();
      Scene scene = new Scene(parent);
      Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
      window.setScene(scene);
      window.show();
   }

   @FXML
    void handleChooseACarButton(ActionEvent event) {
   
   }

   @FXML
    void handleCloseButton(ActionEvent event) 
   {
      System.exit(0);
   }

}
