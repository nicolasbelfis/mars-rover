import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import static org.junit.Assert.assertEquals;


public class AcceptanceTestSteps extends WebStarter {

  private String commandLine;
  private ResponseEntity<String> exchange;

  @Given("^a command line (.*?)$")
  public void given_a_command_line(String commandLine) throws URISyntaxException {
    this.commandLine = commandLine;
    System.out.println(commandLine);
  }

  @When("^I call POST on (.*?)$")
  public void when_call_api(String uri) throws URISyntaxException {
    exchange = testRestTemplate.exchange(RequestEntity.post(new URI("http://localhost:" + port + uri)).body(commandLine), String.class);
  }

  @Then("^I get http response code (.*?)$")
  public void then_get_code(String code) {
    assertEquals(code, exchange.getStatusCode().toString());
  }

  @And("^I get response body (.*?)$")
  public void and_get_body(String body) {
    String bodyFromResponse = Optional.ofNullable(exchange.getBody()).orElse("");
    assertEquals(body, bodyFromResponse);
  }
}
