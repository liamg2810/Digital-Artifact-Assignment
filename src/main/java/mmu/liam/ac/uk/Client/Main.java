package mmu.liam.ac.uk.Client;

import mmu.liam.ac.uk.Config.Config;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        URL url;

        try {
            url = Config.Url();
        } catch (MalformedURLException e) {
            logger.log(Level.SEVERE, "Error getting URL from Config");
            return;
        }

        logger.log(Level.INFO, "Url: " + url.toString());

        HttpURLConnection con;

        try {
            con = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Unable to open URL connection");
            return;
        }

        try {
            con.setRequestMethod("POST");
        } catch (ProtocolException e) {
            logger.log(Level.SEVERE, "Unable to set request method");
            return;
        }

        con.setRequestProperty("Content-Type", "application/json");

        String jsonInputString = "Hello World!";

        con.setDoOutput(true);

        try(OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            int status = con.getResponseCode();
            logger.log(Level.INFO, "Status: " + status);

            try (var in = status < 400 ? con.getInputStream() : con.getErrorStream()) {
                if (in != null) {
                    logger.log(Level.INFO, new String(in.readAllBytes(), StandardCharsets.UTF_8));
                }
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error sending request: " + e);
        } finally {
            con.disconnect();
        }
    }
}
