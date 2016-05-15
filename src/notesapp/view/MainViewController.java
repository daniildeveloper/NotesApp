/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notesapp.view;

import java.io.File;
import java.util.Optional;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import notesapp.NotesApp;
import notesapp.controller.Workspace;

/**
 * FXML Controller class
 *
 * @author Lama
 */
public class MainViewController {

    @FXML
    private MenuBar topMenuBar;

    @FXML
    private MenuItem closeMenuItem;

    @FXML
    private MenuItem createMenuItem;

    @FXML
    private MenuItem syncMenuItem;

    @FXML
    private MenuItem openMenuItem;

    @FXML
    private MenuItem exportMenuItem;


    private NotesApp app = new NotesApp();
    /**
     * Initializes the controller class.
     */
    public void initialize() {
        // TODO
    }

    /**
     * this method make that what make button with usually red background - exit
     */
    @FXML
    public void exitApp() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Exit");
        alert.setHeaderText("Do you really want exit app?");
        alert.setContentText("Please confirm you action");
        Optional<ButtonType> res = alert.showAndWait();

        if (res.get() == ButtonType.OK) {
            Platform.exit();
        }

    }

    @FXML
    private void openWorkspace() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Open Workspace");
        File f = directoryChooser.showDialog(new Stage());
        Workspace workspace = Workspace.getInstance(f.getAbsolutePath());
        app.setWorkspace(workspace);

    }

    @FXML
    public void createWorkspace() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Choose directory");
        File f = directoryChooser.showDialog(new Stage());
        String fName = f.getAbsolutePath();
        Workspace workspace = Workspace.getInstance(fName);
        workspace.createWorkingDirectories();
        app.setWorkspace(workspace);
    }

    @FXML
    private void export() {
//        Workspace workspace = Workspace.getInstance(d);
    }
}
