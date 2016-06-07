package util;

import java.sql.ResultSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author daniiltserin
 */
public class SQLiteUtilTest {

    public SQLiteUtilTest() {
    }

    String app = "app";

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createTable method, of class SQLiteUtil.
     */
    @Test
    public void testCreateTable() {
        System.out.println("createTable");
        String tableName = "";
        String fieldsSql = "";
        SQLiteUtil instance = null;
        instance.createTable(tableName, fieldsSql);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class SQLiteUtil.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        String sql = "";
        SQLiteUtil instance = null;
        instance.insert(sql);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of select method, of class SQLiteUtil.
     */
    @Test
    public void testSelect() {
        System.out.println("select");
        String query = "";
        SQLiteUtil instance = null;
        ResultSet expResult = null;
        ResultSet result = instance.select(query);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of workspaceInDB method, of class SQLiteUtil.
     */
    @Test
    public void testWorkspaceInDB() {
        System.out.println("workspaceInDB");
        SQLiteUtil instance = new SQLiteUtil("app");
        boolean expResult = false;
        boolean result = instance.workspaceInDB();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
