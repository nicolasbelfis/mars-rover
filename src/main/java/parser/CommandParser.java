package parser;

import command.Command;
import command.CommandForward;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CommandParser {

  static List<Command> getCommands(String commandLine) {
    return Arrays.asList(commandLine.split("-")).stream()
      .map(CommandParser::apply)
      .map(command -> command.orElseThrow(() -> new IllegalArgumentException("bad command format")))
      .collect(Collectors.toList());
  }

  static Optional<Command> apply(String s) {
    switch (s) {
      case "F":
        return Optional.of(new CommandForward(null));
      default:
        return Optional.empty();
    }
  }
}
