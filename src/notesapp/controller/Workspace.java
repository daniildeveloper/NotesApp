package notesapp.controller;

import java.io.File;
import util.TODOutil;

/**
 * Workspace is very important aspect in this app. It is a directory contains
 * all data in files that app generate and interact. Workspace contains differnt
 * dirs named as tabs in dashboard.
 *
 * Pattern - singleton
 *
 * @author Lama
 */
public class Workspace {

    /**
     * class workspace
     */
    public static Workspace workspace;

    /**
     * directory workspace
     */
    private static File f;

    /**
     * string - absolute path to directory
     */
    private String path;

    /**
     * .notesapp dir. Contains all data for registration, auth, integration,
     * versioning and more. Is important to validate other data in workspace.
     */
    private final String notesapp = "/.notesapp";

    /**
     * dir contains in files all goals for every day/week/year
     */
    private final String goals = "/goals";

    /**
     * planning dir. Contains all ideas and plans
     */
    private final String planning = "/planning";

    /**
     * notepad. I need evernote analog, but free and fast
     */
    private final String notepad = "/notepad";

    /**
     * mail. I need a programm all in one. Mail is very important part of my
     * live. EmClient is best, but not free. I want to have my own email client.
     */
    private final String mail = "/mail";

    /**
     * outline is very big part of my mind. I want to can drag and drop all.
     * Built entitys and actions. Also useful for strategy, business, politic
     * etc.
     */
    private final String outline = "/outline";

    /**
     * diagrams is very simple method to display any statistical information.
     * UML, SVG etc will be save in this dir
     */
    private final String diagrams = "/diagrams";

    /**
     * dashboard contains all information in one page about working progress
     */
    private final String dashboard = "/dashboard";

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

    private Workspace() {

    }

    public static Workspace getInstance() {
        if (workspace == null) {
            workspace = new Workspace();
        }
        return workspace;
    }

    /**
     * create dirs in workspace
     *
     * @return <b>true</b> if creation was successfull, <b>false</b> if not
     */
    public boolean createWorkingDirectories() {
        if (f.isDirectory()) {
            File notesappFile = new File(this.path + notesapp);
            File goalsFile = new File(this.path + goals);
            File planningFile = new File(this.path + planning);
            File notepadFile = new File(this.path + notepad);
            File mailFile = new File(this.path + mail);
            File outlineFile = new File(this.path + outline);
            File diagramsFile = new File(this.path + diagrams);
            File dashboardFile = new File(this.path + dashboard);

            notesappFile.mkdirs();
            notepadFile.mkdirs();
            goalsFile.mkdirs();
            planningFile.mkdirs();
            mailFile.mkdirs();
            outlineFile.mkdirs();
            diagramsFile.mkdirs();
            dashboardFile.mkdirs();

            return true;

        } else {
            return false;
        }
    }

    /**
     * method is not ready. Must be own stage. Export any to any another.
     */
    public void exportRecent() {
        TODOutil util = new TODOutil();
        System.err.println("todo");
        util.todooo();
    }
}
