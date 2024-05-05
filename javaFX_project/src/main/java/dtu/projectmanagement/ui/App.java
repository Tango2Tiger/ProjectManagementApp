package dtu.projectmanagement.ui;

import dtu.projectmanagement.businesslogic.OperationNotAllowedException;
import dtu.projectmanagement.businesslogic.ProjectManagementApp;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 * @author huba
 */
public class App extends Application {

    private static Scene scene;

    private static ProjectManagementApp projectManagementApp = new ProjectManagementApp();

    @Override
    public void start(Stage stage) throws IOException, OperationNotAllowedException {
        scene = new Scene(loadFXML("login"), 640, 480);
        stage.setScene(scene);
        projectManagementApp.registerEmployee("Hubert", "Baumeister");
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {

        launch(App.class, args);
    }

    public static ProjectManagementApp getProjectManagementApp() {
        return projectManagementApp;
    }


}