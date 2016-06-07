package notesapp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import notesapp.controller.Workspace;
import util.SQLiteUtil;

/**
 *
 * class contains all params for configs
 *
 * @author daniiltserin
 */
public class Conf {

    private static Conf configuration;

    private SQLiteUtil util = new SQLiteUtil("app");

    public static Conf getInstance() {
        if (configuration == null) {
            configuration = new Conf();

        }
        return configuration;
    }

    private Conf() {

    }

    /**
     * workspace
     */
    private Workspace workspace = Workspace.getInstance();

    /**
     * absolute path to workspace location
     */
    private String workspaceLocation = workspace.getPath();

    /**
     * get absolute path to workspace location
     *
     * @return string with path
     */
    public String getWorkspaceLocation() {
        return workspaceLocation;
    }

    public void setWorkspaceLocation(String workspaceLocation) {
        this.workspaceLocation = workspaceLocation;
    }

    /**
     * check if workspace path in db is
     *
     * @return
     */
    public boolean workspaceInDB() {
        String workspace = null;
        try {
            ResultSet rs = util.select("select * from configuration");
            workspace = rs.getString("workspace");
        } catch (SQLException ex) {
            Logger.getLogger(Conf.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (workspace == "" || workspace == null) {
            return false;

        } else {
            return true;
        }

    }

    /**
     * initialize sqlite db
     */
    public void initDB() {
        String fieldsForConfiguration = "(id int primary key not null,"
                + "fieldname text not null,"
                + "value text not null)";
        util.createTable("configuration", fieldsForConfiguration);
    }

}
