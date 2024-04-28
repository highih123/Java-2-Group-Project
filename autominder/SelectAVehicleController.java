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


public class SelectAVehicleController 
//Controller for SelectAVehicle.fxml
{
   private Model model;

   @FXML
    private Button addAVehicle;

   @FXML
    private Button backButton;
    
   @FXML
    private Button searchButton;
    
    
   @FXML
    private TextField yearTextField;
    
    
   @FXML
    private TableView<Car> tableView;
    
   @FXML
    private TableColumn<Car, String> makeColumn;

   @FXML
    private TableColumn<Car, Integer> mileageColumn;

   @FXML
    private TableColumn<Car, String> modelColumn;

   @FXML
    private TableColumn<Car, Integer> yearColumn;
    
   @FXML
    private TableColumn<Car, Integer> expensesColumn;
    
   @FXML
    private Button confirmCarButton;

   @FXML
    private void handleAddAVehicle(ActionEvent event) throws IOException
    //Loads AddCar.fxml through Add A Vehicle button press
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
   private void handleBackButton(ActionEvent event) throws IOException
   //Loads MainMenu.fxml through the Back Button press
   {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("MainMenu.fxml"));
      Parent root = loader.load();
      Scene scene = new Scene(root);
      Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      stage.setScene(scene);
      loader.<MainMenuController>getController().setModel(model);
      stage.show();
   }
   
   @FXML
    void handleTableView(MouseEvent event)
    //Sets car object equal to the selected row's values in the table
   {
      Car car = tableView.getSelectionModel().getSelectedItems().get(0);
      model.setYear(tableView.getSelectionModel().getSelectedItems().get(0).getYear());
      model.setMake(tableView.getSelectionModel().getSelectedItems().get(0).getMake());
      model.setModel(tableView.getSelectionModel().getSelectedItems().get(0).getModel());
      model.setMileage(tableView.getSelectionModel().getSelectedItems().get(0).getMileage());
      model.setExpenses(tableView.getSelectionModel().getSelectedItems().get(0).getExpenses());
   
   }
   
   @FXML
   private  void handleConfirmCarButton(ActionEvent event) throws IOException
   //Loads SelectAction.fxml through the Confirm Car Button press
   {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("SelectAction.fxml"));
      Parent root = loader.load();
      Scene scene = new Scene(root);
      Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      stage.setScene(scene);
      loader.<SelectActionController>getController().setModel(model);
      loader.<SelectActionController>getController().setLabels();
      loader.<SelectActionController>getController().setModel(model);
      stage.show();
   }
   
   @FXML
    void handleSearchButton(ActionEvent event) 
    /* queries the database
     and visually updates the tableView to reflect the query */
   {
      model.updateCarList(yearTextField.getText());
      tableView.setItems(model.getCars());
   }

   @FXML
    void handleYearTextField(ActionEvent event) /* Pressing Enter will
     have the same result as the Search Button press */ 
   {
      handleSearchButton(event);
   }
   
   @FXML
   public void initialize() // Initializes the tableView's columns CellValueFactories
   {
      makeColumn.setCellValueFactory(new PropertyValueFactory<Car, String>("make"));
      mileageColumn.setCellValueFactory(new PropertyValueFactory<Car, Integer>("mileage"));
      modelColumn.setCellValueFactory(new PropertyValueFactory<Car, String>("model"));
      yearColumn.setCellValueFactory(new PropertyValueFactory<Car, Integer>("year"));
      expensesColumn.setCellValueFactory(new PropertyValueFactory<Car, Integer>("expenses"));
     
   }
   
   public void updateTable() // updates tableview
   {
      tableView.setItems(model.getCars());
   }
   
   public void fakeQuery() // populates tableview for model and initial presentation
   {
      model.updateCarList(yearTextField.getText());
      tableView.setItems(model.getCars());
   }
   
   public void setModel(Model model) // sets the model equal to the previous scene's model
   {
      this.model = model;
   }

}
