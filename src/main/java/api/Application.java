package api;

import domain.Grid;
import domain.Obstacle;
import domain.Position;
import handler.RoverHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Application {

  public static void main(String... args) {
    SpringApplication.run(Application.class, args);
  }

  /**
   * initiate app with a grid of 10 by 10 and 2 obstacles at 2,2 and 4,4
   *
   * @return
   */
  @Bean
  public RoverHandler getRoverHandler() {
    final Grid grid = new Grid(Arrays.asList(new Obstacle(new Position(2, 2)), new Obstacle(new Position(4, 4))), 10, 10);
    return new RoverHandler(grid);

  }
}
