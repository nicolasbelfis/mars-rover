package parser;

import command.Command;
import command.CommandForward;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class ParserTest {

  @Test
  public void should_get_forward_command() {
    final Optional<Command> command = CommandParser.apply("F");
    assertEquals(command.get().getClass(), CommandForward.class);
  }

  @Test
  public void should_not_get_command() {
    final Optional<Command> command = CommandParser.apply("S");
    assertEquals(command.isPresent(), false);
  }

  @Test
  public void should_retreive_command_list() {
    String commandLine = "FBLR";
    final List<Command> commands = CommandParser.getCommands(commandLine);
    assertEquals(commands.get(0).getClass(), CommandForward.class);
    //TODO create other command classes
    assertEquals(commands.get(1).getClass(), CommandForward.class);
    assertEquals(commands.get(2).getClass(), CommandForward.class);
    assertEquals(commands.get(3).getClass(), CommandForward.class);
  }

  @Test(expected = IllegalArgumentException.class)
  public void should_throw_exception() {
    String commandLine = "FBDLR";
    final List<Command> commands = CommandParser.getCommands(commandLine);
  }
}
