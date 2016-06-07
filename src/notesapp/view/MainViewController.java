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
import notesapp.Conf;
import notesapp.NotesApp;
import notesapp.controller.Workspace;
import util.SQLiteUtil;

/**
 * FXML Controller class Main View Controller. Includes main - top menu.
 *
 * @author Lama
 */
public class MainViewController {

    /**
     * all topmenu
     */
    @FXML
    private MenuBar topMenuBar;

    /**
     * MenuItem that close app
     */
    @FXML
    private MenuItem closeMenuItem;

    /**
     * create workspace. Worspace only!!!
     */
    @FXML
    private MenuItem createMenuItem;

    /**
     * synchronize all data with remoted server
     */
    @FXML
    private MenuItem syncMenuItem;

    /**
     * open workspace. Workspace only!!!
     */
    @FXML
    private MenuItem openMenuItem;

    /**
     * export. It may be export current view or any to to pdf/img/doc etc.
     */
    @FXML
    private MenuItem exportMenuItem;

    /**
     * main app class example
     */
    private final NotesApp app = new NotesApp();

    private Conf conf = Conf.getInstance();

    SQLiteUtil sQLiteUtil = new SQLiteUtil(NotesApp.db);

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

    /**
     * open workspace
     *
     * TODO: action on close without select any item/dir
     */
    @FXML
    private void openWorkspace() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Open Workspace");
        File f = directoryChooser.showDialog(new Stage());
        Workspace workspace = Workspace.getInstance(f.getAbsolutePath());
        app.setWorkspace(workspace);

    }

    /**
     * create workspace in selected directory.
     */
    @FXML
    public void createWorkspace() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Choose directory");
        File f = directoryChooser.showDialog(new Stage());
        String fName = f.getAbsolutePath();
        Workspace workspace = Workspace.getInstance(fName);
        workspace.createWorkingDirectories();
        app.setWorkspace(workspace);

        if (!conf.workspaceInDB()) {
            sQLiteUtil.insert("insert into configuration (id, name, value) values (1, 'workspace', " + fName + ")");
            System.out.println("seted");
        }
    }

    /**
     * export all what we can to export to all what usually needed to export
     */
    @FXML
    private void export() {
//        Workspace workspace = Workspace.getInstance(d);
    }
}
