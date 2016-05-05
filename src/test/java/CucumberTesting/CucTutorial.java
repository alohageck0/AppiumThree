package CucumberTesting;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "/Users/royalfiish/IdeaProjects/UdemyAppium/src/test/java/CucumberTesting/test.feature",
        format = {"html:output"})
public class CucTutorial {


}
