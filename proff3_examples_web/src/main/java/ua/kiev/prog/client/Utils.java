package ua.kiev.prog.client;

public class Utils {
    //    192.168.0.103
//    private static final String URL = "http://127.0.0.1";
    private static final String URL = "http://192.168.0.1";
    private static final int PORT = 8080;

    public static String getURL() {
        return URL + ":" + PORT;
    }
}