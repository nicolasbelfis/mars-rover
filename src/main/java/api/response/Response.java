package api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {

  private final String roverPosition;
  private final String obstaclePosition;

  public Response(String roverPosition, String obstaclePosition) {
    this.roverPosition = roverPosition;
    this.obstaclePosition = obstaclePosition;
  }

  @JsonProperty(value = "obstacle position")
  public String getObstaclePosition() {
    return this.obstaclePosition;
  }

  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  @JsonProperty(value = "rover position")
  public String getRoverPosition() {
    return this.roverPosition;
  }
}
