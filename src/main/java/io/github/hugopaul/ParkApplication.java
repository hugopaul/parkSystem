package io.github.hugopaul;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ParkApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParkApplication.class, args);
    }
}
