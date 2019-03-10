package api.repository;

import domain.Rover;
import handler.RoverHandler;

public interface RoverRepository {
  RoverHandler getRoverHandler();

  Rover findRover();

  void saveRover(Rover rover);
}
