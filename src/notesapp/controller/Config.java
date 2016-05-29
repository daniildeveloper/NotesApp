package notesapp.controller;

/**
 *
 * @author Lama
 */
public class Config {

    private static Config Config;

    public boolean createConfig() {

        return false;
    }

    public boolean openConfig() {
        return false;
    }

    public boolean getProperty(String property) {
        return false;
    }

    public boolean setProperty(String property) {
        return false;
    }

    public void parseConfig() {

    }

    private Config() {

    }

    public static Config getInstance() {
        if (Config == null) {
            Config = new Config();
        }
        return Config;
    }

}
