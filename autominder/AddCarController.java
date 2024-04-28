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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.lang.reflect.InvocationTargetException;


public class AddCarController //Controller for AddCar
{
   private Model model;

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
    private TextField ExpensesTextField;

   @FXML
    private void handleBackButton(ActionEvent event) throws IOException
    /*Loads MainMenu.fxml through the back button press*/
   {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("MainMenu.fxml"));
      Parent parent = loader.load();
      Scene scene = new Scene(parent);
      Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      stage.setScene(scene);
      stage.show();
   }

   @FXML
   private void handleContinueButton(ActionEvent event) throws IOException
   /*Loads MainMenu.fxml through the continue button press.
   Inserts the user inputs in the textfields into the Cars Database */
   {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("MainMenu.fxml"));
      Parent root = loader.load();
      Scene scene = new Scene(root);
      Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      stage.setScene(scene);
      loader.<MainMenuController>getController().setModel(model);
      stage.show();
      
      model.insertCarList(YearTextField.getText(), MakeTextField.getText(), ModelTextField.getText(), MileageTextField.getText(), ExpensesTextField.getText());    
   }
   
   public void setModel(Model model) // Sets this model equal to the initial model. 
   {
      this.model = model;
   }

}