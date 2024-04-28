package autominder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import java.io.IOException;
import javafx.fxml.FXMLLoader;

public class ExpensesController { 
//Controller for Expenses.fxml
   private Model model;


   @FXML
    private Button LogExpensesButton;

   @FXML
    private Button backButton;

   @FXML
    private TextField gasExpensesTextField;

   @FXML
    private Label makeLabel;

   @FXML
    private Label modelLabel;

   @FXML
    private TextField motorMaintenanceExpenses;

   @FXML
    private TextField tireExpensesTextField;

   @FXML
    private Label yearLabel;
    
   @FXML
    private Button totalButton;
    
   @FXML
    private Label totalLabel;

   @FXML
   private  void handleBackButton(ActionEvent event) throws IOException
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
    private void handleLogExpensesButton(ActionEvent event) throws IOException
    /* Loads SelectAction.fxml throug the Log Expenses Button press
    
    Causes an alert to inform the user of their 
    new lifetime expenses on their selected car,
    updates the database with this new expenses total*/
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
      
      
      model.setNewExpenses(Integer.parseInt(totalLabel.getText()));
   
      Alert a = new Alert(AlertType.WARNING);
      a.setHeaderText("Lifetime Expenses");
      a.setContentText("Your lifetime expenses for your " + model.getYear() + " " + model.getMake() + " " + model.getModel() + " is: $" + model.getCombinedExpenses());
      a.show();
      
      model.updateExpenses(model.getCombinedExpenses(), model.getExpenses());
   }
   
   @FXML
    void handleTotalButton(ActionEvent event) 
   {  model.setNewExpenses(Integer.parseInt(gasExpensesTextField.getText()) + Integer.parseInt(motorMaintenanceExpenses.getText()) + Integer.parseInt(tireExpensesTextField.getText()));
      totalLabel.setText(Integer.toString(model.getNewExpenses()));
   }
   
   public void setLabels() /*Sets the year, make, and model labels text
     equal to the selected car's model values.*/
   {
      yearLabel.setText(Integer.toString(model.getYear()));
      makeLabel.setText(model.getMake());
      modelLabel.setText(model.getModel());
   }

   
   public void setModel(Model model) // sets the model to the model from the previous scene
   {
      this.model = model;
   }


}