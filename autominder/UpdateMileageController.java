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

public class UpdateMileageController {
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
    private void handleContinueButton(ActionEvent event) throws IOException
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
    void handleCurrentMileageTextField(ActionEvent event) {

    }
    
    public void setModel(Model model)
    {
      this.model = model;
    }

}
