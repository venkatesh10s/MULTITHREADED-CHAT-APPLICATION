package client.utils;

public class StyleUtil {
    public static String stylize(String name, String msg) {
        return "[ " + name.toUpperCase() + " ] >>> " + msg;
    }
}
