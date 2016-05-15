package util;

import util.workspace.WorkspaceUtil;

/**
 *
 * @author Lama
 */
public class MainUtil {
    public static void main(String[] args) {
        WorkspaceUtil util = new WorkspaceUtil("C:/users/lama/desktop/new");
        System.out.println("sss");
        util.createWorkspace();

    }
}
