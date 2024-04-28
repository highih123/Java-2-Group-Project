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
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.ObservableList;
import java.io.IOException;

public class MainMenuController //Controller for MainMenu.fxml
{
   private Model model;

   @FXML
    private Button AddACarButton;

   @FXML
    private Button ChooseACarButton;

   @FXML
    private Button CloseButton;
    

   @FXML
    private void handleAddACarButton(ActionEvent event) throws IOException
    /* Loads AddCar.fxml through the Add a Car button*/
   {
   
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("AddCar.fxml"));
      Parent root = loader.load();
      Scene scene = new Scene(root);
      Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      stage.setScene(scene);
      loader.<AddCarController>getController().setModel(model);
      stage.show();
   }

   @FXML
    private void handleChooseACarButton(ActionEvent event) throws IOException
    //Loads SelectAVehicle.fxml through the Choose A Car button
   {
    
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("SelectAVehicle.fxml"));
      Parent root = loader.load();
      Scene scene = new Scene(root);
      Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      stage.setScene(scene);
      loader.<SelectAVehicleController>getController().initialize();
      loader.<SelectAVehicleController>getController().setModel(model);
      loader.<SelectAVehicleController>getController().updateTable();
      loader.<SelectAVehicleController>getController().fakeQuery();
      loader.<SelectAVehicleController>getController().setModel(model);
      stage.show();
   
   }

   @FXML
    void handleCloseButton(ActionEvent event) 
    //Forces the app to close through the Close Button press
   {
      System.exit(0);
   }
   
   public void setModel(Model model) 
   //Sets the model equal to the initialize() method's model
   {
      this.model = model;
   }
   
   @FXML
   public void initialize() // Initializes model
   {
      model = new Model();
   }  
   
}
