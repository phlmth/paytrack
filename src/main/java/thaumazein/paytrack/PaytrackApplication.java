package thaumazein.paytrack;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaytrackApplication {

  public static void main(String[] args) {
    Dotenv.configure().ignoreIfMissing().systemProperties().load();

    SpringApplication.run(PaytrackApplication.class, args);
  }
}
