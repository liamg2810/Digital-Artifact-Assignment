package mmu.liam.ac.uk.Server.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class TestController {

    private static final Logger logger = Logger.getLogger(TestController.class.getName());

    @GetMapping("/")
    String Get() {
        logger.log(Level.INFO, "Request came in");
        return "Hello world!";
    }

    @PostMapping("/")
    String Post(@RequestBody String message) {
        logger.log(Level.INFO, "Received message: " + message);
        return "Rad";
    }

}
