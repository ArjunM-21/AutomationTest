package LoginTestRunner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class) 
@CucumberOptions(
		features = {"src/main/java/Feature/Login.feature"},
		publish=true,
		glue = {"LoginStepDefinitions"}) // StepDefinition package name
public class LoginTest{}

