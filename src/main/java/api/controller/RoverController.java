package api.controller;

import api.repository.RoverRepository;
import api.response.Response;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import command.Command;
import invoker.Invoker;
import invoker.InvokerResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import parser.CommandParser;

import javax.validation.Valid;
import java.util.List;


@RestController
public class RoverController {

  private final RoverRepository roverRepository;
  private final ObjectMapper objectMapper;

  public RoverController(@Autowired RoverRepository roverRepository, @Autowired ObjectMapper objectMapper) {
    this.roverRepository = roverRepository;
    this.objectMapper = objectMapper;
  }

  @PostMapping(value = "/commandRover", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity createTransaction(@Valid @RequestBody String commandLine, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    roverRepository.getRoverHandler();
    final List<Command> commands = CommandParser.getCommands(commandLine, roverRepository.getRoverHandler());
    final InvokerResult invokerResult = Invoker.applyCommands(commands, roverRepository.findRover());
    roverRepository.saveRover(invokerResult.getRover());
    Response response = new Response(
      invokerResult.getRover().getPosition().getX() + "," + invokerResult.getRover().getPosition().getY(),
      invokerResult.getObstacle().map(obstacle -> obstacle.getPosition().getX() + "," + obstacle.getPosition().getY()).orElse(null));
    objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(response);
  }

  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public void parsingErrorHandler(IllegalArgumentException e) {
  }

}
