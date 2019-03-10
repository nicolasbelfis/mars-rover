package parser;

import command.*;
import handler.RoverHandler;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CommandParser {

  public static List<Command> getCommands(String commandLine, RoverHandler roverHandler) {
    return Arrays.asList(commandLine.split("-")).stream()
      .map(s -> CommandParser.apply(s, roverHandler))
      .map(command -> command.orElseThrow(() -> new IllegalArgumentException("bad command format")))
      .collect(Collectors.toList());
  }

  static Optional<Command> apply(String s, RoverHandler roverHandler) {
    switch (s) {
      case "F":
        return Optional.of(new CommandForward(roverHandler));
      case "B":
        return Optional.of(new CommandBackward(roverHandler));
      case "L":
        return Optional.of(new CommandLeft(roverHandler));
      case "R":
        return Optional.of(new CommandRight(roverHandler));
      default:
        return Optional.empty();
    }
  }
}
