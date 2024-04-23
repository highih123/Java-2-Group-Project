package autominder;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class AutoMinderApp extends Application 
{
   @Override
   public void start(Stage initialstage) throws IOException
   {
      Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
      Scene scene = new Scene(root, 400, 400);
      initialstage.setScene(scene);
      initialstage.setTitle("AutoMinder");
      initialstage.show();
   }
}