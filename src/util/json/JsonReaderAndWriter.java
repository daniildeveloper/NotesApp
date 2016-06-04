package util.json;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lama
 */
public abstract class JsonReaderAndWriter {

    /**
     * string contains pathname where json file is
     */
    private String pathName;

    /**
     * Uri where json string contains
     */
    private URI uri;

    /**
     * GSON class examplar. Realy this class is wrapping around Gson libray for
     * in project use.
     */
    private Gson gson;

    /**
     * File with them we work
     */
    private File file;

    /**
     * Buffer where file contains when we work with him
     */
    private BufferedReader bufferedReader;

    /**
     * Usually API read json from string with json data
     */
    private String jsonAsString;

    /**
     * in xml is simpleras here. If file for config is, than main json object
     * must be "config"
     */
    private JsonObject mainJsonObject;

    private JsonElement root;

    /**
     * Create an JsonReaderAndWriter class exemplar for use it to read or write
     * some data
     *
     * @param pathName whre file is
     */
    public JsonReaderAndWriter(String pathName) {
        this.pathName = pathName;
        fileFromStringtoBuffer();
        try {
            jsonAsString = makeJsonString();
        } catch (IOException ex) {
            Logger.getLogger(JsonReaderAndWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Create an JsonReaderAndWriter class exemplar for use it to read or write
     * some data
     *
     * @param uri where file is
     */
    public JsonReaderAndWriter(URI uri) {
        this.uri = uri;
        fileFromUriToBuffer();
        try {
            jsonAsString = makeJsonString();
        } catch (IOException ex) {
            Logger.getLogger(JsonReaderAndWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * take file to buffer using string with pathname
     */
    private void fileFromStringtoBuffer() {
        file = new File(pathName);
        try {
            Reader reader = new InputStreamReader(new FileInputStream(file));
            this.bufferedReader = new BufferedReader(reader);
        } catch (FileNotFoundException ex) {

        }

    }

    /**
     * put file in to buffer using uri with location of file
     */
    private void fileFromUriToBuffer() {
        file = new File(uri);
        try {
            Reader reader = new InputStreamReader(new FileInputStream(file));
            this.bufferedReader = new BufferedReader(reader);
        } catch (FileNotFoundException ex) {

        }
    }

    /**
     * Take json data from buffer and put it into string
     *
     * @return
     * @throws IOException
     */
    private String makeJsonString() throws IOException {
        String lineString = bufferedReader.readLine();
        StringBuilder sb = new StringBuilder();

        while (lineString != null) {
            sb.append(lineString).append("\n");
            lineString = bufferedReader.readLine();
        }

        String fileAsString = sb.toString();
        return fileAsString;
    }

    public void initMainObject(String s) {
        root = new JsonParser().parse(jsonAsString);
        mainJsonObject = root.getAsJsonObject().get(s).getAsJsonObject();

    }

    public String getSomeProperty(String key) {
        return mainJsonObject.getAsJsonObject().get(key).getAsJsonObject().toString();
    }

}
