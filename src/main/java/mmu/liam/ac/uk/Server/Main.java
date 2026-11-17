package mmu.liam.ac.uk.Server;

import mmu.liam.ac.uk.Config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        var app = new SpringApplication(Main.class);
        app.setDefaultProperties(Map.of("server.address", Config.Ip, "server.port", Config.Port));
        app.run();
    }
}
