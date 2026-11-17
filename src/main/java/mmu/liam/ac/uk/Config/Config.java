package mmu.liam.ac.uk.Config;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class Config {
    public static String Ip = "127.0.0.1";
    public static int Port = 8080;
    public static URL Url() throws MalformedURLException {
        var uri = URI.create("http://" + Ip + ":" + Port);

        return uri.toURL();
    }
}
