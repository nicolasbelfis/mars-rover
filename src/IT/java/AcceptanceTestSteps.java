import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.net.URISyntaxException;


public class AcceptanceTestSteps extends WebStarter {

  private String commandLine;

  @Given("^a command line (.*?)$")
  public void given_a_command_line(String commandLine) throws URISyntaxException {
    this.commandLine = commandLine;
    System.out.println(commandLine);
  }

  @When("^I call POST on (.*?)$")
  public void when_call_api(String uri) throws URISyntaxException {
    final ResponseEntity<String> exchange = testRestTemplate.exchange(RequestEntity.post(new URI("http://localhost:" + port + uri)).body(commandLine), String.class);
    throw new PendingException();

  }

  @Then("^I get http response code (.*?)$")
  public void then_get_code(String code){
    throw new PendingException();
  }

  @And("^I get response body (.*?)$")
  public void and_get_body(String body){
    throw new PendingException();
  }
}
