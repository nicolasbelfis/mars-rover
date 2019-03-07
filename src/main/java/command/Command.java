package command;

import domain.Rover;

public interface Command {

  Rover execute(Rover rover);
}
