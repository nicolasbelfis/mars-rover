package api.controller;

import api.repository.RoverRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class RoverController {

  private final RoverRepository roverRepository;

  public RoverController(@Autowired RoverRepository roverRepository, @Autowired ObjectMapper objectMapper) {
    this.roverRepository = roverRepository;
  }

  @PostMapping(value = "/commandRover")
  public ResponseEntity createTransaction(@Valid @RequestBody String commandLine, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    return ResponseEntity.status(HttpStatus.CREATED).body("response " + commandLine);
  }

  @ExceptionHandler(MismatchedInputException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public void parsingErrorHandler(MismatchedInputException e) {
  }

  @ExceptionHandler(InvalidFormatException.class)
  @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
  public void parsinErrorHandler(InvalidFormatException e) {
  }
}
