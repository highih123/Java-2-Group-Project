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
    private void handleAddAVehicle(ActionEvent event) throws IOException
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
    private void handleTableView(MouseEvent event) throws IOException
   {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("SelectAction.fxml"));
      Parent root = loader.load();
      Scene scene = new Scene(root);
      Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      stage.setScene(scene);
      loader.<SelectActionController>getController().setModel(model);
      loader.<SelectActionController>getController().setYearLabel();
      
      stage.show();
   }
   
   @FXML
    void handleSearchButton(ActionEvent event)
   {
      //model.insertCarList("2000", "Hyundai", "Civic", "45000");
      model.updateCarList(yearTextField.getText());
      tableView.setItems(model.getCars());
   }

   @FXML
    void handleYearTextField(ActionEvent event)
   {
      handleSearchButton(event);
   }
   
   @FXML
   public void initialize()
   {
      makeColumn.setCellValueFactory(new PropertyValueFactory<Car, String>("make"));
      mileageColumn.setCellValueFactory(new PropertyValueFactory<Car, Integer>("mileage"));
      modelColumn.setCellValueFactory(new PropertyValueFactory<Car, String>("model"));
      yearColumn.setCellValueFactory(new PropertyValueFactory<Car, Integer>("year"));
     
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
   
   
   public void setModel(Model model)
   {
      this.model = model;
   }

}
