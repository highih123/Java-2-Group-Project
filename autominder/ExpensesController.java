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
    void handleGasExpensesTextField(ActionEvent event) {
   
   }

   @FXML
    void handleLogExpensesButton(ActionEvent event) 
   {
    //Edit this
      Alert a = new Alert(AlertType.WARNING);
      a.setHeaderText("Lifetime Expenses");
      a.setContentText("Your lifetime expenses for your 2000 Hyundai Civic is: $1500");
      a.show();
      return;
   }

   @FXML
    void handleMotorMaintenanceExpenses(ActionEvent event) {
   
   }

   @FXML
    void handleTireExpensesTextField(ActionEvent event) {
   
   }

   @FXML
    void handleTotalExpensesTextField(ActionEvent event)
   {
     
   }
   
   @FXML
    void handleTotalButton(ActionEvent event) 
    {
         totalLabel.setText("1500"); //change
    }
   
   public void setModel(Model model)
   {
      this.model = model;
   }


}