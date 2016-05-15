package util.workspace;

import java.io.File;

/**
 *
 * @author Lama
 */
public class WorkspaceUtil {

    public String workspaceName;
    private File workspace;

    private String notesapp = "/.notesapp";
    private String goals = "/goals";
    private String planning = "/planning";
    private String notepad = "/notepad";
    private String mail = "/mail";
    private String outline = "/outline";
    private String diagrams = "/diagrams";

    public boolean createWorkspace() {
        workspace = new File(workspaceName);
        System.out.println("util.workspace.WorkspaceUtil.createWorkspace()");


        if (workspace.isDirectory()) {
            File notesappFile = new File(workspaceName + notesapp);
            File goalsFile = new File(workspaceName + goals);
            File planningFile = new File(workspaceName + planning);
            File notepadFile = new File(workspaceName + notepad);
            File mailFile = new File(workspaceName + mail);
            File outlineFile = new File(workspaceName + outline);
            File diagramsFile = new File(workspaceName + diagrams);

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

    public WorkspaceUtil(String workspaceName) {
        this.workspaceName = workspaceName;
    }


}
