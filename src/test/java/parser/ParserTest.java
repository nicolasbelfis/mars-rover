package parser;

import command.*;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class ParserTest {

  @Test
  public void should_get_forward_command() {
    final Optional<Command> command = CommandParser.apply("F", null);
    assertEquals(command.get().getClass(), CommandForward.class);
  }

  @Test
  public void should_not_get_command() {
    final Optional<Command> command = CommandParser.apply("S", null);
    assertEquals(command.isPresent(), false);
  }

  @Test
  public void should_retreive_command_list() {
    String commandLine = "F-B-L-R";
    final List<Command> commands = CommandParser.getCommands(commandLine, null);
    assertEquals(commands.get(0).getClass(), CommandForward.class);
    //TODO create other command classes
    assertEquals(commands.get(1).getClass(), CommandBackward.class);
    assertEquals(commands.get(2).getClass(), CommandLeft.class);
    assertEquals(commands.get(3).getClass(), CommandRight.class);
  }

  @Test(expected = IllegalArgumentException.class)
  public void should_throw_exception() {
    String commandLine = "FBDLR";
    final List<Command> commands = CommandParser.getCommands(commandLine, null);
  }
}
