package notesapp.controller;

import java.io.File;
import javafx.scene.control.Alert;
import util.TODOutil;

/**
 *
 * @author Lama
 */
public class Workspace {

    public static Workspace workspace;
    private static File f;
    private String path;

    private final String notesapp = "/.notesapp";
    private final String goals = "/goals";
    private final String planning = "/planning";
    private final String notepad = "/notepad";
    private final String mail = "/mail";
    private final String outline = "/outline";
    private final String diagrams = "/diagrams";

    public static Workspace getInstance(String path) {
        f = new File(path);

        if (workspace == null) {
            workspace = new Workspace(path);
        }
        return workspace;
    }

    private Workspace(String pathname) {
        this.path = pathname;
    }

    public boolean createWorkingDirectories() {
        if (f.isDirectory()) {
            File notesappFile = new File(this.path + notesapp);
            File goalsFile = new File(this.path + goals);
            File planningFile = new File(this.path + planning);
            File notepadFile = new File(this.path + notepad);
            File mailFile = new File(this.path + mail);
            File outlineFile = new File(this.path + outline);
            File diagramsFile = new File(this.path + diagrams);

            notesappFile.mkdirs();
            notepadFile.mkdirs();
            goalsFile.mkdirs();
            planningFile.mkdirs();
            mailFile.mkdirs();
            outlineFile.mkdirs();
            diagramsFile.mkdirs();

            return true;

        } else {
            return false;
        }
    }

    public void exportRecent() {
        TODOutil util = new TODOutil();
        System.err.println("todo");
        util.todooo();
    }
}
