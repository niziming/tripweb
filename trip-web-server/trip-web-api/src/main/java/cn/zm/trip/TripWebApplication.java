package cn.zm.trip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
  (scanBasePackages = {"cn.zm"})
public class TripWebApplication {
  public static void main(String[] args) {
    SpringApplication.run(TripWebApplication.class, args);
  }
}
