package edu.marist.ds;

/**
 * App utility class for constants.
 */
public final class CONSTANTS {
    private static String appName = "thisisamerica";
    private static String version = "1.0.0";

    private CONSTANTS() {
    }

    /**
     * App version getter.
     * @return Version string of app
     */
    public static String getVersion() {
        return version;
    }

    /**
     * App name getter.
     * @return App name string
     */
    public static String getAppName() {
        return appName;
    }
}

